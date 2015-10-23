package ru.st.arrays;

//: holding/CollectionSequence.java
//import typeinfo.pets.*;
import java.util.*;
import ru.st.print.*;

class Pet{

	public String id() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class Pets extends Pet{

	public static Pet[] createArray(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


class InterfaceVsIterator {
	  public static void display(Iterator<Pet> it) {
	    while(it.hasNext()) {
	      Pet p = it.next();
	      System.out.print(p.id() + ":" + p + " ");
	    }
	    System.out.println();
	  }
	  public static void display(Collection<Pet> pets) {
	    for(Pet p : pets)
	      System.out.print(p.id() + ":" + p + " ");
	    System.out.println();
	  }	
	
	}


public class CollectionSequence extends AbstractCollection<Pet> {
	private Pet[] pets = Pets.createArray(8);

	public int size() {
		return pets.length;
	}

	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;

			public boolean hasNext() {
				return index < pets.length;
			}

			public Pet next() {
				return pets[index++];
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		CollectionSequence c = new CollectionSequence();
		InterfaceVsIterator.display(c);
		InterfaceVsIterator.display(c.iterator());
	}
}