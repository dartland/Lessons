package ru.st.this_overload;




//: initialization/Apricot.java
public class Apricot {
	
	Apricot(){}
	Apricot(String string){}
	
	public void pick() { System.out.println("Вызов метода пик");}
	public void pit() { 
		new Apricot().pick(); /* ... */
		System.out.println("Вызов метода пит (ямка)");
		}
	
	Apricot sayKozel(){
		System.out.println("Ты козел!!! ");
		return new Apricot();
	}
	
	Apricot sayKozelLinked(){
		System.out.println("И ещё козел!!! ");
		return this;
	}	
	
	public static void main(String[] args) {
	
		new Apricot().pit();
		
		new Apricot().sayKozel().pick();
		new Apricot().sayKozel().sayKozel().sayKozel().sayKozelLinked();
		
		new Apricot().sayKozelLinked().sayKozelLinked().sayKozelLinked().sayKozel().pick();
		
	}	
	
}