package ru.st.lessonParametrize;

public class Message extends Base{
	
	public String messanger;
	
	public Message(){
		
	}
	
	public Message(String messanger){
		this.messanger = messanger;
		
	}

	public String getMessanger() {
		return messanger;
	}

	public void setMessanger(String messanger) {
		this.messanger = messanger;
	}	
	
	

}
