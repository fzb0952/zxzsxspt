package com.cdtu.utils;


import java.net.InetAddress;
import java.util.UUID;

/**
 * 有序UUID生成器 借鉴hibernate的UUID生成器 CustomVersionOneStrategy
 * 时间戳(6bytes, 48bit)：毫秒级别的，从1970年算起，能撑8925年....
 * 顺序号(2bytes, 16bit, 最大值65535): 没有时间戳过了一毫秒要归零的事，各搞各的，short溢出到了负数就归0。
 * 机器标识(4bytes 32bit): 拿localHost的IP地址，IPV4呢正好4个byte，但如果是IPV6要16个bytes，就只拿前4个byte。
 * 进程标识(4bytes 32bit)： 用当前时间戳右移8位再取整数应付，不信两条线程会同时启动。
 * 顺序号也不再是一次性的随机数而是自增序列了。
 * Created by tingyu on 2017/4/3.
 */
public class UUIDUtil {
    public static String generateUUIDString(){
        UUIDUtil uuid = new UUIDUtil();
        return uuid.generateUUID().toString().replaceAll("-","");
    }

    private final long mostSignificantBits;

    public UUIDUtil() {
        // generate the "most significant bits" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        byte[] hiBits = new byte[8];
        // use address as first 32 bits (8 * 4 bytes)
        System.arraycopy( getAddressBytes(), 0, hiBits, 0, 4 );
        // use the "jvm identifier" as the next 32 bits
        System.arraycopy( getJvmIdentifierBytes(), 0, hiBits, 4, 4 );
        // set the version (rfc term) appropriately
        hiBits[6] &= 0x0f;
        hiBits[6] |= 0x10;

        mostSignificantBits = BytesUtil.asLong( hiBits );
    }

    public UUID generateUUID() {
        long leastSignificantBits = generateLeastSignificantBits( System.currentTimeMillis() );
        return new UUID( mostSignificantBits, leastSignificantBits );
    }

    public long getMostSignificantBits() {
        return mostSignificantBits;
    }

    public static long generateLeastSignificantBits(long seed) {
        byte[] loBits = new byte[8];

        short hiTime = (short) ( seed >>> 32 );
        int loTime = (int) seed;
        System.arraycopy( BytesUtil.fromShort( hiTime ), 0, loBits, 0, 2 );
        System.arraycopy( BytesUtil.fromInt( loTime ), 0, loBits, 2, 4 );
        System.arraycopy( getCountBytes(), 0, loBits, 6, 2 );
        loBits[0] &= 0x3f;
        loBits[0] |= ((byte)2 << (byte)6);

        return BytesUtil.asLong( loBits );
    }

    // IP ADDRESS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private static final byte[] ADDRESS_BYTES;
    private static final int ADDRESS_INT;
    private static final String ADDRESS_HEX_STRING;

    static {
        byte[] address;
        try {
            address = InetAddress.getLocalHost().getAddress();
        }
        catch ( Exception e ) {
            address = new byte[4];
        }
        ADDRESS_BYTES = address;
        ADDRESS_INT = BytesUtil.toInt( ADDRESS_BYTES );
        ADDRESS_HEX_STRING = format( ADDRESS_INT );
    }

    public static byte[] getAddressBytes() {
        return ADDRESS_BYTES;
    }

    public static int getAddressInt() {
        return ADDRESS_INT;
    }

    public static String getAddressHexString() {
        return ADDRESS_HEX_STRING;
    }

    // JVM identifier ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private static final byte[] JVM_IDENTIFIER_BYTES;
    private static final int JVM_IDENTIFIER_INT;
    private static final String JVM_IDENTIFIER_HEX_STRING;

    static {
        JVM_IDENTIFIER_INT = (int) ( System.currentTimeMillis() >>> 8 );
        JVM_IDENTIFIER_BYTES = BytesUtil.fromInt( JVM_IDENTIFIER_INT );
        JVM_IDENTIFIER_HEX_STRING = format( JVM_IDENTIFIER_INT );
    }

    public static byte[] getJvmIdentifierBytes() {
        return JVM_IDENTIFIER_BYTES;
    }

    public static int getJvmIdentifierInt() {
        return JVM_IDENTIFIER_INT;
    }

    public static String getJvmIdentifierHexString() {
        return JVM_IDENTIFIER_HEX_STRING;
    }


    // counter ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static short counter = (short) 0;

    /**
     * Unique in a millisecond for this JVM instance (unless there are > Short.MAX_VALUE instances created in a
     * millisecond)
     */
    public static short getCountShort() {
        synchronized ( UUIDUtil.class ) {
            if ( counter < 0 ) {
                counter = 0;
            }
            return counter++;
        }
    }

    public static byte[] getCountBytes() {
        return BytesUtil.fromShort( getCountShort() );
    }


    // Helper methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String format(int value) {
        final String formatted = Integer.toHexString( value );
        StringBuilder buf = new StringBuilder( "00000000" );
        buf.replace( 8 - formatted.length(), 8, formatted );
        return buf.toString();
    }

    public static String format(short value) {
        String formatted = Integer.toHexString( value );
        StringBuilder buf = new StringBuilder( "0000" );
        buf.replace( 4 - formatted.length(), 4, formatted );
        return buf.toString();
    }
}
