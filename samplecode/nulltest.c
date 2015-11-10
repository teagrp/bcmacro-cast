#include<stdio.h>

int main() {
  void *p = 0x0;
  int *q = 0x0;
  char *r;
  int n = 0;

  if (p == NULL) {
    n++;
  } else {
    n--;
  }

  return 0;
}
