#include<stdio.h>

void add(int a, int b){
    printf("%d\n",a + b);
}

void subtract(int a, int b){
    printf("%d\n",a - b);
}

void multiply(int a, int b){
    printf("%d\n",a * b);
}

int main(int argc, const char * argv[]){
    int a;
    int b;
    int c;
    printf("Enter one number: ");
    scanf("%d",&a);
    printf("Enter the second number: ");
    scanf("%d",&b);
    printf("Enter operator 0 = + , 1 = - , 2 = * : ");
    scanf("%d",&c);
    
    void (*ptr_arr[])(int, int) = {add, subtract, multiply};
    if(c == 0)
        ptr_arr[0](a,b);
    if(c == 1)
        (ptr_arr[1])(a,b);
    if(c == 2)
        (ptr_arr[2])(a,b);
        
    return 0;
}