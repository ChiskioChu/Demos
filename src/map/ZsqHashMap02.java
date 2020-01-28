package map;

import collection.Node;
import collection.ZsqLinkedList01;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * 重写toString方法(但可以使用HashMap实现类的entrySet，效率最高)
 * 自定义一个HashMap
 * @Author:
 */
public class ZsqHashMap02 {
    Node2[] table;//位桶数组，bucket array
    int size;//存放键值对的个数

    public ZsqHashMap02() {
        table = new Node2[16];//长度一般定义成2的整数幂
    }

    //如果要完善，还要实现数组扩容，扩容的量不一样，就要重新进行计算hash值，因为length不同
    public void put(Object key, Object value) {//放入一个键值对
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node2 temp = table[newNode.hash];

        Node2 iterLast = null;

        boolean keyRepeat = false;//key重复标志

        if(temp == null){
            //此处数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
            size++;
        }else{
            //此处数组元素不为空，则遍历对应的链表。。。
            while(temp != null){
                //判断key重复则覆盖
                if(temp.key.equals(key)){
                    System.out.println("key重复了！！！");
                    keyRepeat = true;
                    temp.value = value;//仅覆盖value即可，其他值保持不变，已经相同
                    break;//无须继续遍历
                }else {
                    //key不重复，则遍历下一个
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            if(!keyRepeat) {//没有发生key重复的情况，则添加到链表最后
                iterLast.next = newNode;
                size++;
            }

        }
    }

    @Override
    public String toString() {
        //{10:aa,20:bb....}
        StringBuilder sb = new StringBuilder("{");

        //遍历bucket
        for(Node2 i:table){
            Node2 temp = i;
            //遍历链表
            while(temp != null){
                sb.append(temp.key+":"+temp.value+",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public int myHash(int v, int length) {//相当于重写hashCode()方法
        System.out.println("hash in myHash:" + (v & (length - 1)));//直接位运算比取模运算效率高，但是要求长度必须是2的整数幂
        return v & (length - 1);
    }

    public static void main(String[] args) {
        ZsqHashMap02 map = new ZsqHashMap02();
        map.put(10,"aa");
        map.put(20,"bb");
        map.put(30,"cc");
        map.put(20,"ssss");
        map.put(26,"aaa");

        System.out.println(map);
    }
}
