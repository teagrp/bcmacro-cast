#include <stdio.h>

int result(int num) {
  return (num + 100) % 2;
}

int main(void) {
  int num;
  printf("整数を入力してください\n");
  scanf("%d", &num);

  if (num < 10) 
    num = num * 100;

  if ((num % 2) == 0) { 
    printf("%dは偶数です\n", num);
  } else {
    printf("%dは奇数です\n", num);
  }

  if (num == 0) {
    printf("%dは偶数です2\n", num);
  }

  if (num == 1) {
    printf("%dは偶数です3\n", num);
  } else if (num == 2) {
    printf("%dは偶数です4\n", num);
  } else {
    printf("%dは偶数です5\n", num);
  }
  
  if (result(num)) {
    printf("%dは偶然です\n", num);
  }
  return 0;
}
