main(){
  int index;

  assert(index + 3 > 0);
  assert(index - 3 > 0);
  assert(index * 3 > 0);
  assert(index / 3 > 0);
  assert(index % 3 > 0);
  assert(index++ > 0);
  assert(index-- < 0);
  assert(index & 0xff00 > 0);
  assert(index | 0xff00 > 0);
  assert(index ^ 0xff00 > 0);
  assert(~index > 0);
  assert(index << 1 > 0);
  assert(index >> 1 > 0);
  assert(index = 3 > 0);
  assert(index += 3 > 0);
  assert(index -= 3 > 0);
  assert(index *= 3 > 0);
  assert(index /= 3 > 0);
  assert(index %= 3 > 0);
  assert(index &= 0xff00 > 0);
  assert(index |= 0xff00 > 0);
  assert(index ^= 0xff00 > 0);
  assert(index <<= 1 > 0);
  assert(index >>= 1 > 0);
}
