package ru.st.my_super;

import static java.lang.System.out;

/**
 * Created by Алексей on 12.12.2015.
 */
public class SuperExample {
    String name;
//    SuperExample(String name){
//        this.name = name;
//        System.out.println("Первый");
//    }

//    public SuperExample() {
//        System.out.println("Четвертый");
//    }

    public static void main(String[] args) {
        //new Super2("1");
        new Super2().SuperMethod();
        SuperExample se = new Super2();
        se.SuperMethod();
        SuperExample se2 = new SuperExample();
        se2.SuperMethod();
    }

    public void SuperMethod() {
        System.out.println("Пятый");
    }

}

class Super2 extends SuperExample{
//    Super2(String name){
//        super("1");
//        System.out.println("Второй");
//    }

//    Super2(){
//        //super();
//        System.out.println("Третий");
//    }

    @Override
    public void SuperMethod() {
        System.out.println("Шестой");
    }
}