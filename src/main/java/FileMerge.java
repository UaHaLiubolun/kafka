import java.io.*;

public class FileMerge {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("请输入文件路径");
        }
        String fileName = args[0];
        File file = new File(fileName);

        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        File file1 = new File(fileName + ".tmp");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1)));

        while (true) {
            String str = reader.readLine();
            if (str == null) {
                break;
            }
            // 如果包含文件名 跳过
            if (str.contains(file.getName())) {
                continue;
            }
            // 如果包含空格 跳过
            if (str.contains(" ")) {
                continue;
            }
            // 如果什么都没有 跳过
            if (str.equals("")) {
                continue;
            }
            writer.write(file.getName() + ":" + str);
            writer.newLine();
        }

        inputStream.close();
        writer.close();

        System.out.println("合并完成");
    }
}
