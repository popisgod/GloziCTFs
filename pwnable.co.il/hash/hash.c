#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <openssl/md5.h>

char flag_str[0x100];

void init_buffering() {
    setvbuf(stdin, NULL, 2, 0);
    setvbuf(stdout, NULL, 2, 0);
    setvbuf(stderr, NULL, 2, 0);
    alarm(60);
}

int main() {
    init_buffering();
    unsigned char flag_hash[MD5_DIGEST_LENGTH];
    MD5_CTX flag;
    MD5_Init(&flag);
    int fd = open("flag", O_RDONLY);
    int bytes = read(fd, &flag_str, 0x100);
    close(fd);
    MD5_Update(&flag, flag_str, bytes);
    MD5_Final(flag_hash, &flag);
    puts("Flag MD5: ");
    for(int i = 0; i < MD5_DIGEST_LENGTH; i++) printf("%02x", flag_hash[i]);
    puts("");

    printf("Enter your guess: ");
    char guess_hash[MD5_DIGEST_LENGTH];
    char* guess = malloc(bytes+1);
    bytes = read(0, guess, bytes);
    MD5_CTX guess_ctx;
    MD5_Init(&guess_ctx);
    MD5_Update(&guess_ctx, guess, bytes);
    MD5_Final(guess_hash, &guess_ctx);
    if (!strcmp(flag_hash, guess_hash)) {
        puts("Congrats!!!");
        puts(flag_str);
    } else {
        puts("Wrong!!");
    }
    return 1;
}