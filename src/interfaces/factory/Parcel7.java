package interfaces.factory;

//: innerclasses/Destination.java
interface Destination {
String readLabel();
}

//: innerclasses/Contents.java 
interface Contents {
int value(); 
}

//: innerclasses/Parcel7.java
//����� ���������� ��������� ����������� ����������� ������
public class Parcel7 {
public Contents contents() {
 return new Contents() {// �������� ����������� ������
   private int i = 11;
   public int value() { return i; }
 };  // � ������ �������� ����� � ������� ����������
}
public static void main(String[] args) {
 Parcel7 p = new Parcel7();
 Contents c = p.contents();
}
}

// : innerclasses/Wrapping.java
class Wrapping {
	private int i;

	public Wrapping(int x) {
		i = x;
	}

	public int value() {
		return i;
	}
}

// : innerclasses/Parcel8.java
// ����� ������������ �������� ������.
class Parcel8 {
	public Wrapping wrapping(int x) {
		// ����� ������������ �������� ������:
		return new Wrapping(x) { // // �������� ������������.
			public int value() {
				return super.value() * 47;
			}
		}; // // ��������� ����� � �������
	}

	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);
	}
}