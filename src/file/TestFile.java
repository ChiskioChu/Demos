package file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 测试File类的基本用法
 * @Author:
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        //File f= new File("d:/a.txt");
        File f = new File("c:\\a.txt");//用反斜杠就需要一个反斜杠作转义符
        f.renameTo(new File("c:\\bb.txt"));
        System.out.println(f);

        System.out.println(System.getProperty("user.dir"));
        File f2 = new File("g.txt");
        //f2.createNewFile();

        System.out.println("File是否存在：" + f2.exists());
        System.out.println("File是否是目录：" + f2.isDirectory());
        System.out.println("File是否是文件：" + f2.isFile());
        System.out.println("File最后修改时间：" + new Date(f2.lastModified()));
        System.out.println("File的大小：" + f2.length());
        System.out.println("File的文件名：" + f2.getName());
        System.out.println("File的目录路径：" + f2.getPath());
        System.out.println("File的绝对路径：" + f2.getAbsolutePath());


        File f3 = new File("c:/电影/华语/大陆");
        boolean flag = f3.mkdir();//目录结构中有一个不存在，则不会创建整个目录
        //boolean flag = f3.mkdirs();//目录结构中有不存在的也不要紧，创建整个目录
        System.out.println(flag);
    }
}
