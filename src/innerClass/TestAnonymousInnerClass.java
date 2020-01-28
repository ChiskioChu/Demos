package innerClass;

/**
 * @Author:
 */
public class TestAnonymousInnerClass {
    public static void main(String[] args)
    {
        TestAnonymousInnerClass.test01(new AA() {
            @Override
            public void aa() {
                System.out.println("!!!!!!!!");
            }
        });//括号中为匿名内部类,实现接口方法
    }
    public static void test01(AA a)
    {
        System.out.println("#####");
        a.aa();
    }
}
interface AA
{
    void aa();
}

