package com.tingyu;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

public class PhoneNumber_back {
    private static int num = 500000;
    private static long size = 13 * num; // 11个字节的电话号码+两个字节的换行符\r\n
    private static ByteComparator comparator = new ByteComparator();
    private static int splitNum = 1;    // 文件分割的个数

    private static byte[] lineSeparator = "\r\n".getBytes();

    public static void main(String[] args) throws IOException {
//        if (args.length < 2) {
//            System.out.println("请输入正确的参数！");
//            return;
//        }
        String sourcePath = "E:\\编程练习\\2017Q4\\test\\phonenum.txt";
        String outPath = "E:\\编程练习\\2017Q4\\test\\phoneout.txt";

        long startTime = System.currentTimeMillis();

        // 分--将大文件拆分成多个小文件分别排序
        String splitFile = splitAndSortFile(sourcePath, size);
        //String splitFile = "E:\\编程练习\\2017Q4\\test\\phonenum-split.txt";
        sortFile(splitFile, outPath);

        long endTime = System.currentTimeMillis();
        System.out.println("排序完成，耗时：" + (endTime - startTime) + "毫秒");

        // 删除中间文件
        new File(splitFile).deleteOnExit();
    }

    private static String splitAndSortFile(String fileName, long splitSize) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("输入文件不存在，请检查！");
            return "";
        }
        String filePath = file.getAbsolutePath().replace(".txt", "");
        File splitFile = new File(filePath + "-split.txt");
        splitFile.createNewFile();
        FileChannel channel = new RandomAccessFile(file, "r").getChannel();
        long fileSze = channel.size();
        splitSize = splitSize > fileSze ? fileSze : splitSize;
        int currIndex = 0;
        MappedByteBuffer buffer;

        MappedByteBuffer splitBuffer;
        FileChannel splitChannel = new RandomAccessFile(splitFile, "rw").getChannel();
        while (currIndex < fileSze) {
            // 获取当前分割的size
            splitSize = fileSze - currIndex > splitSize ? splitSize : fileSze - currIndex;
            buffer = channel.map(FileChannel.MapMode.READ_ONLY, currIndex, splitSize);

            System.out.println("正在分割文件：" + splitFile.getAbsolutePath() + "第" + splitNum + "部分，并且排序中  ......");
            splitBuffer = splitChannel.map(FileChannel.MapMode.READ_WRITE, currIndex, splitSize);
            // sort
            List<byte[]> phoneNumberList = readBufferToList(buffer, (int)size);
            buffer.clear();
            Collections.sort(phoneNumberList, comparator);
           // Arrays.sort(phoneNumberList,comparator);

            for (Object bytes : phoneNumberList) {
                splitBuffer.put((byte[]) bytes);
                splitBuffer.put(lineSeparator);
            }
            phoneNumberList.clear();
            // 写入文件
            splitBuffer.force();
            splitBuffer.clear();

            // 指针偏移
            splitNum++;
            currIndex += splitSize;
        }
        splitNum--;
        channel.close();
        splitChannel.close();
        return splitFile.getAbsolutePath();
    }

    private static List<byte[]> readBufferToList(MappedByteBuffer srcBuffer, long size) {
        byte[] phoneNumberByte = new byte[11];
        List<byte[]> phoneNumberList = new ArrayList<>(0);
        long index = 0;
        while (index < size) {
            srcBuffer.get(phoneNumberByte);
            phoneNumberList.add(phoneNumberByte);
            srcBuffer.position(srcBuffer.position() + 2);
            index += 13;
            phoneNumberByte = new byte[11];
        }
        return phoneNumberList;
    }

    private static void sortFile(String splitFile, String filePath) throws IOException {
        int sortSize = (int)size / splitNum;
        int sortIndex = 0;
        int outIndex = 0;

        List<byte[]> sortPhoneNumberList = new ArrayList<>(0);
        MappedByteBuffer buffer;
        MappedByteBuffer outBuffer;
        FileChannel outChannel = new RandomAccessFile(filePath, "rw").getChannel();
        int part = 1;
        long splitPartIndex;
        FileChannel splitChannel = new RandomAccessFile(splitFile, "r").getChannel();
        while (sortIndex < size) {
            System.out.println("正在合并第： " + part++ + " 部分");
            for(int splitPart = 0 ; splitPart < splitNum ; splitPart++){
                splitPartIndex = splitPart * size + sortIndex;
                buffer = splitChannel.map(FileChannel.MapMode.READ_ONLY, splitPartIndex, sortSize);
                sortPhoneNumberList.addAll(readBufferToList(buffer, sortSize));
                buffer.clear();
            }

            Collections.sort(sortPhoneNumberList, comparator);

            outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, outIndex, size);
            for (byte[] bytes : sortPhoneNumberList) {
                outBuffer.put(bytes);
                outBuffer.put(lineSeparator);
            }
            sortPhoneNumberList.clear();
            outBuffer.force();
            sortIndex += sortSize;
            outIndex += size;
        }
        splitChannel.close();
        outChannel.close();
    }

    private static class ByteComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            byte[] a = (byte[]) o1;
            byte[] b = (byte[]) o2;
            for (int i = 3; i < a.length; i++) {
                if (a[i] > b[i]) {
                    return -1;
                } else if (a[i] < b[i]) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
