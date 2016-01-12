package ru.threads;

/**
 * Created by Дартланд on 12.01.2016.
 */
public class SimpleThreadManager
{
    public static void main(String[] arg) {
        for(int i=0; i<10; i++) {
            Runnable first = new SimpleRunnable();
            Thread t = new Thread(first);
            t.start();
        }
    }
}

class SimpleRunnable implements Runnable
{
    @Override
    public void run() {
        try {
            long pause = Math.round(Math.random()*2000);
            Thread.sleep(pause);
            System.out.println("Simple Thread - pause="+pause);
        } catch(InterruptedException i_ex) {

        }
    }
}