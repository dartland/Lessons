package ru.st.generics2;

/**
 * Created by ������� on 11.12.2015.
 */
public class QueueTest
{
    public static void main(String[] arg) {
        ObjectQueue<String> queue = new ObjectQueue<>();

        for(int i=0; i<10; i++) {
            queue.push("Строка  :" + i*100);
        }

        for(int i=0; i<queue.size(); i++) {
            String s = queue.get(i);
            System.out.println(s);
        }

        System.out.println("===============");

        while(queue.size() > 0) {
            String s = queue.pull();
            System.out.println(s + " Size:" + queue.size());
        }
    }
}