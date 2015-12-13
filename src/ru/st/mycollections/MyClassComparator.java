package ru.st.mycollections;

/**
 * Created by Алексей on 12.12.2015.
 */
import java.util.Comparator;

public class MyClassComparator implements Comparator
{
    public int compare(Object o1, Object o2) {
        return o2.toString().compareTo(o1.toString());
    }



}