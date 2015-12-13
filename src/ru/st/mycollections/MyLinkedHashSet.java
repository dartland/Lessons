package ru.st.mycollections;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Алексей on 12.12.2015.
 */
public class MyLinkedHashSet {
    public static void main(String[] args) {
        Set<String> test = new LinkedHashSet<>();
        // Заполняем от 5 до 1
        for (int i = 1; i < 6; i++) {
            test.add("Строка " + i);
        }
        for (String s : test) {
            System.out.println(s);
        }
        System.out.println();

        // Заполняем (заменяем) от 1 до 5
        for (int i = 1; i < 7; i++) {
            test.add("Строка " + i);
        }
        for (String s : test) {
            System.out.println(s);
        }
        System.out.println();
    }
}


