package ru.st.interfaces.reader;

public class PredefinedReader implements IReader {

	private final String str;
	
	public PredefinedReader(String str){
		this.str = str;
	}
	
	@Override
	public String read() {
		
		return str;
	}

}
