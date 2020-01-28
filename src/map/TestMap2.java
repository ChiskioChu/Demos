package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map常用办法
 * @Author:
 */
public class TestMap2 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1001,"ZSQ",50000);
        Employee e2 = new Employee(1002,"AAA",5000);
        Employee e3 = new Employee(1003,"BBB",6000);
        Employee e4 = new Employee(1004,"CCC",7000);

        Map<Integer,Employee> map = new HashMap<>();

        map.put(e1.getId(),e1);
        map.put(e2.getId(),e2);
        map.put(e3.getId(),e3);
        map.put(e4.getId(),e4);
        Employee emp = map.get(e1.getId());
        System.out.println(emp.toString());

    }
}
//雇员信息
class Employee{
    private int id;
    private String ename;
    private double salary;

    public Employee(int id, String ename, double salary) {
        super();
        this.id = id;
        this.ename = ename;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:"+id+" name:"+ename+" salary:"+salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getEname(){
        return ename;
    }

    public void setEname(String ename){
        this.ename = ename;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
}
