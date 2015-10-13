package interfaces.factory;

class StaticValue{
	public static int i = 5;
}

public class Static {

	public static void main(String[] args) {
		
		System.out.println("i= "+StaticValue.i);
		StaticValue sv = new StaticValue();
		System.out.println("i= "+sv.i);
		
	}

}
