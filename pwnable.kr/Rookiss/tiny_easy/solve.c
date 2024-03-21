#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>


int main() {

    // Open the input file
    int input_fd = open("solve.txt", O_RDONLY);
    if (input_fd == -1) {
        perror("Error opening input file");
        return 1;
    }

    // Read the string from the file
    char string[100] = { 0 };
    ssize_t bytes_read = read(input_fd, string, sizeof(string));
    if (bytes_read == -1) {
        perror("Error reading from file");
        close(input_fd);
        return 1;
    }
    close(input_fd);

    
    // Prepare arguments for execve
    char *args[] = {string, NULL};

    // Execute the specified executable with the string as the first argument
    if (execve("./tiny_easy", args, NULL) == -1) {
        perror("Error executing program");
        return 1;
    }

    return 0;
}
