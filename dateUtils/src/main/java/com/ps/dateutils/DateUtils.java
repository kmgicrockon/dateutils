package com.ps.dateutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    /**
     * @param timeStamp
     * @param format
     * @return String (Date based on format) Or Blank ("")
     * @Description TimestempToDate method use to convert Unix TimeStamp to specified date format from
     * Constant.DATE_FORMAT
     */
    public static final String timestampToDate(long timeStamp, String format) {
        try {
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
            mSimpleDateFormat.setTimeZone(TimeZone.getDefault());
            return mSimpleDateFormat.format(new Date(timeStamp * 1000));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     *
     * @param timeStamp
     * @param format
     * @param timeZone
     * @return String (Date based on format) Or Blank ("")
     * @Description TimestempToDate method use to convert Unix TimeStamp to specified date format from
     * Constant.DATE_FORMAT
     */
    public static final String timestampToDate(long timeStamp, String format, TimeZone timeZone) {
        try {
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
            mSimpleDateFormat.setTimeZone(timeZone);
            return mSimpleDateFormat.format(new Date(timeStamp * 1000));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     *
     * @param oldDate
     * @param oldDateFormat
     * @param oldTimeZone
     * @param newDateFormat
     * @param newTimeZone
     * @return
     */
    public static String getDateInFormat(String oldDate, String oldDateFormat, TimeZone oldTimeZone, String newDateFormat, TimeZone newTimeZone) {
        SimpleDateFormat oldFormatter = new SimpleDateFormat(oldDateFormat, Locale.getDefault());
        oldFormatter.setTimeZone(oldTimeZone);
        String dueDateAsNormal = "";
        try {
            Date value = oldFormatter.parse(oldDate);
            SimpleDateFormat newFormatter = new SimpleDateFormat(newDateFormat, Locale.getDefault());
            newFormatter.setTimeZone(newTimeZone);
//            newFormatter.timeZone = TimeZone.getDefault()
            dueDateAsNormal = newFormatter.format(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dueDateAsNormal;
    }
}
