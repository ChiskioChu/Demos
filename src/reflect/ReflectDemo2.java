package reflect;

import domain.Person;

import java.lang.reflect.Field;

/**
 * @Author:
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
            1.获取成员变量们
                Field[] getFields()
                Field[] getField(String name)

                Field[] getDeclaredFields()
                Field[] getDeclaredField(String name)
        */
        //1.Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("---------------");
        //2.Field getField(String name)方法
        Field a = personClass.getField("a");
        //获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,"张三");
        System.out.println(p);

        System.out.println("===============");

        //3.Field[] getDeclaredFields():获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //4.Field[] getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");//d为private
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        d.set(p,"dddd");
        System.out.println(value2);
        System.out.println(p);
    }
}
