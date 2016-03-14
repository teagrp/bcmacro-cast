void f() {
  int a = 10;
  int b = 20;

  if (a = b) {
    a = a + b;
  }

}


void g() {
  int c = 30;
  int d = 40;
   
  while (c = d) {
    c = c + d;
  }
  int i;
  for (i = 0; i = c; i++) {
    i++;
  }

  if ((c = d)) {
    c = c + d;
  }

  do {c = 100;} while (f(), c = d);
  
}
