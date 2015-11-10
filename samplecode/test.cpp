#include <iostream>

using namespace std;


class base {
public:
  void f () {cout << "base" << endl;}
};

class derived : public base {
public:
};

class derived2 : public derived {
public:
  void f () {
    derived::f();
    cout << "derived" << endl; 
  }
};

int main() {
  derived2 x;
  x.f();
  return 0;
}
