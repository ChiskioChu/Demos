package innerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import javax.swing.*;

/**普通内部类，非静态类
 * @Author:
 */
public class InnerClassTest {
    public static void main(String [] args)
    {
        /*TalkingClock clock = new TalkingClock(1000,true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit Program?");
        System.exit(0);*/
        Outer.inner inner = new Outer().new inner();
        inner.show();
    }
}
class Outer
{
    private int age = 10;
    public void testOuter(){

    }
    class inner{
        final int age = 20;
        public void show(){
            int age = 30;
            System.out.println("外部类的成员变量age：" + Outer.this.age);
            System.out.println("内部类的成员变量age：" + this.age);
            System.out.println("内部类局部变量age：" + age);
        }
    }
}

/*
class TalkingClock
{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval,boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }
    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval,listener);
        t.start();
    }
    public class TimePrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("At the tone, the time is "+ new Date());
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}*/
