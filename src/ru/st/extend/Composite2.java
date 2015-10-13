package ru.st.extend;

/**
 * Created by Алексей on 27.09.2015.
 */
public class Composite2 {
    Composite2(int i){
        System.out.println("Composite2!");
    }

}

class ExtendComposite extends Composite2{

    ExtendComposite(){
        super(1);
        System.out.println("ExtendComposite!");
    }

    public static <T> void print(T s)
    {
        System.out.println(s);
    }

    public static void main(String[] args){
        System.out.println("void main!");
        ExtendComposite ec  = new ExtendComposite();
        System.out.println("!!!");
        print("+++++++");
    }

}



