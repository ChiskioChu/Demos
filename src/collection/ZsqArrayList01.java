package collection;

import java.util.Objects;

/**
 * 自定义实现一个ArrayList，体会底层原理
 * @Author:
 */
public class ZsqArrayList01 {

    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ZsqArrayList01(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ZsqArrayList01(int capacity)
    {
        elementData = new Object[capacity];
    }

    public void add(Object obj)
    {
        elementData[size++] = obj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for(int i = 0;i < size; i++)
            sb.append(elementData[i]+",");
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ZsqArrayList01 s1 = new ZsqArrayList01(20);
        s1.add("aa");
        s1.add("bb");
        System.out.println(s1);
    }
}
