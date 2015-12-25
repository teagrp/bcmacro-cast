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
  return 0;
}


class C<float> obj;
class C<double> obj2;
class C<long long> obj3;
typedef C<char> C_char;
C_char obj4;

jobject global_jobject;

template <typename T>
class CC{
  T aaa;
  jobject y;
  void badfunc(jobject x) {
    global_jobject = x;
  }
  void badfunc2(jobject z) {
    y = z;
  }
};

