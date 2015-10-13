package ru.st.lessons20;

public class MyThread extends Thread{

	private int delay;
	private String string;
	MyThread(int delay, String string) {
		this.delay = delay;
		this.string = string;
	}
	
	@Override
	public void run(){
	
		for(int i = 0; i < 10; i++){
		
			System.out.println(string+i);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
