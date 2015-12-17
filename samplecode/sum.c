#include<stdio.h>

int sum(int n) {
  int init = 1, sum = 0;
  while (init <= n) {
    sum += init;
    //init++;
  }
  return sum;
}

int main() {
  int num = 10;
  printf("result_sum = %d", sum(num));
  
  return 0;
}
