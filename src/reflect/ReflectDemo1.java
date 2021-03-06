package reflect;

import domain.Person;

/**
 * @Author:
 * 		获取Class类对象的方法：
 * 			Class.forName("全类名"): 将字节码文件加载进内存，返回Class对象
 * 			类名.class：通过类名的属性class来获取
 *          对象.getClass()：getClass()方法在Object类中定义了
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        //1.Class.forName("全类名")
        Class cls1 = Class.forName("domain.Person");//包名.类名
        System.out.println(cls1);
        //2.类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3.对象.getClass()
        Person person = new Person("zsq",22);
        Class cls3 = person.getClass();
        System.out.println(cls3);

        //用==比较三个对象
        System.out.println(cls1 == cls2);//true
        System.out.println(cls1 == cls3);//true
        
    }
}
