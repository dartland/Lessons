package ru.st.extend;

class Cleanser {
	  private String s = "Cleanser";
	  public void print(String string) {
		  System.out.println(string);
	  }
	  public void append(String a) { s += a; }
	  public void dilute() { append(" dilute()"); }
	  public void apply() { append(" apply()"); }
	  public void scrub() { append(" scrub()"); }
	  public String toString() { return s; }
	  public static void main(String[] args) {
	    Cleanser x = new Cleanser();
	    x.dilute(); x.apply(); x.scrub();
	    System.out.println(x);
	  }
	}	
	 
public class Detergent extends Cleanser {
	  // Изменяем метод:
	  public void scrub() {
	    append(" Detergent.scrub()");
	    super.scrub(); // Вызываем метод базового класса
	  }
	  // Добавляем новые методы к интерфейсу :
	  public void foam() { append(" foam()"); }
	  // Проверяем новый класс:
	  public static void main(String[] args) {
	    Detergent x = new Detergent();
	    x.dilute();
	    x.apply();
	    x.scrub();
	    x.foam();
	    System.out.println(x);
	    System.out.println("Testing base class:");
	    Cleanser.main(args);
	  }	
}