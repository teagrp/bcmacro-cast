#include<iostream>

template <typename T_n>
T_n Add(T_n tnA, T_n tnB) {
  return tnA + tnB;
}

template <typename>
class nakamura;

template <>
class nakamura<void>;

typedef char* jobject;

template <typename Ty>
class C {
  Ty x;
  jobject y;
  void yabai(jobject o) {
    y = o;
  }
};

int main() {
  std::cout << "こんにちは、C++の世界へようこそ！" << std::endl;

  double dValue = Add(1.3, 2.4);
  int iValue = Add(1, 2);
  
  return 0;
}


class C<float> obj;
class C<double> obj2;

void f() {}

class C<long long> obj3;


typedef C<char> C_char;
C_char obj4;
