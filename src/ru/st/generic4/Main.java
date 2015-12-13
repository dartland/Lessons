package ru.st.generic4;

/**
 * Created by Алексей on 12.12.2015.
 */
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        List<MyClass1> list1 = new ArrayList<>();
        list1.add(new MyClass1("Василий 1"));
        list1.add(new MyClass1("Павел 1"));
        list1.add(new MyClass1("Андрей 1"));
        list1.add(new MyClass1("Петр 1"));
        list1.add(new MyClass1("Анжелика 1"));
        printCollection("Коллеция 1", list1);

        List<MyClass2> list2 = new ArrayList<>();
        list2.add(new MyClass2("Василий 2"));
        list2.add(new MyClass2("Павел 2"));
        list2.add(new MyClass2("Андрей 2"));
        list2.add(new MyClass2("Петр 2"));
        list2.add(new MyClass2("Анжелика 2"));
        printCollection("Коллекция 2", list2);
    }

    private static void printCollection(String title, List<? extends BasicClass> list) {
        System.out.println(title);
        for (BasicClass bc : list) {
            System.out.println("Item:" + bc.getName());
        }
        System.out.println();


    }
}