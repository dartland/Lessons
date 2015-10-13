package ru.st.this_overload;




//: initialization/Apricot.java
public class Apricot {
	
	Apricot(){}
	Apricot(String string){}
	
	public void pick() { System.out.println("����� ������ ���");}
	public void pit() { 
		new Apricot().pick(); /* ... */
		System.out.println("����� ������ ��� (����)");
		}
	
	Apricot sayKozel(){
		System.out.println("�� �����!!! ");
		return new Apricot();
	}
	
	Apricot sayKozelLinked(){
		System.out.println("� ��� �����!!! ");
		return this;
	}	
	
	public static void main(String[] args) {
	
		new Apricot().pit();
		
		new Apricot().sayKozel().pick();
		new Apricot().sayKozel().sayKozel().sayKozel().sayKozelLinked();
		
		new Apricot().sayKozelLinked().sayKozelLinked().sayKozelLinked().sayKozel().pick();
		
	}	
	
}