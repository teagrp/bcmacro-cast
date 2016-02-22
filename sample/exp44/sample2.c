typedef unsigned int size_t;

void f(size_t n) {
  size_t a = sizeof(int [++n]);
  size_t b = sizeof(int [++n % 1 + 1]);

}
