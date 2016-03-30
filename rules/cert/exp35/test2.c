struct X { char a[8]; };
struct Y { struct X x; };
 
void print(char *s);

void printc(char c);

struct X salutation(void) {
  struct X result = { "Hello" };
  return result;
}

struct Y addressee(void) {
  struct Y result = { { "World" } };
  return result;
}
 
void f(void) {
  print(salutation().a);
  print(addressee().x.a);
}

void g(void) {
  printc(++(salutation().a[0]));
  printc(++(addressee().x.a[0]));
}
