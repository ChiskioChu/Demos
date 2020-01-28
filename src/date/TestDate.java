package date;

import java.util.Date;

/**
 * 测试Date类的常见用法
 * @Author:
 */
public class TestDate {
    public static void main(String[] args) {
        Date d = new Date(2000);//基准时间后2000ms，如果没有加毫秒数，返回当前时间
        System.out.println(d);
        Date d1 = new Date();
        System.out.println(d1);

        System.out.println(d.getTime());//返回毫秒数
        System.out.println(d1.after(d));//比较毫秒数

        //以后遇到日期处理，使用Canlendar日期类
        Date d2 = new Date(2020,3,10);//方法被抛弃了，具体年月看定义
        System.out.println(d2);
    }
}
