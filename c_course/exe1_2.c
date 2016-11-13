
#include <stdio.h>

int getY(float a,float b,float c,float d ,int x, int Y) {
    float value = 0;
    
    value = a + (b*x) + (c*x*x) + (d*x*x*x);
    
    return value;
}

int crategraph(float a,float b,float c,float d){

    for(int y=10 ;y >= -10; y--){
        for(int x=-35 ;x <= 35 ;x++){
           int temp = getY(a, b, c, d, x, y);
            if (temp == y){
                printf("*");
            } else if (x ==0 && y==0) {
                printf("+");
            } else if (x == 0 ){
                printf("|");
            } else if (y == 0) {
                printf("-");
            } else {
                printf(" ");
            }
              if (x == 35) {
                printf("\n");
            }
        }
    }
}
        

int main(int argc, const char * argv[]) {
    float a,b,c,d;
    
    printf("y(x)=a+b*x+c*x^2+d*x^3\n");
    printf("Select a:\n");
    scanf("%f", &a);
    printf("Select b:\n");
    scanf("%f", &b);
    printf("Select c:\n");
    scanf("%f", &c);
    printf("Select d:\n");
    scanf("%f", &d);
    printf("y(x)=(%0.3f)+(%0.3f)*x+(%0.3f)*x^2+(%0.3f)*x^3\n", a, b, c, d);
   
   crategraph(a, b, c, d);
   
    return 0;
}
