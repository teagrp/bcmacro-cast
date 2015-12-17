#include  <stdio.h>
#include  <stdlib.h>      /* exit(  ) で必要 */

void main(void);

void main(void)     /* この部分訂正 */
{
  int c;

  /* long 型整数の初期化には L を付ける */
  long sign = 1L, result = 0L, temp = 0L;

  printf("16 進数を入力して下さい\t");

  while ((c = getchar(  )) != '\n') {
    switch (c) {
    case  ' ':                   /* スペースと */
    case  '\t':                  /* タブは */
      break;                   /* 読み飛ばす */
    case '+' : break;            /* '+' も読み飛ばす */
    case '-' : sign = -1L;       /*  '-' の時の処理 */
      break;
    case '0' :                   /* ０から９なら */
    case '1' :
    case '2' :
    case '3' : 
    case '4' : 
    case '5' : 
    case '6' : 
    case '7' : 
    case '8' : 
    case '9' : temp = c - '0';    /* 数字に変換 */
      break;
    case 'A' :                    /* 'a' から 'f' または、'A' から 'F' なら */
    case 'a' : temp = 10;         /* 以下の処理をする */
      break;
    case 'B' : 
    case 'b' : temp = 11;
      break;
    case 'C' : 
    case 'c' : temp = 12;
      break;
    case 'D' : 
    case 'd' : temp = 13;
      break;
    case 'E' : 
    case 'e' : temp = 14;
      break;
    case 'F' : 
    case 'f' : temp = 15;
      break;
    default  : fprintf(stderr, "不正な文字\n");  /* 不正な文字なら */
      exit(2);                                    /* プログラムを終了 */
    }
    result = result * 16L + temp;                   /* １０進数に変換 */
  }
  result = result * sign;                 /* 符号の処理 */
  printf("\n10 進数では %ld\n", result);
}
