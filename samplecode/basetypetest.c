#include <stdbool.h>

int a;
signed int b;
unsigned int c;
long int d;
signed long int e;
unsigned long int f;
long long int g;
signed long long int h;
unsigned long long int i;
short int j;
signed short int k;
unsigned short int l;

double m;
float n;

char o;
signed char p;
unsigned char q;

long double r;

bool s;

int t[100];
int *u;

int y[21][31];
int *z[31];
int (*aa)[31];
int **ab[91];

typedef union {
  unsigned short int word;
  struct {
    unsigned char lo;
    unsigned char hi;
  } lohi;
} _Sjis;

typedef struct _person{
  char name[50];
  char phone[50];
  struct _person *next;
}person;

const int ac;
volatile double ad;

const int *const ae;
const int *af;
int const *ag;

static int ah;

typedef const int * NAKAMURA;
NAKAMURA shinya;

extern int ak;
static int al;
static const int an;
volatile int ao;

static int func (int number1, int number2) {
  int sum;
  sum = number1 + number2;
  return sum;
}

int main() {
  extern int ap;
  static int am;
  auto int ai;
  register int aj;
  person *w, *x;

  int array1[10 + 1];
  ah = 22;
  int array[ah];

  func(17320508, 141421356);
  return 0;
}
