#include <stdio.h>

#define Array_SIZE 10

int main() {
  int arr[Array_SIZE];
  int c = 0;
  while (c < Array_SIZE) {
    arr[c] = c - 1;
    printf("%d, %d\n", c, arr[c]);
  }

  return 0;
}
