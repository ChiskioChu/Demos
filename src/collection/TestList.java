package collection;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *测试Collection接口中的方法
 * @Author:
 */
public class TestList {
    public static void main(String[] args) {
        test03();
    }
    public static void test01(){
        Collection<String> c = new ArrayList<>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("aa");
        c.add("bb");
        System.out.println(c);//默认调用toString方法

        System.out.println(c.contains("bb"));

        Object[] objs = c.toArray();
        System.out.println(objs);

        c.clear();
        System.out.println(c);
    }
    public static void test02(){
        List<String> list01 = new ArrayList<>();//既可以是List也可以是Collection，List是Collection的子接口
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

        System.out.println("list01:"+list01);

        //list01.addAll(list02);//02中的全放
        //list01.removeAll(list02);//删除和02中所有相同的元素
        list01.retainAll(list02);//保留和02中所有相同的元素
        System.out.println(list01.containsAll(list02));//01是否包含02中的所有元素
        System.out.println("list01:"+list01);
    }
    public static void test03(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("D");
        list.add("D");

        System.out.println(list);

        list.add(2,"zsq");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.set(2,"zsq");//替换
        System.out.println(list);

        System.out.println(list.get(2));

        System.out.println(list.indexOf("D"));//返回第一次出现该元素的下标，没有匹配则返回-1
        System.out.println(list.lastIndexOf("D"));//返回最后一次出现该元素的下标

    }
}