package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用throws声明异常
 * @Author:
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        readMyFile();
    }

    public static void readMyFile() throws IOException {
        FileReader reader = null;
        reader = new FileReader("c:/study/a.txt");
        char c1 = (char)reader.read();//读一位
        System.out.println(c1);
        if (reader != null) {
            reader.close();//关闭阅读器
        }
    }
}

