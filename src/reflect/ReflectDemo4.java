package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author:
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
            3.获取成员方法们
           			Method[] getMethods()
					Method[] getMethod(String name, 类<?>… parameterTypes)

					Method[] getDeclaredMethods()
					Method[] getDeclaredMethod(String name, 类<?>… parameterTypes)

        */
        //获取指定名称的方法
        Method eat_method = personClass.getMethod("eat");//无参数
        //创建对象
        Person p = new Person();
        //执行方法
        eat_method.invoke(p);

        Method eat_method2 = personClass.getMethod("eat", String.class);//含参数对象
        //执行方法
        eat_method2.invoke(p,"rice");//输入对象的参数给方法

        System.out.println("-------------");

        //获取所有public修饰的方法,还包含Object中的public方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        //获取类名,全类名
        String className = personClass.getName();
        System.out.println(className);
    }
}
