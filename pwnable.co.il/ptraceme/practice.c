#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/ptrace.h>
#include <stdint.h>

#define SHELLCODE_SIZE 32
unsigned char *hello_shellcode=
"\x31\xc0\xb0\x04\xeb\x0f\x31\xdb\x43\x59"
"\x31\xd2\xb2\x0d\xcd\x80\xa1\x78\x56\x34"
"\x12\xe8\xec\xff\xff\xff\x48\x65\x6c\x6c"
"\x6f\x2c\x57\x6f\x72\x6c\x64\x20\x21" ;
/* Prints hello. What a deal ! */



int main(){
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
        

        inject_code(pid, hello_shellcode, (void *)0x040119a, SHELLCODE_SIZE);
        ptrace(PTRACE_DETACH, pid, NULL, NULL);

    }
    return 0; 
}

int inject_code(pid_t pid, unsigned char *src, void *dst, int len) {
    int i; 
    uint32_t *s = (uint32_t *) src;
    uint32_t *d = (uint32_t *) dst;

    for (i = 0; i < len; i +=4, s++, d++){
        if ((ptrace(PTRACE_POKEDATA, pid, d, *s)) < 0)
        {
            perror("ptrace(POKETEXT):");
            return -1; 
        }
        printf("successfuly injected \n");
    }
    return 0; 
}