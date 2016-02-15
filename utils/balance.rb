#!/usr/bin/ruby

if ARGV[0] then
  $input = open(ARGV[0]).read()
else
  $input = STDIN.read()
end
$stack = []

N = 70

def assert_stack(pair, cur_pos)
  if $stack[-1] == nil then
    print "error: unexpected '#{$input[cur_pos]}' at column #{cur_pos}\n"
    if cur_pos > N then
      print "... #{$input[(cur_pos - N) .. cur_pos]}\n"
    else
      print "#{$input[0 .. cur_pos]}\n"
    end
    print "no corresponding open braket\n"
    exit 1
  elsif $stack[-1][0] != pair then
    print "error: unexpected '#{$input[cur_pos]}' at column #{cur_pos}\n"
    if cur_pos > N then
      print "... #{$input[(cur_pos - N) .. cur_pos]}\n"
    else
      print "#{$input[0 .. cur_pos]}\n"
    end
    print "stack trace:\n"
    while (top = $stack.pop())
      pos = top[1]
      print "#{top[0]}: (#{pos}) "
      if cur_pos - pos > N then
        print "#{$input[pos ... (pos+N)]} ...\n"
      else
        print "#{$input[pos .. cur_pos]}\n"
      end
    end
    exit 1
  end
  $stack.pop()
end

$input.length.times do |pos|
  c = $input[pos]

  if c == "{" || c == "[" then
    $stack.push([c, pos])
  elsif c == "\"" then
    if $stack[-1][0] == "\"" then
      $stack.pop()
    else
      $stack.push([c, pos])
    end
  elsif c == "}" then
    assert_stack("{", pos)
  elsif c == "]" then
    assert_stack("[", pos)
  end
end
