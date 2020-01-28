package collection;

import java.util.Objects;

/**
 * 自定义实现一个ArrayList，体会底层原理
 * 增加数组扩容
 * @Author:
 */
public class ZsqArrayList03<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;//默认容量

    public ZsqArrayList03(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ZsqArrayList03(int capacity)
    {
        elementData = new Object[capacity];
    }

    public void add(E element)
    {
        //什么时候扩容？？？
        if(size == elementData.length) {
            //怎么扩容？？？扩大容量、拷贝、赋回
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];

            System.arraycopy(elementData,0,newArray,0,elementData.length);

            elementData = newArray;//新数组对象的地址赋回给原数组对象，原数组对象的元素被垃圾回收

        }
        elementData[size++] = element;
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
        ZsqArrayList03 s1 = new ZsqArrayList03(20);
        for(int i = 0; i < 40;i++)
        {
            s1.add(i);
        }
        System.out.println(s1);
    }
}
