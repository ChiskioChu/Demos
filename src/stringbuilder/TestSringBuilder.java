package stringbuilder;
/**
 * 测试StringBuilder、StringBuilder为可变字符序列和常用方法
 * @Author:
 */
public class TestSringBuilder {
    public static void main(String[] args) {
        String str;

        //StringBuilder线程不安全，效率高（一般使用它）；StringBuffer线程安全，效率低
        StringBuilder sb = new StringBuilder("abcdefg");

        System.out.println(Integer.toHexString(sb.hashCode()));//打印sb的存储地址
        System.out.println(sb);

        sb.setCharAt(2,'M');//修改字符序列
        System.out.println(Integer.toHexString(sb.hashCode()));//发现是同一个对象
        System.out.println(sb);

        System.out.println("######################");

        StringBuilder sb2 = new StringBuilder();

        //增删改查.倒序
        for(int i = 0;i < 26; i++)
        {
            char temp = (char)('a'+i);
            sb2.append(temp);
        }

        System.out.println(sb2);
        sb2.reverse();
        System.out.println(sb2);
        sb2.setCharAt(3,'朱');
        System.out.println(sb2);
        sb2.insert(0,'我').insert(1,'爱').insert(2,'你');
        System.out.println(sb2);
    }
}
