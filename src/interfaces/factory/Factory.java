package interfaces.factory;


interface Service{
	void method1();
	void method2();
}

interface ServiceFactory {
	  Service getService();
	}

class Implementation1  implements Service {
	@Override
	public void method1() {
		System.out.println("11");
	}

	@Override
	public void method2() {
		System.out.println("12");

	}
}

class Implementation1Factory implements ServiceFactory {
	  public Service getService() {
	    return new Implementation1();
	  }
	}

class Implementation2  implements Service {
	@Override
	public void method1() {
		System.out.println("21");
	}

	@Override
	public void method2() {
		System.out.println("22");
	}
}

class Implementation2Factory implements ServiceFactory {
	  public Service getService() {
	    return new Implementation2();
	  }
	}


public class Factory {

	public static void serviceConsumer(ServiceFactory fact) {
	    Service s = fact.getService();
	    s.method1();
	    s.method2();
	  }
	
	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());

	}

}
