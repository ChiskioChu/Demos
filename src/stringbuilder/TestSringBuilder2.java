package stringbuilder;

/**
 * 测试可变字符序列和不可变字符序列使用的陷阱
 * @Author:
 */
public class TestSringBuilder2 {
    public static void main(String[] args) {
        /**使用String进行字符串的拼接*/
        String str8 = "";
        //本质上使用StringBuilder拼接，但是每次循环都会生成一个StringBuilder的对象
        long nums1 = Runtime.getRuntime().freeMemory();
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            str8 = str8 + i;//i是一个对象，拼接后是一个对象，所以相当于产生了10000个对象
        }
        long nums2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("String占用内存："+(nums1-nums2));
        System.out.println("String占用时间："+(time2-time1));

        /**使用StringBuilder进行字符串的拼接，当遇到循环累加一定要用append添加！！*/
        StringBuilder sb1 = new StringBuilder("");
        long nums3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        for(int i = 0; i < 5000; i++)
        {
            sb1.append(i);
        }
        long nums4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuilder占用内存："+(nums3-nums4));
        System.out.println("StringBuilder占用时间："+(time4-time3));
    }
}
