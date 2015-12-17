int sum(int num) {
  int sum;
  while (num != 0) {
    sum += num;
    num--;
  }
  
  int sumsum(int sum) {
    int sumsum;
    while (sum != 0) {
      sumsum += sum;
      sum--;
    }
    
    return sumsum;
  }
    

  return sum;
}

int main() {
  int num = 10;
  sum(num);
  return 0;
}
