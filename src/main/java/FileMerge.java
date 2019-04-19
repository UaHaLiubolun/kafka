import java.io.*;

public class FileMerge {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("请输入文件路径");
            return;
        }
        String fileName = args[0];
        File file = new File(fileName);

        File[] files = file.listFiles();
        if (files.length == 0) {
            System.out.println("文件夹下没有文件");
            return;
        }
        File file1 = new File(fileName + File.separator + "merge.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1)));
        for (int i = 0; i < files.length; i++) {
            FileInputStream inputStream = new FileInputStream(files[i]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String fName = files[i].getName().replace(".txt", "");
            while (true) {
                String str = reader.readLine();
                if (str == null) {
                    break;
                }
                // 如果包含文件名 跳过
                if (str.contains(fName)) {
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
                writer.write(fName + ":" + str);
                writer.newLine();
            }

            inputStream.close();
        }
        writer.close();
        System.out.println("合并完成");
    }
}
