package ru.exeptions;

import static ru.st.print.Print.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;


@SuppressWarnings("serial")
class NewExeption extends Exception {
}

class Realize{
	public static void f() throws NewExeption{
		print("Выбрасываю исключение!!!");
		throw new NewExeption();
	}
	
}

@SuppressWarnings("serial")
class Realize2 extends Exception {
	public Realize2() {
	}

	public Realize2(String string) {
		super(string);
	}

	public void f() throws Realize2 {
		print("Выбрасываю исключение 2!!!");
		throw new Realize2();
	}
	
	public void mess() throws Realize2 {
		print("Выбрасываю исключение 3!!!");
		throw new Realize2("исключение 3");
	}	

}

public class MyExeption {
	
	public static void main(String[] args) {
		try{
			Realize.f();
		}	
		catch (NewExeption e) {
				print("Перехвачено!");
			}	
		
		Realize2 R2 = new Realize2();
		
		try{
			R2.f();
		}	
		catch (Realize2 e) {
				print("Перехвачено 2!");
			}
		
		try{
			R2.mess();
		}	
		catch (Realize2 e) {
				e.printStackTrace();
			}
	}

}

class LoggingExceptions2 {
	private static Logger logger = Logger.getLogger("LoggingExceptions2");

	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}

	public static void main(String[] args) {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			logException(e);
		}
	}
}
