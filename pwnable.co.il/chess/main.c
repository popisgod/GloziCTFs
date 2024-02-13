#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <math.h>

#define WHITE 1
#define BLACK 0

void init_buffering() {
    setvbuf(stdin, NULL, 2, 0);
    setvbuf(stdout, NULL, 2, 0);
    setvbuf(stderr, NULL, 2, 0);
}

char board[8][8];
uint8_t is_admin = 0;

enum Pieces {
    ROOK = 'R',
    BISHOP = 'B',
    KNIGHT = 'N',
    QUEEN = 'Q',
    KING = 'K'
};

typedef struct chess_move {
    char piece;
    char is_capture;
    char rank_src, rank_dest;
    char file_src, file_dest;
} chess_move;

uint8_t validate_pawn_move(chess_move* out, uint8_t i, uint8_t j, uint8_t turn) {
    i = 7 - i;
    if (out->is_capture) {
        return abs(out->file_dest  - j) == 1 && abs(out->rank_dest - i) == 1;
    }
    if (turn == WHITE) {
        if (i != 1) {
            return out->file_dest == j && out->rank_dest == i+1;
        }
        return out->file_dest == j && out->rank_dest == i+2;
    } else {
        if (i != 6) {
            return out->file_dest == j && out->rank_dest == i-1;
        }
        return out->file_dest == j && out->rank_dest == i-2;
    }
}

uint8_t validate_bishop_move(chess_move* out, uint8_t i, uint8_t j, uint8_t turn) {
    i = 7 - i;
    if (turn == WHITE) {
        return abs(out->file_dest - j) == abs(out->rank_dest - i);
    }
    return abs(out->file_dest - j) == abs(out->rank_dest - i);
}

uint8_t validate_knight_move(chess_move* out, uint8_t i, uint8_t j) {
    i = 7 - i;
    return abs((i - out->rank_dest) * (j - out->file_dest)) == 2;
}

uint8_t validate_rook_move(chess_move* out, uint8_t i, uint8_t j) {
    i = 7 - i;
    return j == out->file_dest || i == out->rank_dest;
}

uint8_t validate_queen_move(chess_move* out, uint8_t i, uint8_t j, uint8_t turn) {
    return validate_bishop_move(out, i, j, turn) || validate_rook_move(out, i, j);
}

uint8_t validate_king_move(chess_move* out, uint8_t i, uint8_t j) {
    return abs(i - out->rank_dest) <= 1 && abs(j - out->file_dest) <= 1;
}

chess_move* parse_move_bishop(char* move, uint8_t turn) {
    // B was parsed out
    // [x][file][rank][check/checkmate]
    chess_move* out = malloc(sizeof(chess_move));
    if (turn == WHITE) {
        out->piece = 'B';
    } else {
        out->piece = 'b';
    }
    if (move[0] == 'x') {
        out->is_capture = 1;
        out->file_dest = move[1] - 'a';
        out->rank_dest = move[2] - '1';
        int found = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == out->piece && validate_bishop_move(out, i, j, turn)) {
                    out->file_src = j;
                    out->rank_src = i;
                    found = 1;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    } else {
        out->file_dest = move[0] - 'a';
        out->rank_dest = move[1] - '1';
        int found = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == out->piece && validate_bishop_move(out, i, j, turn)) {
                    out->file_src = j;
                    out->rank_src = i;
                    found = 1;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }
    return out;
}

