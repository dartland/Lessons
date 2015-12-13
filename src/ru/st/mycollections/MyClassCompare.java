package ru.st.mycollections;

/**
 * Created by Алексей on 12.12.2015.
 */
public class MyClassCompare implements Comparable<MyClassCompare>
{
    private String name;

    public MyClassCompare(String name) {
        this.name = name;
    }

    // этот метод как раз и сравнивает текущий обхект с другим,
    // который передается в качестве аргумента
    public int compareTo(MyClassCompare o) {
        return name.compareTo(o.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
