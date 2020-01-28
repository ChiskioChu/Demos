package wrapped;
/**
 * 包装器类，Integer，其他都类似
 * @Author:
 */
public class TestWrappedClass {
    public static void main(String[] args) {
        //自动装箱
        Integer aa = 234;//Integer aa = Integer.valueOf(234);
        //自动拆箱
        int bb = aa;//编译器会修改成：int b = aa.intValue();

        //基本数据类型转成包装类对象
        Integer a = new Integer(3);
        Integer b = Integer.valueOf(30);

        //把包装类对象转换成基本类型
        int c = b.intValue();
        double d = b.doubleValue();

        //把字符串转换成包装类对象
        Integer e = new Integer("9999");
        Integer f = Integer.parseInt("99998888");

        //把包装类转换成字符串
        String str = e.toString();

        System.out.println(c);
        System.out.println(d);

        //缓存[-128,127]之间的数
        Integer in1 = Integer.valueOf(-128);
        Integer in2 = Integer.valueOf(-128);
        System.out.println(in1 == in2);//在缓存范围内，所以使用的是缓存内的cache数组，因此是同一个
        System.out.println(in1.equals(in2));//比较内容，所以为true
        System.out.println("##########################");
        Integer in3 = Integer.valueOf(1234);
        Integer in4 = Integer.valueOf(1234);
        System.out.println(in3 == in4);//不在缓存范围内，所以创建的是不同的包装类对象
        System.out.println(in3.equals(in4));//比较内容，所以相同

    }
}