chess_move* parse_move_knight(char* move, uint8_t turn) {
    // N was parsed out
    // [x][file][rank][check/checkmate] - [N][x]c3
    // [x][file][file][rank][check/checkmate] - [N][x]bd2
    // [x][rank][file][rank][check/checkmate] - [N][x]4e6
    chess_move* out = malloc(sizeof(chess_move));
    if (turn == WHITE) {
        out->piece = 'N';
    } else {
        out->piece = 'n';
    }
    if (move[0] == 'x') {
        out->is_capture = 1;
        if (strlen(move) == 4) {
            out->file_dest = move[2] - 'a';
            out->rank_dest = move[3] - '1';
            int found = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == out->piece && validate_knight_move(out, i, j)) {
                        out->file_src = j;
                        out->rank_src = i;
                        found = 1;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (move[1] >= '1' && move[1] <= '8') {
                out->rank_src = move[1] - '1';
            } else {
                out->file_src = move[1] - 'a';
            }
        } else { // strlen(move) == 3
            out->file_dest = move[1] - 'a';
            out->rank_dest = move[2] - '1';
            int found = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == out->piece && validate_knight_move(out, i, j)) {
                        out->file_src = j;
                        out->rank_src = i;
                        found = 1;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }
    } else {
        if (strlen(move) == 4) {
            out->file_dest = move[1] - 'a';
            out->rank_dest = move[2] - '1';
            int found = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == out->piece && validate_knight_move(out, i, j)) {
                        out->file_src = j;
                        out->rank_src = i;
                        found = 1;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (move[0] >= '1' && move[0] <= '8') {
                out->rank_src = move[0];
            } else if (move[0] >= 'a' && move[0] <= 'g') {
                out->file_src = move[0];
            }
        } else { // strlen(move) == 3
            out->file_dest = move[0] - 'a';
            out->rank_dest = move[1] - '1';
            int found = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == out->piece && validate_knight_move(out, i, j)) {
                        out->file_src = j;
                        out->rank_src = i;
                        found = 1;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }
    }
    return out;
}

chess_move* parse_move_rook(char* move, uint8_t turn) {
    // R was parsed out
    // [x][file][rank][check/checkmate] - [R][x]c3
    // [x][file][file][rank][check/checkmate] - [R][x]bd2
    // [x][rank][file][rank][check/checkmate] - [R][x]4e6
    chess_move* out = malloc(sizeof(chess_move));
    if (turn == WHITE) {
        out->piece = 'R';
    } else {
        out->piece = 'r';
    }
    if (move[0] == 'x') {
        out->is_capture = 1;
        if (strlen(move) == 4) {
            out->file_dest = move[2] - 'a';
            out->rank_dest = move[3] - '1';
            int found = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == out->piece && validate_rook_move(out, i, j)) {
                        out->file_src = j;
                        out->rank_src = i;
                        found = 1;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (move[1] >= '1' && move[1] <= '8') {
                out->rank_src = move[1] - '1';
            } else {
                out->file_src = move[1] - 'a';
            }
        } else { // strlen(move) == 3   7 - (move[2] - '1') = -1 | move[2] - '1' = 8 + '1' 
            out->file_dest = move[1] - 'a';
            out->rank_dest = move[2] - '1';
            int found = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == out->piece && validate_rook_move(out, i, j)) {
                        out->file_src = j;
                        out->rank_src = i;
                        found = 1;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }
    } else {
        if (strlen(move) == 4) {
            out->file_dest = move[1] - 'a';
            out->rank_dest = move[2] - '1';
            int found = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == out->piece && validate_rook_move(out, i, j)) {
                        out->file_src = j;
                        out->rank_src = i;
                        found = 1;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (move[0] >= '1' && move[0] <= '8') {
                out->rank_src = move[0] - '1';
            } else if (move[0] >= 'a' && move[0] <= 'g') {
                out->file_src = move[0] - 'a';
            }
        } else { // strlen(move) == 3
            out->file_dest = move[0] - 'a';
            out->rank_dest = move[1] - '1';
            int found = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == out->piece && validate_rook_move(out, i, j)) {
                        out->file_src = j;
                        out->rank_src = i;
                        found = 1;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }
    }
    return out;
}

chess_move* parse_move_queen(char* move, uint8_t turn) {
    // Q was parsed out
  c
    chess_move* out = malloc(sizeof(chess_move));
    if (turn == WHITE) {
        out->piece = 'Q';
    } else {
        out->piece = 'q';
    }
    if (move[0] == 'x') {
        out->is_capture = 1;
        out->file_dest = move[1] - 'a';
        out->rank_dest = move[2] - '1';
        int found = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == out->piece && validate_queen_move(out, i, j, turn)) {
                    out->file_src = j;
                    out->rank_src = i;
                    found = 1;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    } else {
        out->file_dest = move[0] - 'a';
        out->rank_dest = move[1] - '1';
        int found = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == out->piece && validate_queen_move(out, i, j, turn)) {
                    out->file_src = j;
                    out->rank_src = i;
                    found = 1;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }
    return out;
}

