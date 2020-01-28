package collection;

import java.util.Objects;

/**
 * 自定义实现一个ArrayList，体会底层原理
 * 增加remove
 * @Author:
 */
public class ZsqArrayList05<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;//默认容量

    public ZsqArrayList05() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public ZsqArrayList05(int capacity) {

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
    public void set(E element,int index){
        checkRange(index);
        elementData[index] = element;
    }
    public void checkRange(int index){
        if(index < 0 || index > size - 1)
        {
            //不合法就手动抛异常
            throw new RuntimeException("索引不合法！");
        }
    }
    public void remove(E element){
        //element，将它和所有元素比较，获得一个比较为true的，返回
        for(int i = 0 ;i < size; i++)
        {
            if(element.equals(this.get(i))){//容器中所有的比较操作，用的都是equals而不是==
                //将该元素从此处移除
                remove(i);
            }
        }
    }
    public void remove(int index){
        int numMoved = elementData.length-index-1;
        if(numMoved>0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0 ? true : false;
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
        ZsqArrayList05<String> s1 = new ZsqArrayList05(20);
        for(int i = 0; i < 40;i++)
        {
            s1.add("zhu"+i);
        }
        s1.set("ddd",10);
        System.out.println(s1.get(10));
        s1.remove(39);
        s1.remove("zhu0");
        System.out.println(s1);
        System.out.println(s1.size());
        System.out.println(s1.isEmpty());
    }
}