package phone.operate;

import java.io.IOException;
import java.util.Random;

public class BasicOperate {

    private Runtime runtime = Runtime.getRuntime();

    private Random random = new Random();

    private void inputTap(Button button, String phone) throws IOException {
        try {
            int[] pos = getPos(button);
            String command = "adb -s " + phone + " shell input tap " + pos[0] + " " +  pos[1];
            String[] commands = {"adb", "-s", phone, "shell", "input", "tap", String.valueOf(pos[0]), String.valueOf(pos[1])};
            System.out.println(command);
            runtime.exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private int[] getPos(Button button) {
        int[] pos = new int[2];
        Integer[] address = button.getAddresss();
        pos[0] = random.nextInt((address[2] - address[0]) + 1) + address[0];
        pos[1] = random.nextInt((address[3] - address[1]) + 1) + address[1];
        return pos;
    }

    public static void main(String[] args) throws Exception{
        String phone = "127.0.0.1:62001";
        BasicOperate basicOperate = new BasicOperate();
//        basicOperate.inputTap(Button.PROFILE_BTN, phone);
        basicOperate.inputTap(Button.ALL_HISTORY_MSG, phone);
    }
}
