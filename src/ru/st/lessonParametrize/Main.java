package ru.st.lessonParametrize;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Message message = new Message();
		ImessageImpl imessage = new ImessageImpl();
		
		for(Message message : imessage.getAll()){
			
			System.out.println(message.getMessanger());
			
		}
		
	}

}
