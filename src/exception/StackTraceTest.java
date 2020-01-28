package exception;

import java.util.Scanner;

/**
 * 打印递归阶乘函数的堆栈情况
 * @Author:
 */
public class StackTraceTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        factorial(n);
    }
    public static int factorial(int n)
    {
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();//getStackTrace得到一个StackTraceElement的数组
        for(StackTraceElement f : frames)//StackTraceElement包含文件名和代码行号
            System.out.println(f);
        int r;
        if(n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;
    }
}
