package phone.operate;

import java.io.IOException;
import java.util.Random;

public class BasicOperate {

    private Runtime runtime = Runtime.getRuntime();

    private Random random = new Random();

    private void inputTap(Button button, String phone) throws IOException {
        int[] pos = getPos(button);
        String command = "adb -s " + phone + " shell input tap " + pos[0] + " " +  pos[1];
        runtime.exec(command);
    }

    private void inputRoll(int[] pos, String phone) throws IOException{
        if (pos.length != 2) return;
        String command = "adb -s " + phone + " shell input roll " + pos[0] + " " +  pos[1];
        System.out.println(command);
        runtime.exec(command);
    }

    private void inputText(String text, String phone) throws IOException {
        String command = "adb -s " + phone + " shell input text " + text;
        runtime.exec(command);
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
        basicOperate.inputTap(Button.ADD_BTN, phone);
        Thread.sleep(5000);
        basicOperate.inputTap(Button.ADD_FRIEND, phone);
        Thread.sleep(5000);
        basicOperate.inputTap(Button.INPUT, phone);
        Thread.sleep(10000);
        basicOperate.inputText("cctvcomweixin", phone);
        Thread.sleep(5000);
        basicOperate.inputTap(Button.FIRST_ADD_FRIEND_RESULT, phone);
        Thread.sleep(5000);
        basicOperate.inputTap(Button.SEARCH, phone);
        Thread.sleep(10000);
        basicOperate.inputTap(Button.GZH_BUTTON, phone);
        Thread.sleep(5000);
        basicOperate.inputTap(Button.FIRST_SEARCH_RESULT, phone);
        Thread.sleep(5000);
        basicOperate.inputTap(Button.GUAN_ZHU1, phone);
        Thread.sleep(1000);
        basicOperate.inputTap(Button.GUAN_ZHU2, phone);
        Thread.sleep(1000);
        basicOperate.inputTap(Button.GUAN_ZHU3, phone);
        Thread.sleep(1000);
        basicOperate.inputTap(Button.GUAN_ZHU4, phone);
        Thread.sleep(1000);
        basicOperate.inputTap(Button.GUAN_ZHU5, phone);
        Thread.sleep(10000);
        basicOperate.inputTap(Button.PROFILE_BTN, phone);
        Thread.sleep(5000);
        basicOperate.inputTap(Button.BLACK, phone);
        int roll[] = {1, 1920};
        basicOperate.inputRoll(roll, phone);
        Thread.sleep(10000);
        basicOperate.inputTap(Button.ALL_HISTORY_MSG, phone);
        Thread.sleep(10000);
        basicOperate.inputRoll(roll, phone);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(3000);
            basicOperate.inputTap(Button.RETURN, phone);
        }
    }
}
