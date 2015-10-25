package ru.exeptions;

//: exceptions/NeverCaught.java
//Игнорирование RuntimeExceptions.
//{ThrowsException}

public class NeverCaught {
	static void f() {
		throw new RuntimeException("From f()");
	}

	static void g() {
		f();
	}

	public static void main(String[] args) {
		g();
	}
}

// : exceptions/LostMessage.java
// Как теряются исключения.

class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
				
			} 
//			catch (Exception e) {
//				System.out.println(e);
//			}
			finally {
				lm.dispose();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}