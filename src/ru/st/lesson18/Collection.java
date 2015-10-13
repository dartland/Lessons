package ru.st.lesson18;

public class Collection {

	public Object []arr;
	public Collection(Object []a){
		arr = a;
	}
	
	public class Forward implements Iterator{
		private int cur = 0;
		
		@Override
		public Boolean hasNext() {
			return cur < arr.length;
		}

		@Override
		public Object next() {
			return arr[cur++];
		}
	}
	
	public class Backward implements Iterator{
		private int cur = arr.length-1;
		
		@Override
		public Boolean hasNext() {
			return cur >= 0;
		}

		@Override
		public Object next() {
			return arr[cur--];
		}
	}
	
	public Iterator createForward(){
		return new Forward();
	}
	
	public Iterator createBackward(){
		return new Backward();
	}
	
	public Iterator createIterator(){
		return new Iterator(){
			int cur = -1;
			@Override
			public Boolean hasNext() {
				return cur<arr.length-2;
			}

			@Override
			public Object next() {
				return arr[cur+=2];
			}
		};
	}
	
	
}
