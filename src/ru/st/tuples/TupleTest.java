package ru.st.tuples;

import java.util.Date;

class Amphibian {}
class Vehicle {
	public static int i = 3;
	
	public static void increment(){
		i++;
	}	
	public void increment2(){
		++i;		
		
	}
}

class MyData extends Date{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getYear(){
		return 2015;
	}
}

public class TupleTest {
	
	static TwoTuple<Integer,String> f(){
		return new TwoTuple<Integer,String>(10,"’‡È");
	}
	
	static ThreeTuple<Integer,String,Amphibian> g(){
		return new ThreeTuple<Integer,String,Amphibian>(10,"’‡È", new Amphibian());
	}	
	
//	static FourTuple<Integer,String,Amphibian,Vehicle> e(){
//		return new ThreeTuple<Integer,String,Amphibian>(10,"’‡È", new Amphibian());
//	}	
		
	

	public static void main(String[] args) {
		
		//ThreeTuple<Integer,String,Amphibian> tt = g();
		//tt.first = 5;
		MyData date = new MyData();
		System.out.println(date.getYear());
		System.out.println(new Date());
		
		
		System.out.println(f());
		System.out.println(g());
		Vehicle vehicle = new Vehicle();
		vehicle.increment2();
		System.out.println(Vehicle.i);
		Vehicle.increment();
		System.out.println(Vehicle.i);
		
	}

}
