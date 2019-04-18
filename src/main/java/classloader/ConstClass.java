package classloader;

public class ConstClass {

    static {
        System.out.println("ConstClass init");
    }

    public static String HELLO_WORLD = "hello world";

}
