package ru.st.interfaces.printer;

public class AdvancePrinter implements IPrinter{

	@Override
	public void print(String string) {
		System.out.println(string);
		System.out.println("Lenght:"+string.length());
		
	}
	
	

}
