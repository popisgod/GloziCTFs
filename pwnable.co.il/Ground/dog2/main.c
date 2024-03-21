 #include <wait.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

void init_buffering() {
    setvbuf(stdin, NULL, 2, 0);
    setvbuf(stdout, NULL, 2, 0);
    setvbuf(stderr, NULL, 2, 0);
    alarm(60);
}

int main() {
    char command[0x100];
    char name[0x20];
    init_buffering();
    memset(command, 0, 0x100);
    memset(name, 0, 0x20);
    puts("Hello!");
    puts("What's your name?");
    unsigned char length = read(0, name, 0x20);
    name[length-1] = '\x00';
    // now with escaping!
    sprintf(command, "echo 'Hello %s'", name);
    pid_t child = fork();
    if (child == 0) {
        execl("/bin/sh", "sh", "-c", command, NULL);
    } else {
        wait(NULL);
        puts("Thanks!");
    }       
}
