package design.singleton;

public class BadMash {

    private static final BadMash INSTANCE = new BadMash();

    public static BadMash getInstance() {
        return INSTANCE;
    }
}
