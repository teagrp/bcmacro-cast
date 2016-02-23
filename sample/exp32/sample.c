int main() {
  volatile int i;
  volatile int *p;

  p = &i;
  if (*(int*)p) {
  }
}
