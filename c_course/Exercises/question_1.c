#include <stdio.h>

int main(int argc, char const *argv[]) {
    double k;
    printf("enter a number: ");
    scanf("%lf",&k);
 
  if(k < 0)
    printf("Negative Input\n");
  else
      printf("the circle: %lf \n", 2*3.14159265359*(k/2));
  return 0;
}
