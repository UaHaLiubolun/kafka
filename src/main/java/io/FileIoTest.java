/*
 * @projectName kafak
 * @package io
 * @className io.FileIoTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * FileIoTest
 * @description TODO
 * @author liubolun
 * @date 2019年11月07日 20:45
 * @version 2.9
 */
public class FileIoTest {

    private String address = "/Users/liubolun/Downloads/fileIoTest/";

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        FileIoTest fileIoTest = new FileIoTest();
        Executor executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            final int value = i;
            executor.execute(() -> fileIoTest.write(value, start));
        }
//        System.out.println(System.currentTimeMillis() - start);
//        new CountDownLatch(1).await();
    }

    private void write(int i, long start) {
        File file = new File(address + i);
        try (OutputStream outputStream = new FileOutputStream(file)){
            byte[] bytes = new byte[1024 * 1024];
            for (int j = 0; j < 1024; j++) {
                outputStream.write(bytes);
            }
            System.out.println(i + ": " + (System.currentTimeMillis() - start));
        } catch (IOException e) {

        }
    }
}
