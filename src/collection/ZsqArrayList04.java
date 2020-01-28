package collection;

import java.util.Objects;

/**
 * 自定义实现一个ArrayList，体会底层原理
 * 增加数组扩容
 * @Author:
 */
public class ZsqArrayList04<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;//默认容量

    public ZsqArrayList04() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ZsqArrayList04(int capacity) {

        if(capacity < 0) {
            throw new RuntimeException("容器的容量不能为负数");
        }
        else if(capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        }
        else
        {
            elementData = new Object[capacity];
        }
    }

    public void add(E element) {
        //什么时候扩容？？？
        if (size == elementData.length) {
            //怎么扩容？？？扩大容量、拷贝、赋回
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];

            System.arraycopy(elementData, 0, newArray, 0, elementData.length);

            elementData = newArray;//新数组对象的地址赋回给原数组对象，原数组对象的元素被垃圾回收

        }
        elementData[size++] = element;
    }


    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }
    public void set(E element,int index)
    {
        checkRange(index);
        elementData[index] = element;
    }

    public void checkRange(int index)
    {
        if(index < 0 || index > size - 1)
        {
            //不合法就手动抛异常
            throw new RuntimeException("索引不合法！");
        }
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
        ZsqArrayList04<String> s1 = new ZsqArrayList04(20);
        for(int i = 0; i < 40;i++)
        {
            s1.add("zhu"+i);
        }
        s1.set("ddd",10);
        System.out.println(s1.get(10));
        System.out.println(s1);
    }
}
