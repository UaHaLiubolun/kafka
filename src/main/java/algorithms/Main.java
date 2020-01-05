package algorithms;

// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        if (m <= 1 || m >= 100) {
            System.out.println("ERROR!");
            return;
        }
        boolean[] in = new boolean[100];
        int last = 100;
        int j = 0, count = 0;
        while (last >= m) {
            if (!in[j]) {
                count++;
                if (count == m) {
                    in[j] = true;
                    last --;
                    count = 0;
                }
            }
            j++;
            if (j == 100) {
                j = 0;
            }
        }
        String result = "";
        for (int i = 0; i < 100; i++) {
            if (!in[i]) {
                result = result + (i + 1) + ",";
            }
        }
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
    }
}
