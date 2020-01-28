package annotation;

/**
 * @Author:
 */
public @interface MyAnno {
    int value();
    Person per();
    MyAnno2 anno2();
    String[] strs();

}
