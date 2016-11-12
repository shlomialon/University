#include <stdio.h>

int main(int argc, char * argv[]){
   
    int c; 
   
    printf("input a char: \n");
    c = getchar();
    
    if(c <= 57 && c >= 48){
        int d;
        d = 48 - c;
        printf("After:  %d", d*d);
    }
    
    if(c >= 65 && c <= 90){
         printf("After:  %c", c + 32);
    }
    
    if( c >= 97 && c <= 122){
         printf("After:  %c", c - 32);
    }
    
    return 0;
}