package ru.st.arrays;
//: initialization/ArrayNew.java
// �������� �������� ���������� new.
import java.util.*;
import static ru.st.print.Print.*;
 
public class ArrayNew {
  public static void main(String[] args) {
    int[] a;
    Random rand = new Random(47);
    a = new int[rand.nextInt(20)];
    print("length of a = " + a.length);
    print(Arrays.toString(a));
    Arrays.asList(a);
    String[] string = "My dog has fleas".split(" ");
    print(string[1]);
  }
}