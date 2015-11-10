#include<stdio.h>
void foo (int a, int b) {
  if (b == 0) 
    return;

  printf("%d", a / b);
  return;
}

int main() {
  int a, b;
  a = 100;
  b = 500;
  foo(a, b);
  return 0;
}
