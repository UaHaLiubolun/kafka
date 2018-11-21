package com.chinamcloud.kafak;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileRead {

    private String address = "C:\\Users\\Jhon\\Desktop\\default";

    public List<String> read(String action){
        File file = new File(address + "\\" + action);
        List<String> result = new LinkedList<>();
        try {
            File[] files = file.listFiles();
            for (File f:
                 files) {
                File[] f_1 = f.listFiles();
                for (File f_2:
                     f_1) {
                    InputStream inputStream = new FileInputStream(f_2);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String str = null;
                    while((str = bufferedReader.readLine()) != null)
                    {
                        result.add(str);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        FileRead fileRead = new FileRead();
        fileRead.read("item");
    }
}
