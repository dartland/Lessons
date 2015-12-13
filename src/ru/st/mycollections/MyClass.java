package ru.st.mycollections;

/**
 * Created by Алексей on 12.12.2015.
 */
public class MyClass
{
    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}