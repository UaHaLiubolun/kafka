package netty.two.nio;


import java.io.IOException;

public class TimeClient {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClientNio-1").start();
    }
}
