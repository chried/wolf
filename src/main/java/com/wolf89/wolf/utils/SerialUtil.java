/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wolf89.wolf.utils;

import java.util.Random;

/**
 * 序号生成工作类.
 *
 * @author chried
 */
public final class SerialUtil {

    /**
     * 按照数字生成.
     */
    public static final String[] CHARS_DEC = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    /**
     * 按照16进制生成.
     */
    public static final String[] CHARS_HEX = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    /**
     * 按照字母生成.
     */
    public static final String[] CHARS_WORD = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * 数字加字母生成.
     */
    public static final String[] CHARS_ALL = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * 记录递归数，防止递归过多出现死循环.
     */
    private static transient volatile int recursionCount = 0;

    /**
     * 生成序号.
     *
     * @param len     生成序号长度.
     * @param charset 规则.
     * @return 序号.
     */
    public static String generator(int len, String[] charset) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(charset[new Random().nextInt(charset.length)]);
        }

        return sb.toString();
    }

    /**
     * 生成序号.
     *
     * @param len       生成序号长度.
     * @param seriesNum 想听字符最多允许连续数.
     * @param charset   规则.
     * @return 序号.
     */
    public static String generator(int len, int seriesNum, String[] charset) {

        if (seriesNum <= 1) {
            throw new RuntimeException("seriesNum必须大于等于2");
        }

        if (recursionCount == 5) {
            throw new RuntimeException("生成验证码错误[递归层数过多]");
        }

        recursionCount++;

        String serial = generator(len, charset);

        int count = 1; // 记录连续数.

        String currentStr = serial.substring(0, 1); // 取出首位作为标准.

        for (int i = 1; i < serial.length(); i++) {  // 编列字符串.

            String nextStr = serial.substring(i, i + 1); // 取出下一个字符串.

            if (currentStr.equals(nextStr)) {  // 判断当前跟下一个是否相等，如果相等+1;
                count++;
            } else {
                count = 1;
            }

            currentStr = nextStr;   //重写赋值当前字符串.

            if (count == seriesNum) { // 等于临界值，返回false.
                return generator(len, seriesNum, charset);
            }
        }

        recursionCount = 0;

        return serial;
    }

}
