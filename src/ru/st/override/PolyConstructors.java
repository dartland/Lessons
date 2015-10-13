package ru.st.override;

//: polymorphism/PolyConstructors.java
//Конструкторы и полиморфизм дают не тот 
//результат, который можно было бы ожидать
import static ru.st.print.Print.print;

class Glyph {
	void draw() {
		print("Glyph.draw()");
	}

	Glyph() {
		print("Glyph() before draw()");
		draw(); //работает оверрайд
		print("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;
	
	Glyph glyph = new Glyph();  //тут сработает дро в глифе
	

	RoundGlyph(int r) {
		radius = r;
		print("RoundGlyph.RoundGlyph(), radius = " + radius);
	}
	@Override
	void draw() {
		print("RoundGlyph.draw(), radius = " + radius + "  glyph:" + glyph);
		//glyph.draw();
	}
}

public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
}
