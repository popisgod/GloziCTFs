#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/ptrace.h>

void init_buffering() {
    setvbuf(stdin, NULL, 2, 0);
    setvbuf(stdout, NULL, 2, 0);
    setvbuf(stderr, NULL, 2, 0);
    alarm(60);
}

void print_menu() {
    puts("1. Ptrace call");
    puts("2. Finish");
}

int main() {
    init_buffering();
    puts("Do you know what ptrace is?");
    pid_t pid = fork();
    if (pid == 0) {
        ptrace(PTRACE_TRACEME, 0, NULL, NULL);
        exit(1);
    } else {
        long value = ptrace(PTRACE_ATTACH, pid, NULL, NULL);
        if (value == -1) {
            puts("Broken challenge, contact admin");
            return -1;
        }
        while (1) {
            print_menu();
            int choice = 0;
            scanf("%d", &choice);
            getchar();
            switch (choice) {
                case 1:
                    printf("Request: ");
                    int req = 0;
                    scanf("%d", &req);z` 
                    getchar();
                    printf("Address: ");
                    unsigned long long addr = 0;
                    scanf("%llu", &addr);
                    getchar();
                    printf("Data: ");
                    unsigned long long data = 0;
                    scanf("%llu", &data);
                    getchar();
                    unsigned long long value = ptrace(req, pid, addr, data);
                    printf("Value: %llx\n", value);
                    break;
                case 2:
                    ptrace(PTRACE_DETACH, pid, NULL, NULL);
                    wait(NULL);
                    break;
            }
        }
    }
}
