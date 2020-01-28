package innerClass;

/**
 * @Author:
 */
public class TestStaticinnerClass {
    public static void main(String[] args)
    {
        Outer2.inner2 inner2 = new Outer2.inner2();
        inner2.show();
    }
}
class Outer2{
    private int age = 10;
    static class inner2{
        static int age = 20;
        public void show(){
            int age = 30;
            System.out.println("内部类的成员变量age：" + this.age);
            System.out.println("内部类方法成员变量age：" + age);
        }
    }
}
