package ru.st.collector;

//: initialization/TerminationCondition.java
//������������� finalize() ��� ��������� �������,
//�� �������������� ����������� �����������
class Book {
boolean checkedOut = false;
Book(boolean checkOut) {
 checkedOut = checkOut;
}
void checkIn() {
 checkedOut = false;
}
protected void finalize() {
 if(checkedOut)
   System.out.println("Error: checked out");
 // ������ ��� �������� ���-:
 // super.finalize();  // ����� ������ �������� ������
}
}

public class GarbageCollector {
public static void main(String[] args) {
 Book novel = new Book(true);
 // ���������� �������-:
 novel.checkIn();
 // ������ ������, ������ ��� �������:
 new Book(true);
 // ������ JVM �� ������ ������ � ����������� :
 System.gc();
}
}