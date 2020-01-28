package lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import javax.swing.*;

/**
 * @Author:
 */
public class LambdaTest {
    public static void main(String [] args)
    {
        /*String[] planets = new String[]{"Mercury","Venus","Mars","Earth","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets,(first,sencond)->first.length()-sencond.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000,event ->
                System.out.println("The time is " + new Date()));//1s到了执行的event用lambda表达式
        t.start();

        JOptionPane.showMessageDialog(null,"Quit Program?");
        System.exit(0);*/
        //repeat(10,i->System.out.println("Countdown"+(9-i)));
        repeat(10,i->System.out.println("Countdown"+(9-i)));
    }

    /*public static void repeat(int n, IntConsumer action)
    {
        for(int i = 0; i < n; i++) action.accept(i);
    }*/
    public static void repeat(int n,Consumer<Integer> action)
    {
        for(int i = 0; i < n; i++) action.accept(i);
    }
}
