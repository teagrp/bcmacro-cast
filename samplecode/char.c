char a;
char b = 'c';

char charactor(char moji) {
  char ans;

  ans = moji + b;

  return ans;
}

int main() {
  
  char moji;
  moji = 'A';
  
  charactor(moji);
  return 0;
}
