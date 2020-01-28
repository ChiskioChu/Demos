package exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * 使用try-catch处理异常
 * @Author:
 */
public class Test02 {
    public static void main(String[] args) {
        readMyFile();
    }

    public static void readMyFile()
    {
        FileReader reader = null;
        try {//解耦合的格式，内层try语句块确保关闭输入流，外层确保报告错误
            try {
                reader = new FileReader("c:/study/a.txt");
                char c1 = (char) reader.read();//读一位
                System.out.println(c1);
            }
            finally {
                try {
                    if (reader != null) {
                        reader.close();//关闭阅读器
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {//子类异常在父类异常前面，否则子类异常无法执行到
            e.printStackTrace();//打印跟踪信息
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
