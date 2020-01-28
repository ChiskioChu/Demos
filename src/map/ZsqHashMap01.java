package map;

import collection.Node;
import collection.ZsqLinkedList01;

/**
 * 自定义一个HashMap
 * @Author:
 */
public class ZsqHashMap01 {
    Node2[] table;//位桶数组，bucket array
    int size;//存放键值对的个数

    public ZsqHashMap01() {
        table = new Node2[16];//长度一般定义成2的整数幂
    }

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
            }

        }
    }

    public int myHash(int v, int length) {
        System.out.println("hash in myHash:" + (v & (length - 1)));//直接位运算比取模运算效率高，但是要求长度必须是2的整数幂
        return v & (length - 1);
    }

    public static void main(String[] args) {
        ZsqHashMap01 map = new ZsqHashMap01();
        map.put(10,"aa");
        map.put(20,"bb");
        map.put(30,"cc");
        map.put(20,"ssss");
        map.put(26,"aaa");

        //System.out.println(map);
    }
}
