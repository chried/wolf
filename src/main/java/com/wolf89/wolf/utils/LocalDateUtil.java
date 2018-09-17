package com.wolf89.wolf.utils;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * 最新时间工具类.
 *
 * @author chried
 */
public final class LocalDateUtil {

    // 转换格式.
    public static final DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * 将日期按照特定格式转换.
     *
     * @param time      时间.
     * @param formatter 格式.
     * @return 字符串.
     */
    public static String convertDateToString(TemporalAccessor time, DateTimeFormatter formatter) {
        return formatter.format(time);
    }
}
