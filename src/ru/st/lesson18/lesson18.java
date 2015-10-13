package ru.st.lesson18;

public class lesson18 {

	public static void main(String[] args) {
		Integer []an = { 2, 10, -115, 120, 4, 7};
		
		Collection collect = new Collection(an);
		
		Iterator iterFor = collect.createForward();
		Iterator iterBack = collect.createBackward();
		
		System.out.println("------------iterFor.next()----------");
		
		while (iterFor.hasNext()){
			System.out.println((Integer) iterFor.next()); 
		}
		
		System.out.println("------------iterBack.next()----------");

		while (iterBack.hasNext()){
			System.out.println((Integer) iterBack.next()); 
		}
		
		
		System.out.println("-----------it.next() every second element -----------");
		
		Iterator it = collect.createIterator();
		while (it.hasNext()){
			System.out.println((Integer) it.next()); 
		}
		
		
	}

}
