package collection;

import java.nio.file.NotDirectoryException;

/**
 * 自定义一个链表
 * 增加插入节点操作
 * @Author:
 */
public class ZsqLinkedList04 {
    private Node first;
    private Node last;

    private int size;

    public void add(int index,Object obj)
    {
        Node insert = new Node(obj);
        Node temp = getNode(index);
        if(temp != null){
            if(index == 0)
            {
                temp.previous = insert;
                first = insert;
                insert.previous = null;
                insert.next = temp;
            }
            else if(index == size-1)
            {
                temp.next = insert;
                last = insert;
                insert.previous = temp;
                insert.next = null;
            }else {
                temp.previous.next = insert;
                temp.previous = insert;
                insert.previous = temp.previous;
                insert.next = temp;
            }
            size++;
        }
    }

    public void remove(int index){
        Node temp = getNode(index);
        if(temp != null){
            if(index == 0)
            {
                first = temp.next;
                temp.next.previous = null;
            }
            else if(index == size-1)
            {
                last = temp.previous;
                temp.previous.next = null;
            }else {
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
            }
            size--;
        }
    }

    public Object get(int index){
        if(index < 0 || index > size-1){
            throw new RuntimeException("索引数字不合法："+ index);
        }

        return getNode(index).element;
    }

    public Node getNode(int index){
        Node temp = null;

        if(index <= (size>>1))
        {
            temp = first;
            for(int i = 0; i < index; i++)
            {
                temp = temp.next;
            }
        }else{
            temp = last;
            for(int i = size - 1; i > index; i--){
                temp = temp.previous;
            }
        }
        return temp;
    }
    public void add(Object obj) {
        Node node = new Node(obj);

        if (first == null) {
            //node.previous = null;
            //node.next = null;
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        //挨个遍历链表中的元素
        Node temp = first;
        while (temp != null)
        {
            sb.append(temp.element+",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ZsqLinkedList04 list = new ZsqLinkedList04();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");


        System.out.println(list.toString());
        System.out.println(list.get(5));
        System.out.println(list.size);
        list.add(0,"aa");
        System.out.println(list.toString());
        System.out.println(list.size);
        list.add(2,"bb");
        System.out.println(list.toString());
        System.out.println(list.size);
        list.add(list.size-1,"ff");
        System.out.println(list.toString());
        System.out.println(list.size);
    }

}
