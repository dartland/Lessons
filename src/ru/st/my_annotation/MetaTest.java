package ru.st.my_annotation;

/**
 * Created by Алексей on 13.12.2015.
 */
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@interface debug
{
    String comment();
    String chislo();
}

@debug(comment="Comment for MetaTest class",chislo="1")
public class MetaTest
{
    @debug(comment="Comment for member production",chislo="2")
    public boolean production=true;

    @debug(comment="Comment for testMethod",chislo="3") public void testMethod()  {    }

    public static void main(String[] args)
    {
        MetaTest mt = new MetaTest();
        try {
            Annotation[] ant1 = mt.getClass().getAnnotations();
            for (Annotation a : ant1) {
                System.out.println(a);
            }

            System.out.println("-----------------------");
            Annotation[] ant2 = mt.getClass().getMethod("testMethod").getAnnotations();
            for (Annotation a : ant2) {
                System.out.println(a);
            }

            System.out.println("-----------------------");
            Annotation[] ant3 = mt.getClass().getField("production").getAnnotations();
            for (Annotation a : ant3) {
                System.out.println(a);
            }
        }
        catch(NoSuchMethodException e) {
            System.out.println(e);
        }
        catch(NoSuchFieldException e) {
            System.out.println(e);
        }
    }
}