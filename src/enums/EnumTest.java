package enums;

import java.util.*;

/**
 * 枚举体就是放置一些常量，不要使用枚举的高级特性，否则可以用普通类代替
 * @Author:
 */
public class EnumTest {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL,MEDIUM,LARGE,EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class,input);
        System.out.println("size=" +size);
        System.out.println("abbreviation="+size.getAbbreviation());
        if(size == Size.EXTRA_LARGE)
            System.out.println("Good Job");
        System.out.println(size.toString());

    }
}
 enum Size
 {
     SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");

     private Size(String abbreviation){this.abbreviation = abbreviation;}
     public String getAbbreviation(){return abbreviation; }

     private String abbreviation;

 }