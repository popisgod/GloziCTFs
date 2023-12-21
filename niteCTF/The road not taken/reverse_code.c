#include <stdio.h>


void rightDirection(){
    printf("thank you for helping");
    printf("you got the flag congrats");
}
void wrongDirection(){
    printf("nice try, thanks for the help");
}



int main(){
   char buff[520];
   long long (*ptrFunction)(void);

   ptrFunction = wrongDirection;
   read(0, buff, 0x20Aull);

   char

   ptrFunction();
   return 0;
}
