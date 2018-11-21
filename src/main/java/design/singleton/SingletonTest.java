package design.singleton;

import java.lang.reflect.Constructor;

public class SingletonTest {

    public static void main(String[] args) throws Exception {
        BadMash badMash = BadMash.getInstance();


        Constructor constructor = BadMash.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BadMash badMash1 = (BadMash) constructor.newInstance();

        System.out.println(badMash == badMash1);
    }
}
