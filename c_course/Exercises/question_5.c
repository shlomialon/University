#include<stdio.h>

int main(int args,char const argv[]){
    
    int x = 100;
    
    while(x <= 500){
        if((x/100 != x/10%10) && (x%100 != x%10) && (x/10%10 != x%10))
            printf(",%d",x);
        x++;
    }
    return 0;
}