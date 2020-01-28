package file;

import java.io.File;

/**
 * 递归打印File目录树
 * @Author:
 */
public class PrintFileTree {
    public static void main(String[] args) {
        File f = new File("C:\\study\\毕业设计");

        //递归打印File目录
        printFile(f,0);
    }
    public static void printFile(File file, int level)
    {
        //输出层数
        for(int i = 0;i < level; i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        //file是否是目录，来做递归结束标志
        if(file.isDirectory())
        {
            File[] files = file.listFiles();
            //递归体
            for(File temp : files)
            {
                printFile(temp,level+1);
            }
        }
    }
}
