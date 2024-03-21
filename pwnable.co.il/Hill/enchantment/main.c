#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LOCKET_SIZE 256

char locket[LOCKET_SIZE];

void init_buffering() {
    setvbuf(stdin, NULL, 2, 0);
    setvbuf(stdout, NULL, 2, 0);
    setvbuf(stderr, NULL, 2, 0);
}

void parse_action(char* action, char* dest_action, long int* index) {
    int idx = 0;
    int size = 0;
    while (action[idx] != ' ') {
        size++;
	    idx++;
    }
    memcpy(dest_action, action, size);
    char number[16];
    strcpy(number, action+size+1);
    *index = atoll(number);
}

void apply_action(char* input) {
    char action[16];
    long index;
    memset(action, 0, 16);
    parse_action(input, action, &index);

    if (strcmp(action, "open") == 0) {
        if (index < 0 || index >= LOCKET_SIZE) {
            printf("Index out of range\n");
            return;
        }
        locket[index] = '+';
    } else if (strcmp(action, "close") == 0) {
        if (index < 0 || index >= LOCKET_SIZE) {
            printf("Index out of range\n");
            return;
        }
        locket[index] = '-';
    } else if (strcmp(action, "check") == 0) {
        printf("%c\n", locket[index]);
    } else {
        printf("Invalid action\n");
    }
}

int main(int argc, char **argv) {
    init_buffering();
    char input[128];
    while (1) {
        printf("> ");
        fgets(input, 128, stdin);
        input[strlen(input) - 1] = '\0';
        apply_action(input);
    }
    return 0;
}
