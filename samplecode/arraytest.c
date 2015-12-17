int main() {
  int a[10];
  int b[] = {1, 
	     2, 
	     3, 
	     4, 
	     5, 
	     6, 
	     7, 
	     8, 
	     9, 
	     10};
  int d[15];
  int f[15];
  char c[20];
  char e[30];
  int i = 100;
  int *p;
  int g[10][10];
  
  d[2] = 13;
  f[9] = 22222;
  for (i = 0; i < 100; i++) {
    a[5] = i;
    b[i] = i + 1;
  }
  g[1][5] = 11;
  d[3] = a[b[1]];
  
  return 0;
}
