package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  测试时间对象和字符串之间的相互转换
 *  DateFormat抽象类和SimpleDateFormat实现类的使用
 * @Author:
 */
public class TestDateFormat {
    public static void main(String[] args) throws ParseException {

        //把时间对象按照“格式字符串指定的格式”转成相应的字符串
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//格式化，具体字母查API手册
        String str = df.format(new Date(400000));
        System.out.println(str);

        //把字符串按照“格式字符串指定的格式”转成相应的时间对象
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");

        Date date = df2.parse("1983年5月10日 10时45分59秒");
        System.out.println(date);

        //测试其他的格式字符，利用D获得本时间对象是所属年份的第几天
        DateFormat df3 = new SimpleDateFormat("D");//格式化，具体字母查API手册，这一年中的第几天
        String str3 = df3.format(new Date());
        System.out.println(str3);
    }
}
