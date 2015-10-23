package interfaces.nesting;

//: holding/ArrayIsNotIterable.java
import java.util.*;

public class ArrayIsNotIterable {
	static <T> void test(Iterable<T> ib) {
		for (T t : ib)
			System.out.print(t + " ");
	}

	public static void main(String[] args) {
		test(Arrays.asList(1, 2, 3));
		String[] strings = { "A", "B", "C" };
		// Массив работает в foreach. но не является Iterable:
		// ! test(strings);
		// его необходимо явно преобразовать к Iterable:
		test(Arrays.asList(strings));
	}
}

class IterableClass implements Iterable<String> {
	protected String[] words = ("And that is how " + "we know the Earth to be banana-shaped.").split(" ");

	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;

			public boolean hasNext() {
				return index < words.length;
			}

			public String next() {
				return words[index++];
			}

			public void remove() { // Не реализован
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for (String s : new IterableClass())
			System.out.print(s + " ");
	}
}