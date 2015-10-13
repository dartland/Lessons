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
//Метод возвращает экземпляр безымянного внутреннего класса
public class Parcel7 {
public Contents contents() {
 return new Contents() {// Вставить определение класса
   private int i = 11;
   public int value() { return i; }
 };  // В данной ситуации точка с запятой необходима
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
// Вызов конструктора базового класса.
class Parcel8 {
	public Wrapping wrapping(int x) {
		// Вызов конструктора базового класса:
		return new Wrapping(x) { // // аргумент конструктора.
			public int value() {
				return super.value() * 47;
			}
		}; // // Требуется точка с запятой
	}

	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);
	}
}