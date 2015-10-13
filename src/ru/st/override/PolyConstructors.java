package ru.st.override;

//: polymorphism/PolyConstructors.java
//������������ � ����������� ���� �� ��� 
//���������, ������� ����� ���� �� �������
import static ru.st.print.Print.print;

class Glyph {
	void draw() {
		print("Glyph.draw()");
	}

	Glyph() {
		print("Glyph() before draw()");
		draw(); //�������� ��������
		print("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;
	
	Glyph glyph = new Glyph();  //��� ��������� ��� � �����
	

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