chess_move* parse_move_king(char* move, uint8_t turn) {
    // K was parsed out
    // [x][file][rank]
    chess_move* out = malloc(sizeof(chess_move));
    if (turn == WHITE) {
        out->piece = 'K';
    } else {
        out->piece = 'k';
    }
    if (move[0] == 'x') {
        out->is_capture = 1;
        out->file_dest = move[1] - 'a';
        out->rank_dest = move[2] - '1';
        int found = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == out->piece && validate_king_move(out, i, j)) {
                    out->file_src = j;
                    out->rank_src = i;
                    found = 1;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    } else {
        out->file_dest = move[0] - 'a';
        out->rank_dest = move[1] - '1';
        int found = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == out->piece && validate_king_move(out, i, j)) {
                    out->file_src = j;
                    out->rank_src = i;
                    found = 1;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }
    return out;
}

chess_move* parse_move_pawn(char* move, uint8_t turn) {
    chess_move* out = malloc(sizeof(chess_move));
    if (turn == WHITE) {
        out->piece = 'P';
    } else {
        out->piece = 'p';
    }
    if (move[1] == 'x') {
        out->is_capture = 1;
        out->file_dest = move[2] - 'a';
        out->rank_dest = move[3] - '1';
        int found = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == out->piece && validate_pawn_move(out, i, j, turn)) {
                    out->file_src = j;
                    out->rank_src = i;
                    found = 1;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        out->file_src = move[0] - 'a';
    } else {
        out->file_dest = move[0] - 'a';
        out->rank_dest = move[1] - '1';
        int found = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == out->piece && validate_pawn_move(out, i, j, turn)) {
                    out->file_src = j;
                    out->rank_src = i;
                    found = 1;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }
    return out;
}

void do_move(char board[8][8], chess_move move) {
    move.rank_dest = 7 - move.rank_dest;
    board[move.rank_src][move.file_src] = ' ';
    board[move.rank_dest][move.file_dest] = move.piece;
}

chess_move* parse_move(char* move, uint8_t turn) {
    switch (move[0]) {
        case BISHOP:
            return parse_move_bishop(move+1, turn);
        case KNIGHT:
            return parse_move_knight(move+1, turn);
        case ROOK:
            return parse_move_rook(move+1, turn);
        case QUEEN:
            return parse_move_queen(move+1, turn);
        case KING:
            return parse_move_king(move+1, turn);
        default:
            return parse_move_pawn(move, turn);
    }

}

void init_board() {
    // lowercase black, uppercase white
    memset(&board[0][0], ' ', 8 * 8);
    memcpy(&board[0][0], "rnbqkbnr", 8);
    memset(&board[1][0], 'p', 8);
    memset(&board[6][0], 'P', 8);
    memcpy(&board[7][0], "RNBQKBNR", 8);
} 

void print_board() {
    puts(" + + + + + + + + + + +");
    for (int i = 0; i < 8; ++i) {
        printf(" + |");
        for (int j = 0; j < 8; ++j) {
            printf("%c|", board[i][j]);
        }
        printf(" + \n");
    }
    puts(" + + + + + + + + + + +");
}

void banner() {
    puts("I made an interactive chess board for you to try");
    puts("Have fun!");
    puts("btw, we don't have en-passant support :)");
}

int main(int argc, char* argv[]) {
    init_buffering();
    init_board();
    banner();
    int turn = WHITE;
    while (1) {
        print_board();
        char buf[6]; // max pgn chess move size
        memset(buf, 0, 6);
        scanf("%6s", buf);
		if (!strcmp(buf, "admin")) {
			if (is_admin) {
				system("/bin/sh");
			}
            continue;
		}
        getchar();
        chess_move* move = parse_move(buf, turn);
        do_move(board, *move);
        turn = 1 - turn;
    }
}

