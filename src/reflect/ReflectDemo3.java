package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author:
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
            2.获取构造方法们
           		Constructor<?>[] getConstructors()
				Constructor<T>[] getConstructor(类<?>… parameterTypes)

				Constructor<?>[] getDeclaredConstructors()
				Constructor<T>[] getDeclaredConstructor(类<?>… parameterTypes)

        */
        //Constructor<T>[] getConstructor(类<?>… parameterTypes)
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //创建对象
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);

        System.out.println("-----------");
        Constructor constructor2 = personClass.getConstructor();
        System.out.println(constructor);
        //创建对象
        Object person2 = constructor2.newInstance();
        System.out.println(person2);

        Object o = personClass.newInstance();//空参构造
        System.out.println(o);
    }
}
