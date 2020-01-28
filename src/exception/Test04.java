package exception;

/**
 * @Author:
 */
public class Test04 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(-10);
    }
}

class Person
{
    private int age;
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        if(age<0){
            throw new IllegalAgeException("年龄不能为负数");
        }
        this.age = age;
    }
}
/**运行时异常，如果改成Exception则为编译时异常，需要加try-catch或throw*/
class IllegalAgeException extends RuntimeException{
    public IllegalAgeException()
    {

    }
    public IllegalAgeException(String msg)
    {
        super(msg);
    }
}
