#include <stdio.h>

int main(int argc,char const *argv[]){
  int sum;
  printf("Enter number please: ");
  scanf("%d",&sum);
  
  int count_50 = 0,count_20 = 0,count_10 = 0,count_1 = 0,count_5 = 0;
  
  while(sum > 0 && sum >= 50){
  count_50++;
  sum = sum - 50;
  }
  printf("the number of Bill 50:  %d \n" ,count_50);
  
  while(sum > 0 && sum >= 20){
  count_20++;
  sum = sum - 20;
  }
  printf("the number of Bill 20:  %d \n" ,count_20);
  
  while(sum > 0 && sum >= 10){
  count_10++;
  sum = sum - 10;
  }
  printf("the number of coins 10: %d \n" ,count_10);
  
  while(sum > 0 && sum >= 5){
  count_5++;
  sum = sum - 5;
  }
  printf("the number of coins 5:  %d \n" ,count_5);
  
  while(sum > 0 && sum >= 1){
  count_1++;
  sum = sum - 1;
  }
  printf("the number of coins 1:  %d \n" ,count_1);
  
  
  return 0;
}