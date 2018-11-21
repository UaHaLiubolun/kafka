public class TestSingleLock {

    private static Test test;

    public static Test getTest() {
        if (test == null) {
            synchronized (TestSingleLock.class) {
                if (test == null) {
                    test = new Test();
                }
            }
        }
        return test;
    }
}
