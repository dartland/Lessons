//: interfaces/nesting/NestingInterfaces.java
package interfaces.nesting;

import interfaces.nesting.A.B;
import interfaces.nesting.A.C;
import interfaces.nesting.A.DImp2;

class A {
	interface B {
		void f();
	}

	public class BImp implements B {
		public void f() {
		}
	}

	private class BImp2 implements B {
		public void f() {
		}
	}

	public interface C {
		void f();
	}

	class CImp implements C {
		public void f() {
		}
	}

	private class CImp2 implements C {
		public void f() {
		}
	}

	private interface D {
		void f();
	}

	private class DImp implements D {
		public void f() {
		}
	}

	public class DImp2 implements D {
		public void f() {
		}
	}

	public D getD() {
		return new DImp2();
	}

	private D dRef;

	public void receiveD(D d) {
		dRef = d;
		dRef.f();
			
	}
	
	private static D dRefSt;
	
	public static void receiveDSt(D d) {
		dRefSt = d;
		dRefSt.f();
			
	}	
	
}

interface E {
	interface G {
		void f();
	}

	// Избыточное объявление public:
	public interface H {
		void f();
	}

	void g();
	// He может быть private внутри интерфейса:
	// ! private interface I {}
}

public class NestingInterfaces {
	public class BImp implements A.B {
		public void f() {
		}
	}

	class CImp implements A.C {
		public void f() {
		}
	}

	// Private-интерфейс не может быть реализован нигде,
	// кроме как внутри класса, где он был определен:
	// ! class DImp implements A.D {
	// ! public void f() {}
	// ! }
	class EImp implements E {
		public void g() {
		}
	}

	class EGImp implements E.G {
		public void f() {
		}
	}

	class EImp2 implements E {
		public void g() {
		}

		class EG implements E.G {
			public void f() {
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		A a = new A();
		// Нет доступа к A.D:
		// ! A.D ad = a.getD();
		// He возвращает ничего, кроме A.D:
		// ! A.DImp2 di2 = a.getD();
		// Член интерфейса недоступен:
		// ! a.getD().f();
		// Только другой объект класса А может использовать getD():
		A a2 = new A();
		a2.receiveD(a.getD());
		
		A.B ab = (B) a.getD();
		A.C ac = (C) a.getD();
		A.DImp2 aDImp2 = (DImp2) a.getD();
		ab.f();
		A.receiveDSt(aDImp2);
		
	}
}