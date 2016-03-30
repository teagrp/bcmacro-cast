typedef struct {
  int some_field;
} S;

int f(void* p) {
  return ((S*) p)->some_field;
}
