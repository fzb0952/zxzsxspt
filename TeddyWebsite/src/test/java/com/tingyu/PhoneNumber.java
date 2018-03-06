package com.tingyu;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

public class PhoneNumber {
    private static int num = 500000;
    private static int size = 13 * num; // 11个字节的电话号码+两个字节的换行符\r\n
    private static ByteComparator comparator = new ByteComparator();
    private static int splitNum = 1;    // 文件分割的个数
    private static Object[] phoneNumberList = new byte[num][13];
    private static List<byte[]> sortPhoneNumberList = new ArrayList<byte[]>(0);

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("请输入正确的参数！");
            return;
        }
        String sourcePath = args[0];
        String outPath = args[1];

        long startTime = System.currentTimeMillis();
        System.out.println("排序中，请稍候......");
        // 分--将大文件拆分成多个小文件分别排序
        String splitFile = splitAndSortFile(sourcePath, size);
        sortFile(splitFile, outPath);

        long endTime = System.currentTimeMillis();
        System.out.println("排序完成，耗时：" + (endTime - startTime) + "毫秒");
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
        long fileSize = channel.size();
        if(fileSize != 50000000 * 13){
            System.out.println("输入文件错误，请检查！");
            return "";
        }
        int currIndex = 0;
        MappedByteBuffer buffer;

        MappedByteBuffer splitBuffer;
        FileChannel splitChannel = new RandomAccessFile(splitFile, "rw").getChannel();

        while (currIndex < fileSize) {
            // 获取当前分割的size
            buffer = channel.map(FileChannel.MapMode.READ_ONLY, currIndex, splitSize);

           // System.out.println("正在分割文件：" + splitFile.getAbsolutePath() + "第" + splitNum + "部分，并且排序中  ......");
            splitBuffer = splitChannel.map(FileChannel.MapMode.READ_WRITE, currIndex, splitSize);
            // sort
            if(splitNum == 1){
                readBufferAdd(buffer, size, phoneNumberList, 0,sortPhoneNumberList);
            }else{
                readBufferSet(buffer, size, phoneNumberList, 0,sortPhoneNumberList);
            }
            buffer.clear();
            Collections.sort(sortPhoneNumberList, comparator);

            for(int i = 0 ; i < num ; i++){
                splitBuffer.put(sortPhoneNumberList.get(i));
            }

            // 写入文件
            splitBuffer.force();

            // 指针偏移
            splitNum++;
            currIndex += splitSize;
        }
        splitNum--;
        channel.close();
        splitChannel.close();
        return splitFile.getAbsolutePath();
    }

    private static int readBufferAdd(MappedByteBuffer srcBuffer, int size, Object[] phoneNumbers, int pos,List<byte[]> sortPhoneNumberList){
        int index = 0;
        while (index < size) {
            srcBuffer.get((byte[]) phoneNumbers[pos]);
            sortPhoneNumberList.add((byte[]) phoneNumbers[pos]);
            index += 13;
            pos++;
        }
        return pos;
    }

    private static int readBufferSet(MappedByteBuffer srcBuffer, int size, Object[] phoneNumbers, int pos,List<byte[]> sortPhoneNumberList) {
        int index = 0;
        while (index < size) {
            srcBuffer.get((byte[]) phoneNumbers[pos]);
            sortPhoneNumberList.set(pos,(byte[]) phoneNumbers[pos]);
            index += 13;
            pos++;
        }
        return pos;
    }

    private static void sortFile(String splitFile, String filePath) throws IOException {
        int sortSize = size / splitNum;
        int sortIndex = 0;
        int outIndex = 0;

        MappedByteBuffer buffer;
        MappedByteBuffer outBuffer;
        FileChannel outChannel = new RandomAccessFile(filePath, "rw").getChannel();
//        int part = 1;
        long splitPartIndex;
        FileChannel splitChannel = new RandomAccessFile(splitFile, "r").getChannel();
        int numIndex = 0;
        while (sortIndex < size) {
            //System.out.println("正在合并第： " + part++ + " 部分");

            for (int splitPart = 0; splitPart < splitNum; splitPart++) {
                splitPartIndex = splitPart * size + sortIndex;
                buffer = splitChannel.map(FileChannel.MapMode.READ_ONLY, splitPartIndex, sortSize);
                numIndex = readBufferSet(buffer, sortSize, phoneNumberList, numIndex,sortPhoneNumberList);
                buffer.clear();
            }

            Collections.sort(sortPhoneNumberList, comparator);

            outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, outIndex, size);

            for(int i = 0 ; i < num ; i++){
                outBuffer.put(sortPhoneNumberList.get(i));
            }

            outBuffer.force();
            sortIndex += sortSize;
            outIndex += size;
            numIndex = 0;
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
