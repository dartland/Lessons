package ru.st.generics;

import java.util.*;
import java.util.function.Consumer;

interface Generator<T> {
	T next();
}

class Fibonacci implements Generator<Integer> {
	private int count = 0;

	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

}

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
	private int n;

	public IterableFibonacci(int count) {
		n = count;
	}

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() {
				return n > 0;
			}

			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for (int i : new IterableFibonacci(18))
			System.out.print(i + " ");
		//for(int i1 : range(5, 20, 3)){}
	}

}	