#include<stdio.h>

int main(int args,char const *argv[]){
    
    double num;
    printf("Enter your salary: ");
    scanf("%lf", &num);

    if(num >= 0 && num <= 10000)
        printf("%lf \n", num*0.10);
    else if(num > 10000 && num <= 20000)
        printf("%lf \n", num*0.20);
    else if(num > 20000 && num <= 30000)
        printf("%lf \n", num*0.30);
    else if(num > 30000 && num <= 40000)
        printf("%lf \n", num*0.40);
    else if(num > 40000 && num <= 50000)
        printf("%lf \n", num*0.50);
    return 0;
}