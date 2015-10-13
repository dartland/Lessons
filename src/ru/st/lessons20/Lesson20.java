package ru.st.lessons20;

public class Lesson20 {

	public static void main(String[] args) {

/*		Thread tr1 = new MyThread(750,"поток 1 = ");
		Thread tr2 = new MyThread(500,"поток 2 = ");
		
		tr1.start();
		tr2.start();*/
		
        new ThisThread(750,"1-");
        new ThisThread(500,"2-");
        
		
	}

}
