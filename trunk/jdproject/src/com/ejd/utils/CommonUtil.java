/********************************************************************************
 * Create by   : Vincent Yuen
 * Date        : 06-Jan-2005
 *
 * Copyright (c) 2005 Kerry Logistics Network Limited
 *
 * All rights reserved. All information contained in this software is confidential and proprietary to
 * KLN Limited. No part of this software may be reproduced or transmitted in any form or any means,
 * electronic, mechanical, photocopying, recording or otherwise stored in any retrieval system of any
 * nature without the prior written permission of PCCW Limited.
 *
 * This material is a trade secret and its confidentiality is strictly maintained. Use of any copyright
 * notice does not imply unrestricted public access to this material.
 ********************************************************************************
 */

package com.ejd.utils;



import java.util.*;
import java.sql.Timestamp;

public class CommonUtil {
    public CommonUtil() {

    }

    public static String tlz(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return (s.substring(i));
            }
        }
        return ("");
    }

    /**
     * Just keep the following chars :
     * a-z,A-Z,0-9,;,(,),& and comma
     * 
     * @param str
     * @return
     */
    public static String removeInvalidCharForTraxon(String str){
    	if(str==null) return "";
		//return str.replaceAll("['\\(\\)/+:\r\n\\\\]","");
    	str = str.replaceAll("[\r\n]","");
		return str.replaceAll("[^a-zA-Z0-9\\(\\),;&\\s]","");
	}
    
    public static String rcc(String src) {
        return (rc(rc(rc(rc((src), "\r", ""), "\n", ""), "\t", " "), (char) 160 + "", ""));
    }

    public static String re(String src) {
        return (rc(rc(rc(rc(rc((src), "\r", ""), "\n", ""), "\t", " "), "\"", "`"), "'", "`"));
    }

    public static String x(String src, String exist, String notexist) {
        return ((src != null && src.equals("")) ? notexist : exist);
    }

    public static String n(String src, String notequalsto, String then) {
        return ((s(src).equals(notequalsto)) ? new String() : then);
    }

    public static String n(String src, String[] notequalsto, String then) {
        for (int i = 0; notequalsto != null && i < notequalsto.length; i++) {
            if (s(src).equals(s(notequalsto[i]))) {
                return (new String());
            }
        }
        return (then);
    }

    public static String w(String src, String equalsto, String then) {
        return ((s(src).equals(equalsto)) ? then : new String());
    }

    public static String w(String src, String[] equalsto, String then) {
        for (int i = 0; equalsto != null && i < equalsto.length; i++) {
            if (s(src).equals(s(equalsto[i]))) {
                return (then);
            }
        }
        return (new String());
    }

    public static String s(String src) {
        return ((src == null) ? new String() : rcc(src.trim()));
    }

    public static String s(Object src) {
        return ((src == null) ? new String() : rcc(src.toString().trim()));
    }

    public static String s(String src, String def) {
        return ((src == null) ? def : s(src));
    }

    public static String e(String src, String def) {
        String ss = s(src);
        return ((ss.equals("")) ? def : ss);
    }

    public static int i(String src) {
        return ((s(src).equals("")) ? 0 : new Integer(src).intValue());
    }

    public static int i(String src, int def) {
        int ii = i(src);
        return ((ii == 0) ? def : ii);
    }

    public static float f(String src) {
        return ((s(src).equals("")) ? 0 : new Float(src).floatValue());
    }

    public static float f(String src, float def) {
        float ff = f(src);
        return ((ff == 0) ? def : ff);
    }

    public static long l(String src) {
        return ((s(src).equals("")) ? 0 : new Long(src).longValue());
    }

    public static long l(String src, long def) {
        long ll = l(src);
        return ((ll == 0) ? def : ll);
    }

    public static double d(String src) {
        return ((s(src).equals("")) ? 0 : new Double(src).doubleValue());
    }

    public static double d(String src, double def) {
        double dd = d(src);
        return ((dd == 0) ? def : dd);
    }

    public static String rc(String src, String ch, String rp) {
        for (int i = src.indexOf(ch); i != -1; i = src.indexOf(ch, i + rp.length())) {
            src = src.substring(0, i) + rp + src.substring(i + ch.length(), src.length());
        }
        return (src);
    }

    public static String lz(int src, int len) {
        return (lz(src + "", len));
    }

    public static String lz(String src, int len) {
        for (int i = 0; src.length() < len; i++) {
            src = "0" + src;
        }
        return (src);
    }

    public static String tz(int src, int len) {
        return (tz(src + "", len));
    }

    public static String tz(String src, int len) {
        for (int i = 0; src.length() < len; i++) {
            src = src + "0";
        }
        return (src);
    }

    public static String ls(int src, int len) {
        return (ls(src + "", len));
    }

    public static String ls(String src, int len) {
        for (int i = 0; src.length() < len; i++) {
            src = " " + src;
        }
        return (src);
    }

    public static String ts(int src, int len) {
        return (ts(src + "", len));
    }

    public static String ts(String src, int len) {
        for (int i = 0; src.length() < len; i++) {
            src = src + " ";
        }
        return (src);
    }

    public static String mc(String ch, int len) {
        StringBuffer st = new StringBuffer(512);
        for (int i = 0; i < len; i++) {
            st.append(ch);
        }
        return (st.toString());
    }

    public static int ic(String src, String ta) {
        int counter = 0;
        while (src.indexOf(ta) != -1) {
            counter++;
            src = src.substring(src.indexOf(ta) + ta.length(), src.length());
        }
        return (counter);
    }

    public static String[] sp(String src, String seperator) {
        int NoOfSegment = ic(src, seperator) + 1;
        String[] result = new String[NoOfSegment];
        for (int i = 0; i < NoOfSegment; i++) {
            try {
                result[i] = src.substring(0, src.indexOf(seperator));
                src = src.substring(src.indexOf(seperator) + seperator.length(), src.length());
            } catch (java.lang.StringIndexOutOfBoundsException e) {
                result[i] = src.substring(0, src.length());
            }
        }
        return (result);
    }

    public static String nullToSpace(String src) {
        return ((src == null) ? new String() : src.trim());
    }

    public static String filter(String src) {
        return ("'" + setAmpersand(setDoubleQuot(setQuotationMark(nullToSpace(src)))) + "'");
    }

    public static String setAmpersand(String src) {
        for (int i = src.indexOf("&"); i != -1; i = src.indexOf("&", i + 9)) {
            src = src.substring(0, i) + "\'||\'&\'||\'" + src.substring(i + 1, src.length());
        }
        return (src);
    }

    public static String setQuotationMark(String src) {
        for (int i = src.indexOf("\'"); i != -1; i = src.indexOf("\'", i + 2)) {
            src = src.substring(0, i) + "\'\'" + src.substring(i + 1, src.length());
        }
        return (src);
    }

    public static String setDoubleQuot(String src) {
        for (int i = src.indexOf("\""); i != -1; i = src.indexOf("\"", i + 9)) {
            src = src.substring(0, i) + "\'||\'\"\'||\'" + src.substring(i + 1, src.length());
        }
        return (src);
    }

    public static String mf(String src) {
        return (setQuotationMark(src));
    }

    public static String of(String src) {
        return (setAmpersand(setDoubleQuot(setQuotationMark(nullToSpace(src)))));
    }

    public static String m(String key, String value) {
        String criteria = new String();
        String subCriteria = new String();
        String[] values;
        if (value != null && !value.trim().equals("")) {
            values = sp(setDoubleQuot(setQuotationMark(value)), ",");
            if (values.length == 1 && !values[0].trim().equals("")) {
                if ((values[0].indexOf("%") != -1) || (values[0].indexOf("_") != -1)) {
//        criteria += key + " LIKE '" + value.trim() + "' AND ";
                    criteria += key + " LIKE '" + values[0].trim() + "' ";
                } else {
//        criteria += key + " = '" + value.trim() + "' AND ";
                    criteria += key + " = '" + values[0].trim() + "' ";
                }
            } else {
                criteria += "   (";
                subCriteria = new String();
                for (int i = 0; i < values.length; i++) {
                    if ((values[i].indexOf("%") != -1) || (values[i].indexOf("_") != -1)) {
                        criteria += key + " LIKE '" + values[i].trim() + "' OR ";
                    } else if (values[i] != null && !values[i].trim().equals("")) {
                        subCriteria += "'" + values[i].trim() + "', ";
                    }
                }
                if (subCriteria != null && !subCriteria.trim().equals("")) {
                    subCriteria = subCriteria.substring(0, subCriteria.length() - 2);
//        criteria += key + " IN (" + subCriteria + ")) AND ";
                    criteria += key + " IN (" + subCriteria + ")) ";
                } else if (criteria != null && criteria.trim().endsWith("OR")) {
//        criteria = criteria.trim().substring(0, criteria.trim().length() - 2) + ") AND ";
                    criteria = criteria.trim().substring(0, criteria.trim().length() - 2) + ") ";
                }
            }
        }
        return (criteria);
    }

    public static String o(String key, String value) {
        String criteria = new String();
        String subCriteria = new String();
        String[] values;
        if (value != null && !value.trim().equals("")) {
            values = sp(value, ",");
            if (values.length == 1 && !values[0].trim().equals("")) {
                if ((values[0].indexOf("%") != -1) || (values[0].indexOf("_") != -1)) {
//        criteria += key + " LIKE " + filter(value.trim()) + " AND ";
                    criteria += key + " LIKE " + filter(value.trim());
                } else {
//        criteria += key + " = " + filter(value.trim()) + " AND ";
                    criteria += key + " = " + filter(value.trim());
                }
            } else {
                criteria += "   (";
                subCriteria = new String();
                for (int i = 0; i < values.length; i++) {
                    if ((values[i].indexOf("%") != -1) || (values[i].indexOf("_") != -1)) {
                        criteria += key + " LIKE " + filter(values[i].trim()) + " OR ";
                    } else if (values[i] != null && !values[i].trim().equals("")) {
                        subCriteria += filter(values[i].trim()) + ", ";
                    }
                }
                if (subCriteria != null && !subCriteria.trim().equals("")) {
                    subCriteria = subCriteria.substring(0, subCriteria.length() - 2);
//        criteria += key + " IN (" + subCriteria + ")) AND ";
                    criteria += key + " IN (" + subCriteria + ")) ";
                } else if (criteria != null && criteria.trim().endsWith("OR")) {
//        criteria = criteria.trim().substring(0, criteria.trim().length() - 2) + ") AND ";
                    criteria = criteria.trim().substring(0, criteria.trim().length() - 2) + ") ";
                }
            }
        }
        return (criteria);
    }

    public static String td() {
        return (td(2));
    }

    public static String td(int i) {
        Calendar now = Calendar.getInstance();
        switch (i) {
            case 1:
                return (lz(now.get(Calendar.YEAR), 2) + "/" + lz(now.get(Calendar.MONTH) + 1, 2) + "/" + now.get(Calendar.DATE));
            default:
                return (lz(now.get(Calendar.DATE), 2) + "/" + lz(now.get(Calendar.MONTH) + 1, 2) + "/" + now.get(Calendar.YEAR));
        }
    }

    public static String gd() {
        Calendar calendar = Calendar.getInstance();
        String y = "" + calendar.get(Calendar.YEAR);
        String m = "0" + (calendar.get(Calendar.MONTH) + 1);
        m = m.substring(m.length() - 2, m.length());
        String d = "0" + calendar.get(Calendar.DATE);
        d = d.substring(d.length() - 2, d.length());
        String h = "0" + calendar.get(Calendar.HOUR_OF_DAY);
        h = h.substring(h.length() - 2, h.length());
        String mi = "0" + calendar.get(Calendar.MINUTE);
        mi = mi.substring(mi.length() - 2, mi.length());
        String s = "0" + calendar.get(Calendar.SECOND);
        s = s.substring(s.length() - 2, s.length());
        return (y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s);
    }
    public static String gd(int dayAfter_or_before) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dayAfter_or_before);

        String y = "" + calendar.get(Calendar.YEAR);
        String m = "0" + (calendar.get(Calendar.MONTH) + 1);
        m = m.substring(m.length() - 2, m.length());
        String d = "0" + calendar.get(Calendar.DATE);
        d = d.substring(d.length() - 2, d.length());
        String h = "0" + calendar.get(Calendar.HOUR_OF_DAY);
        h = h.substring(h.length() - 2, h.length());
        String mi = "0" + calendar.get(Calendar.MINUTE);
        mi = mi.substring(mi.length() - 2, mi.length());
        String s = "0" + calendar.get(Calendar.SECOND);
        s = s.substring(s.length() - 2, s.length());
        return (y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s);
    }
    public static String gds() {
        Calendar calendar = Calendar.getInstance();
        String y = "" + calendar.get(Calendar.YEAR);
        String m = "0" + (calendar.get(Calendar.MONTH) + 1);
        m = m.substring(m.length() - 2, m.length());
        String d = "0" + calendar.get(Calendar.DATE);
        d = d.substring(d.length() - 2, d.length());
        String h = "0" + calendar.get(Calendar.HOUR_OF_DAY);
        h = h.substring(h.length() - 2, h.length());
        String mi = "0" + calendar.get(Calendar.MINUTE);
        mi = mi.substring(mi.length() - 2, mi.length());
        String s = "0" + calendar.get(Calendar.SECOND);
        s = s.substring(s.length() - 2, s.length());
        return (y + m + d + h + mi + s);
    }

    public static String gts() {
        Calendar calendar = Calendar.getInstance();
        String h = "0" + calendar.get(Calendar.HOUR_OF_DAY);
        h = h.substring(h.length() - 2, h.length());
        String mi = "0" + calendar.get(Calendar.MINUTE);
        mi = mi.substring(mi.length() - 2, mi.length());
        String s = "0" + calendar.get(Calendar.SECOND);
        s = s.substring(s.length() - 2, s.length());
        return (h + mi + s);
    }

    public static String getDay() {
        Calendar calendar = Calendar.getInstance();
        String d = "0" + calendar.get(Calendar.DATE);
        d = d.substring(d.length() - 2, d.length());
        return d;
    }

    public static String getMonth() {
        Calendar calendar = Calendar.getInstance();
        String m = "0" + (calendar.get(Calendar.MONTH) + 1);
        m = m.substring(m.length() - 2, m.length());
        return m;
    }

    public static String getYear() {
        Calendar calendar = Calendar.getInstance();
        String y = "" + calendar.get(Calendar.YEAR);
        y = y.substring(2, 4);
        return y;
    }

    public static String getHour() {
        Calendar calendar = Calendar.getInstance();
        String h = "0" + calendar.get(Calendar.HOUR_OF_DAY);
        h = h.substring(h.length() - 2, h.length());
        return h;
    }

    public static String getMinute() {
        Calendar calendar = Calendar.getInstance();
        String mi = "0" + calendar.get(Calendar.MINUTE);
        mi = mi.substring(mi.length() - 2, mi.length());
        return mi;
    }


    public static String getYear(java.sql.Timestamp ts) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate = ts.toString().substring(0, 10);
            oracleDate = getYear(oracleDate);
        }
        return oracleDate;
    }

    public static String getYear(String stringDate) {
        String year = "";
        int checkyear = -1;

        if (stringDate.trim().equals("")) {
            return "";
        } else {
            int index = stringDate.indexOf("-");
            year = stringDate.substring(0, index);


            if (year.length() == 4)
                year = year.substring(2, 4);
            else if (year.length() != 2)
                year = "";
            return year;
        }

    }

    public static String getMonth(java.sql.Timestamp ts) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate = ts.toString().substring(0, 10);
            oracleDate = getMonth(oracleDate);
        }
        return oracleDate;
    }

    public static String getMonth(String stringDate) {
        String month = "";


        int checkyear = -1;

        if (stringDate.trim().equals("")) {
            return "";
        } else {
            int index = stringDate.indexOf("-");
            int lastIndex = stringDate.lastIndexOf("-");
            month = stringDate.substring(index + 1, lastIndex);

            return month;
        }

    }

    public static String getDay(java.sql.Timestamp ts) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate = ts.toString().substring(0, 10);
            oracleDate = getDay(oracleDate);
        }
        return oracleDate;
    }

    public static String getDay(String stringDate) {
        String day = "";


        int checkyear = -1;

        if (stringDate.trim().equals("")) {
            return "";
        } else {
            int index = stringDate.indexOf("-");
            int lastIndex = stringDate.lastIndexOf("-");
            day = stringDate.substring(lastIndex + 1, lastIndex + 3);

            return day;
        }

    }

    public static int pageRequired(int noOfRecord, int recordOnOnePage) {
        return (new Double((noOfRecord / recordOnOnePage) + (((noOfRecord % recordOnOnePage) > 0) ? 1 : 0)).intValue());
    }

    public static int pageStart(int pageNo, int recordOnOnePage) {
        return (((pageNo - 1) * recordOnOnePage) + 1);
    }

    public static String fn(String pattern, int num) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat(pattern);
        return (decimalFormat.format(num));
    }

    public static String fn(String pattern, long num) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat(pattern);
        return (decimalFormat.format(num));
    }

    public static String fn(String pattern, float num) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat(pattern);
        return (decimalFormat.format(num));
    }

    public static String fn(String pattern, double num) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat(pattern);
        return (decimalFormat.format(num));
    }

    public static boolean isValidDate(int YYYY, int MM, int DD) {
        int[] DayOfTheMonth = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (YYYY < 1950 || YYYY > 2050)
            return (false);
        if (MM == 2 && DD > 29)
            return (false);
        if (MM == 2 && DD == 29 && !isLeapYear(YYYY))
            return (false);
        if (DD > DayOfTheMonth[MM])
            return (false);

        return (true);
    }

    public static boolean isLeapYear(int YYYY) {
        return ((((YYYY % 4) == 0) && (YYYY % 100) != 0) || ((YYYY % 400) == 0));
    }

    public static boolean valid(String d) {
        if (d != "" && d.length() == 10) {
            return (isValidDate(i(d.substring(6, 10)), i(d.substring(3, 5)), i(d.substring(0, 2))));
        } else {
            return (false);
        }
    }

    public static java.util.Date getd(String d) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(i(d.substring(6, 10)), i(d.substring(3, 5)) - 1, i(d.substring(0, 2)));
        return (calendar.getTime());
    }

    public static boolean ett(String d) {
        return (etd(d, td()));
    }

    public static boolean etd(String d, String td) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.util.Date valid_date;

        if (d == null || (d != null && d.length() != 10) || !valid(d)) {
            return (false);
        } else if (td == null || (td != null && td.length() != 10) || !valid(td)) {
            return (false);
        } else {
            if (getd(td).compareTo(getd(d)) > 0) {
                return (true);
            } else {
                return (false);
            }
        }
    }

    public static String fd(java.util.Date d) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(d);
        return (lz(calendar.get(Calendar.DATE), 2) + "/" + lz(calendar.get(Calendar.MONTH) + 1, 2) + "/" + calendar.get(Calendar.YEAR));
    }

    public static String cdf(String d) {
        return (d.substring(6, 10) + "-" + d.substring(3, 5) + "-" + d.substring(0, 2));
    }

    public static String[] DateTags() {
        return (DateTags(14));
    }

    public static String[] DateTags(int daysAhead) {
        Calendar now = Calendar.getInstance();
        Calendar ahead = Calendar.getInstance();
        String[] Tags = new String[daysAhead];
        if (daysAhead <= 0) {
            return (null);
        }
        for (int i = 0, j = 0; i < daysAhead; i++) {
            ahead.setTime(new java.util.Date(now.getTime().getTime() + (1000 * 60 * 60 * 24 * i)));
            if (ahead.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                Tags[j++] = fd(new java.util.Date(ahead.getTime().getTime()));
            } else {
                daysAhead++;
            }
        }
        return (Tags);
    }

    public static String[] DateTagsWeekDayOnly(int daysAhead) {
        Calendar now = Calendar.getInstance();
        Calendar ahead = Calendar.getInstance();
        String[] Tags = new String[daysAhead];
        if (daysAhead <= 0) {
            return (null);
        }
        for (int i = 0, j = 0; i < daysAhead; i++) {
            ahead.setTime(new java.util.Date(now.getTime().getTime() + (1000 * 60 * 60 * 24 * i)));
            if (ahead.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && ahead.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                Tags[j++] = fd(new java.util.Date(ahead.getTime().getTime()));
            } else {
                daysAhead++;
            }
        }
        return (Tags);
    }

    /**
     * given format of dd/mm/yyyy, and return yyyy-mm-dd
     * <p/>
     * <p/>
     *
     * @param stringDate - string of English time
     * @return Oracle date
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String toOracleDate(String stringDate) {
        String year = "";
        String month = "";
        String dateOfMonth = "";
        //   Calendar cal = Calendar.getInstance();
        int checkyear = -1;
        // if the incoming value is empty string
        try {
            if (stringDate.trim().equals("")) {
                return "''";
            } else {
                int index = stringDate.indexOf("/");
                dateOfMonth = stringDate.substring(0, index);
                int lastIndex = stringDate.lastIndexOf("/");
                year = stringDate.substring(lastIndex + 1, stringDate.length());
                month = stringDate.substring(index + 1, lastIndex);

                dateOfMonth = "0" + dateOfMonth;
                dateOfMonth = dateOfMonth.substring(dateOfMonth.length() - 2, dateOfMonth.length());
                month = "0" + month;
                month = month.substring(month.length() - 2, month.length());


                if (year.length() == 2) {
                    checkyear = 10 * (Integer.parseInt(year.substring(0, 1))) + Integer.parseInt(year.substring(1, 2));
                    if (checkyear >= 50) {
                        year = "19" + year;
                    } else {
                        year = "20" + year;
                    }
                }
//    Log.debug((year+"-"+month+"-"+dateOfMonth));
                return year + "-" + month + "-" + dateOfMonth;
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * given timestamp object and return string format of yyyy-mm-dd
     * <p/>
     * <p/>
     *
     * @param ts - Timestamp
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String toEnglishDate(java.sql.Timestamp ts) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate=ts.toString().substring(0, 10);
            oracleDate = toEnglishDate(oracleDate);
        }
        return oracleDate;
    }

    /**
     * given format of (yyyy-mm-dd hh:mm:ss.000000000 or yyyy-mm-dd) , and return dd/mm/yyyy
     * <p/>
     * <p/>
     *
     * @param stringDate - string of Oracle date
     * @return stringDate - string of English time
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String toEnglishDate(String stringDate) {
        String year = "";
        String month = "";
        String dateOfMonth = "";
        stringDate=stringDate.toString().substring(0, 10);
        //   Calendar cal = Calendar.getInstance();
        int checkyear = -1;
        // if the incoming value is empty string
        if (stringDate.trim().equals("")) {
            return "''";
        } else {
            int index = stringDate.indexOf("-");
            year = stringDate.substring(0, index);
            int lastIndex = stringDate.lastIndexOf("-");
            dateOfMonth = stringDate.substring(lastIndex + 1, lastIndex + 3);
            month = stringDate.substring(index + 1, lastIndex);

                 dateOfMonth = "0" + dateOfMonth;
                dateOfMonth = dateOfMonth.substring(dateOfMonth.length() - 2, dateOfMonth.length());
                month = "0" + month;
                month = month.substring(month.length() - 2, month.length());
            if (year.length() == 2) {
                checkyear = 10 * (Integer.parseInt(year.substring(0, 1))) + Integer.parseInt(year.substring(1, 2));
                if (checkyear >= 50) {
                    year = "19" + year;
                } else {
                    year = "20" + year;
                }
            }
            return dateOfMonth + "/" + month + "/" + year;
        }

    }

    /**
     * given timestamp object and return string format of yyyy-mm-dd
     * <p/>
     * <p/>
     *
     * @param ts - Timestamp
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String toEnglishDateTime(java.sql.Timestamp ts) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate=ts.toString().substring(0, 16);
            oracleDate = toEnglishDateTime(oracleDate);
        }
        return oracleDate;
    }

    /**
     * given format of (yyyy-mm-dd hh:mm:ss.000000000 or yyyy-mm-dd) , and return dd/mm/yyyy hh:mm
     * <p/>
     * <p/>
     *
     * @param stringDateTime - string of Oracle date
     * @return stringDate - string of English time
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String toEnglishDateTime(String stringDateTime) {
        String displayDateTime = toEnglishDate(stringDateTime);
        if (displayDateTime == null || displayDateTime.trim().equals(""))
            return "''";
        else
        {
            int index = stringDateTime.indexOf(":");
            displayDateTime = displayDateTime + " " + stringDateTime.substring(index - 2, index+3);
            return displayDateTime;
        }

    }

    /**
     * given timestamp object and return string format of hh
     * <p/>
     * <p/>
     *
     * @param ts - Timestamp
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String toEnglishHours(java.sql.Timestamp ts) {
        String hours = "";
        if (ts != null) {
            hours=ts.toString();
            int index = hours.indexOf(":");
            hours = hours.substring(index - 2, index);
        }
        return hours;
    }

    /**
     * given timestamp object and return string format of hh
     * <p/>
     * <p/>
     *
     * @param ts - Timestamp
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String toEnglishMinutes(java.sql.Timestamp ts) {
        String minutes = "";
        if (ts != null) {
            minutes=ts.toString();
            int index = minutes.lastIndexOf(":");
            minutes = minutes.substring(index - 2, index);
        }
        return minutes;
    }

    /**
     * given format of dd/mm/yyyy, and return yyyy-mm-dd hh:mm:ss.000000000
     * <p/>
     * <p/>
     *
     * @param stringDate - string of English time
     * @return Oracle date
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static java.sql.Timestamp[] toOracleDatetime(String[] stringDate) {
        java.sql.Timestamp[] oracleDate = null;
        if (stringDate == null) return null;
        for (int i = 0; stringDate.length < i; i++) {
            oracleDate[i] = java.sql.Timestamp.valueOf(toOracleDatetime(stringDate[i]));
        }

        return oracleDate;
    }
    /**
     * given format of dd/mm/yyyy, and return Timestamp yyyy-mm-dd hh:mm:ss.000000000
     * <p/>
     * <p/>
     *
     * @param stringDate - string of English time
     * @return Timestamp Oracle date
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static java.sql.Timestamp toOracleTimestamp(String stringDate,int intFlag) {
        java.sql.Timestamp oracleDate = null;
        if (stringDate == null) return null;
        try {
            oracleDate = java.sql.Timestamp.valueOf(toOracleDatetime(stringDate,intFlag));
        } catch (Exception e) {
            return null;
        }
        return oracleDate;
    }

    /**
     * given format of dd/mm/yyyy, and return Timestamp yyyy-mm-dd hh:mm:ss.000000000
     * <p/>
     * <p/>
     *
     * @param stringDate - string of English time
     * @return Timestamp Oracle date
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static java.sql.Timestamp toOracleTimestamp(String stringDate) {
        java.sql.Timestamp oracleDate = null;
        if (stringDate == null) return null;
        try {
            oracleDate = java.sql.Timestamp.valueOf(toOracleDatetime(stringDate));
        } catch (Exception e) {
            return null;
        }
        return oracleDate;
    }
   /**
     * given format of dd/mm/yyyy and time, and return Timestamp yyyy-mm-dd hh:mm:ss.000000000
     * <p/>
     * <p/>
     *
     * @param stringDate - string of English time
     * @return Timestamp Oracle date
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static java.sql.Timestamp toOracleTimestamp(String stringDate,String stringDateTime) {
        java.sql.Timestamp oracleDate = null;
        if (stringDate == null) return null;
        try {
            oracleDate = java.sql.Timestamp.valueOf(toOracleDatetime(stringDate,stringDateTime));
        } catch (Exception e) {
            return null;
        }
        return oracleDate;
    }

    /**
      * given string and int object and return long
      * <p/>
      * <p/>
      *
      * @param stringDate  - String
      * @param flag - int
      * @return long
      *         author 	Vincent Yuen
      *         version 	%I%, %G%
      */
    public static String toOracleDatetime(String stringDate, int flag) {
       if (stringDate == null) {
            return "''";
        }
        if (stringDate.trim().equals("")) {
            return "''";
        }
        String oracleDate = toOracleDate(stringDate);
         if (flag == 0)
             oracleDate = oracleDate + " 00:00:00.000000000";
         else if (flag == 1)
             oracleDate = oracleDate + " 23:59:59.000000000";
         else
         oracleDate=toOracleDatetime(stringDate);
        return oracleDate;
    }
    /**
     * given format of dd/mm/yyyy, and return yyyy-mm-dd hh:mm:ss.000000000
     * <p/>
     * <p/>
     *
     * @param stringDate - string of English time
     * @return Oracle date
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String toOracleDatetime(String stringDate) {
        if (stringDate == null) {
            return "''";
        }
        if (stringDate.trim().equals("")) {
            return "''";
        }

        String oracleDate = toOracleDate(stringDate);
        String zeros = "000000000";
        Calendar calendar = Calendar.getInstance();
        String h = "0" + calendar.get(Calendar.HOUR_OF_DAY);
        h = h.substring(h.length() - 2, h.length());
        String mi = "0" + calendar.get(Calendar.MINUTE);
        mi = mi.substring(mi.length() - 2, mi.length());
        String s = "0" + calendar.get(Calendar.SECOND);
        s = s.substring(s.length() - 2, s.length());
        oracleDate = oracleDate + " " + h + ":" + mi + ":" + s + "." + zeros;
        oracleDate = oracleDate.trim();
        int dividingSpace;
        dividingSpace = oracleDate.indexOf(' ');
        return oracleDate;
    }
   /**
     * given format of dd/mm/yyyy and String of time and return yyyy-mm-dd hh:mm:ss.000000000
     * <p/>
     * <p/>
     *
     * @param stringDate - string of English time
     * @return Oracle date
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String toOracleDatetime(String stringDate,String stringDateTime) {
        if (stringDate == null) {
            return "''";
        }
        if (stringDate.trim().equals("")) {
            return "''";
        }

String spaceCh= ":";
String h="";
String mi="";
       int spacePos=stringDateTime.indexOf(spaceCh);

   if (spacePos==-1) {
   h=stringDateTime.substring(0,2);
   mi=stringDateTime.substring(2,4);
   }else{
   h=stringDateTime.substring(0,spacePos);
   mi=stringDateTime.substring((spacePos+1),stringDateTime.length());
   }


        String oracleDate = toOracleDate(stringDate);
        String zeros = "000000000";

 //       Calendar calendar = Calendar.getInstance();
//         h  = stringDateTime.substring(0, 2);
//         mi = stringDateTime.substring(2, stringDateTime.length());


        String s = "00";
        oracleDate = oracleDate + " " + h + ":" + mi + ":" + s + "." + zeros;
        oracleDate = oracleDate.trim();
        int dividingSpace;
        dividingSpace = oracleDate.indexOf(' ');
        return oracleDate;
    }
    public static String getOracleDatetime() {
        String zeros = "000000000";
        String oracledate = gd() + "." + zeros;
        return oracledate;
    }
    public static String getOracleDatetime(int dayAfter_or_Before) {
        String zeros = "000000000";
        String oracledate = gd(dayAfter_or_Before) + "." + zeros;
        return oracledate;
    }
    /**
     * given long integer and return format of yyyy-mm-dd
     * <p/>
     * <p/>
     *
     * @param time - time in long
     * @return string of time
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String longToDate(long time) {
        Date d = new Date(time);
        return d.toString();
    }

    /**
     * given timestamp object and return String format of yyyy-mm-dd
     * <p/>
     * <p/>
     *
     * @param ts - Timestamp
     * @return long
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */

    public static long TStoLong(Timestamp ts) {
        return ts.getTime();
    }

    /**
     * given string and int object and return long
     * <p/>
     * <p/>
     *
     * @param str  - String
     * @param flag - int
     * @return long
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static long TStoLong(String str, int flag) {
        String str1 = str;
        Calendar calendar = Calendar.getInstance();
        if (flag == 0)
            str1 = str1 + " 00:00:00.000000000";
        else if (flag == 1)
            str1 = str1 + " 23:59:59.000000000";
        else
            str1 = str1 + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ".000000000";
        return (Timestamp.valueOf(str1)).getTime();
    }

    /**
     * given timestamp object and return string format of yyyy-mm-dd
     * <p/>
     * <p/>
     *
     * @param ts - Timestamp
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String TStoDateString(java.sql.Timestamp ts) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate = ts.toString().substring(0, 10);
        }
        return oracleDate;
    }

    /**
     * given timestamp string object and return string of oracle SQL TO_DATE string
     * <p/>
     * <p/>
     *
     * @param stringDate - String
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */

    public static String toOracleDateSQL(String stringDate) {
        String oracleDate = "";
        if (stringDate != null) {
            if (!stringDate.equals("")) {
                oracleDate = "TO_DATE(" + stringDate + ")";
            }
        }
        return oracleDate;
    }

    /**
     * given timestamp string object and return string of oracle SQL TO_DATE string
     * <p/>
     * <p/>
     *
     * @param stringDate       - String
     * @param stringDateFormat - String
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */

    public static String toOracleDateSQL(String stringDate, String stringDateFormat) {
        String oracleDate = "";
        if ((stringDate != null) && (stringDateFormat != null)) {
            if (!stringDate.equals("")) {
                oracleDate = "TO_DATE('" + stringDate + "','" + stringDateFormat + "')";
            }
        }
        return oracleDate;
    }

    /**
     * given Timestamp and String object and return string of oracle SQL TO_DATE string
     * <p/>
     * <p/>
     *
     * @param ts               - Timestamp
     * @param stringDateFormat - String
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */

    public static String TStoOracleDateSQL(java.sql.Timestamp ts, String stringDateFormat) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate = toOracleDateSQL(TStoDateString(ts), stringDateFormat);
        }
        return oracleDate;
    }

    /**
     * given String with Special Character and return string of Correct String
     * <p/>
     * <p/>
     *
     * @param objectstr - String
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */

    public static String DisplaySpecialChar(String objectstr) {
        int count = 0;
        String newobjectstr = "";


        int lineBreakCounter = 0;
        int addressLineBreakCounter = 2;




       if (objectstr == null) {
            return "";
        } else {
            if (objectstr.trim().length() > 0) {
                int orgSize = objectstr.length();
                for (count = 0; count < orgSize; count++) {
                 //   if (String.valueOf(objectstr.charAt(count)).equals("'"))
                 //       newobjectstr = newobjectstr + "&#039;";
                 // S20090629 Jeff
                    //if (String.valueOf(objectstr.charAt(count)).equals("\""))
                    	//newobjectstr = newobjectstr + "\'";
                    if (String.valueOf(objectstr.charAt(count)).equals("\"")) {
                	newobjectstr = newobjectstr + "&#34;";
                    }
                    else if (String.valueOf(objectstr.charAt(count)).equals("'")) {
                	newobjectstr = newobjectstr + "&#39;";
                    }
                    // E20090629 Jeff
                    else if (String.valueOf(objectstr.charAt(count)).equals("\\"))
                        newobjectstr = newobjectstr + "\\"+"\\";
/*                     else if (objectstr.charAt(count)=='\r')
                    	newobjectstr = newobjectstr + " ";
                    else if (objectstr.charAt(count)=='\n') {
                    	newobjectstr = newobjectstr + " ";
                    	lineBreakCounter++;
                    	if (lineBreakCounter>=addressLineBreakCounter) {
                    		//Log.debug("DisplaySpecialChar = Break Loop!!!");
                    		//break;
                    	}
                    }
*/
//                    else if (String.valueOf(objectstr.charAt(count)).equals(")"))
//                        newobjectstr = newobjectstr + "&#8250;";
                    else
                        newobjectstr = newobjectstr + String.valueOf(objectstr.charAt(count));
                }
            }
        }



//       newobjectstr = newobjectstr.replace('\n','|');
       //objectstr = objectstr.replaceAll("|", "\\n");

        return newobjectstr;
    }//end DisplaySpecialChar
    
    public static double setDecPlace(double d, double decPlace) {
        double p = Math.pow(10, decPlace);
        if (d == 0) {
            return 0;
        } else {
            return Math.rint(d * p) / p;
        }
    }

    public static String getToday() {
        Calendar now = Calendar.getInstance();
        return fd(new java.util.Date(now.getTime().getTime()));
    }

    public static String getTodayPlusDays(int days) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, days);
        return fd(new java.util.Date(now.getTime().getTime()));
    }

    /**
     * given timestamp object and return string format of YYMM
     * <p/>
     * <p/>
     *
     * @param ts - Timestamp
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String getDateYYMM(java.sql.Timestamp ts) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate = ts.toString().substring(2, 4) + ts.toString().substring(5, 7);
        }
        return oracleDate;
    }

    /**
     * given String object and return string with adding insertvalue
     * <p/>
     * <p/>
     *
     * @param origin_str      - Orgin String
     * @param insertvalue     - the value that to be added
     * @param posRange        - the position of Orgin String that want to add insertvalue
     * @param noofinsertvalue - time of insertvalue want to add
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String insertStrValue(String origin_str, String insertvalue, int posRange, int noofinsertvalue) {
        String returnStr = "";
        String addvalue = "";
        if (origin_str == null)
            origin_str = "";
          //  returnStr init 
        returnStr = origin_str; 
            
        for (int i = 0; i < noofinsertvalue; i++) {
            addvalue = addvalue + insertvalue;
        }
        if (posRange == 0) {
            returnStr = addvalue + returnStr;
        } else if (posRange >= origin_str.length()) {
            //add the string to right side of orgin_str;
            returnStr = returnStr + addvalue;
        } else {
            returnStr = origin_str.substring(0, posRange) + addvalue + origin_str.substring(posRange, origin_str.length());          
        }
          //System.out.println("*******************  returnStr5 = "+returnStr);
        return returnStr; 
    }

    public static String insertStrValue(int origin_int, String insertvalue, int posRange, int noofinsertvalue) {

        return insertStrValue(String.valueOf(origin_int), insertvalue, posRange, noofinsertvalue);
    }

    public static String insertStrValue(double origin_double, String insertvalue, int posRange, int noofinsertvalue) {

        return insertStrValue(String.valueOf(origin_double), insertvalue, posRange, noofinsertvalue);
    }

    public static String insertStrValue(float origin_float, String insertvalue, int posRange, int noofinsertvalue) {

        return insertStrValue(String.valueOf(origin_float), insertvalue, posRange, noofinsertvalue);
    }


    public static Vector sf_cut_string(String origin_str, String sepstrs, String keepsepstr, int maxCharofField, int noofField) {
        Vector vectorOfString = new Vector();
        int lastIndex = -1;
        int FinalLastIndex = -1;
        String sepstr = "";
        String origin_new_str = "";
        String origin_remain_str = "";
        int beginindex = 0;
//        int endindex = 0;
        //add by wuxl replace all "enter" ("\r\n")
        //origin_str = origin_str.replaceAll("~r~n", " "); 
        origin_str = origin_str.replaceAll("\r\n", " ");
        origin_str = origin_str.replaceAll("~r~n", " ");  
        origin_str = origin_str.replaceAll("\n", " "); 
        origin_str = origin_str.replaceAll("\r", " ");   
        //System.out.println("-----------------------origin_str = "+origin_str);
        if (sepstrs != null) {
//origin_new_str=origin_str.substring(beginindex,endindex);
            origin_new_str = origin_str;
            origin_remain_str = origin_str;
            
            for (int i = 0; i < noofField; i++) {
                if (origin_new_str.length() >= maxCharofField) {
//        origin_remain_str=origin_new_str.substring(maxCharofField,origin_new_str.length());
                    origin_new_str = origin_new_str.substring(beginindex, maxCharofField);
                    FinalLastIndex = -1;
                    for (int k = 0; k < sepstrs.length(); k++) {
                        sepstr = sepstrs.substring(k, sepstrs.length());
                        lastIndex = origin_new_str.lastIndexOf(sepstr);
                        if (lastIndex > FinalLastIndex)
                            FinalLastIndex = lastIndex;
                    }
                    if (FinalLastIndex == -1) {
                        FinalLastIndex = origin_new_str.length();
                    }
                    origin_remain_str = origin_remain_str.substring(FinalLastIndex);
                    origin_new_str = origin_new_str.substring(beginindex, FinalLastIndex);
                } else if (origin_new_str.length() == 0) {
                    origin_new_str = "";
                    origin_remain_str = "";
                } else {
//        origin_remain_str=origin_new_str.substring(maxCharofField,origin_new_str.length());
                    origin_new_str = origin_new_str.substring(beginindex, origin_new_str.length());
                    origin_remain_str = "";
                }
                
                vectorOfString.add(insertStrValue(origin_new_str, " ", origin_new_str.length(), maxCharofField - origin_new_str.length()));
                origin_new_str = origin_remain_str;
                
            }

        }

        return vectorOfString;
    }
    /**
     * given Timestamp and String object and return string of oracle SQL TO_DATE string
     * <p/>
     * <p/>
     *
     * @param ts               - Timestamp
     * @param stringDateFormat - String
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */

    public static String TStoOracleDateTimeSQL(java.sql.Timestamp ts, String stringDateFormat) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate = toOracleDateSQL(TStoDateTimeString(ts), stringDateFormat);
        }
        return oracleDate;
    }
   /**
     * given timestamp object and return string format of yyyy-mm-dd
     * <p/>
     * <p/>
     *
     * @param ts - Timestamp
     * @return String
     *         author 	Vincent Yuen
     *         version 	%I%, %G%
     */
    public static String TStoDateTimeString(java.sql.Timestamp ts) {
        String oracleDate = "";
        if (ts != null) {
            oracleDate = ts.toString().substring(0, 19);
        }
        return oracleDate;
    }
    
    /**
     * Date: 2008-4-15
     * Author: robert
     * Date: 2008-4-15
     * return boolean
     */
    public static boolean isEmptyStr(String s) { 
        return s == null || "".equalsIgnoreCase(s.trim()) || "null".equalsIgnoreCase(s);
    }
    
    /**
      *
      * this function get the input string , check for
      * character ' and change ' to '' and return as a new string
      * This is under the consideration of SQL statement.
      *
      * <p>
      * @param     objectstr - String
      * @return    string --- converted string
     */
   //---------------------------this function change ' to '' ---------------------------------------------------------------------

   public static String CheckSpecialChar ( String objectstr) {
      int count=0;
      String newobjectstr = "";
      if(objectstr==null || objectstr.equals(""))
      {
          return "";
      }
      else
      {
         int orgSize = objectstr.length();
//         Debug.println("before colon check: " + objectstr);
            for(count=0;count<orgSize;count++){
                  if(String.valueOf(objectstr.charAt(count)).equals("'"))
                      newobjectstr = newobjectstr + "''";
                  else
                      newobjectstr = newobjectstr + String.valueOf(objectstr.charAt(count));
            }
//            Debug.println("after colon check: " + newobjectstr );
      }
  return newobjectstr;
  }//end checkSingleColon
public static String unescape(String s) {
    StringBuffer sbuf = new StringBuffer () ;
    int l  = s.length() ;
    int ch = -1 ;
    int b, sumb = 0;
    for (int i = 0, more = -1 ; i < l ; i++) {
      /* Get next byte b from URL segment s */
      switch (ch = s.charAt(i)) {
		 case '%':
		   ch = s.charAt (++i) ;
		   int hb = (Character.isDigit ((char) ch)
		 		     ? ch - '0'
		 		     : 10+Character.toLowerCase((char) ch) - 'a') & 0xF ;
		   ch = s.charAt (++i) ;
		   int lb = (Character.isDigit ((char) ch)
		 		     ? ch - '0'
		 		     : 10+Character.toLowerCase ((char) ch)-'a') & 0xF ;
		   b = (hb << 4) | lb ;
		   break ;
		 case '+':
		   b = ' ' ;
		   break ;
		 default:
		   b = ch ;
      }
      /* Decode byte b as UTF-8, sumb collects incomplete chars */
      if ((b & 0xc0) == 0x80) {		 		 		 // 10xxxxxx (continuation byte)
		 sumb = (sumb << 6) | (b & 0x3f) ;		 // Add 6 bits to sumb
		 if (--more == 0) sbuf.append((char) sumb) ; // Add char to sbuf
      } else if ((b & 0x80) == 0x00) {		 		 // 0xxxxxxx (yields 7 bits)
		 sbuf.append((char) b) ;		 		 		 // Store in sbuf
      } else if ((b & 0xe0) == 0xc0) {		 		 // 110xxxxx (yields 5 bits)
		 sumb = b & 0x1f;
		 more = 1;		 		 		 		 // Expect 1 more byte
      } else if ((b & 0xf0) == 0xe0) {		 		 // 1110xxxx (yields 4 bits)
		 sumb = b & 0x0f;
		 more = 2;		 		 		 		 // Expect 2 more bytes
      } else if ((b & 0xf8) == 0xf0) {		 		 // 11110xxx (yields 3 bits)
		 sumb = b & 0x07;
		 more = 3;		 		 		 		 // Expect 3 more bytes
      } else if ((b & 0xfc) == 0xf8) {		 		 // 111110xx (yields 2 bits)
		 sumb = b & 0x03;
		 more = 4;		 		 		 		 // Expect 4 more bytes
      } else /*if ((b & 0xfe) == 0xfc)*/ {		 // 1111110x (yields 1 bit)
		 sumb = b & 0x01;
		 more = 5;		 		 		 		 // Expect 5 more bytes
      }
      /* We don't test if the UTF-8 encoding is well-formed */
    }
    return sbuf.toString() ;
  }

    /**
     * Combine two lists (l1 -> l2) and return a new list, compare the item using List.contains(), so implement equals()
     * @param l1
     * @param l2
     * @return Combined list
     */
    public static List combineList(List l1, List l2) {
        List resultList = new ArrayList();
        if (l1 != null && l2 != null) {
            resultList.addAll(l1);
            for (int i = 0; i < l2.size(); i++) {
                Object o = l2.get(i);
                if (!resultList.contains(o)) {
                    resultList.add(o);
                }
            }
        } else if (l1 != null && l2 == null) {
            resultList.addAll(l1);
        } else if (l1 == null && l2 != null) {
            resultList.addAll(l2);
        }
        return resultList;
    }

    public static boolean isEmpty(String s) {
        return s == null && "".equalsIgnoreCase(s.trim());
    }

    public static boolean isNotEmpty(String s) {
        return s != null && !"".equalsIgnoreCase(s.trim());
    }

    public static String getNumberPattern(int decimalPlace) {
        StringBuffer patternBuffer = new StringBuffer();
        patternBuffer.append("###");
        if (decimalPlace > 0) {
          patternBuffer.append(".");
        }
        for (int j = 0; j < decimalPlace; j++) {
          patternBuffer.append("0");
        }
        return patternBuffer.toString();
    }

    public static void main(String[] args) {
        List l1 = new ArrayList();
        List l2 = new ArrayList();
        l1.add("A");
        l1.add("B");
        l1.add("C");
        l1.add("D");
        l2.add("E");
        l2.add("B");
        List l3 = combineList(l2, l1);
        for (int i = 0; i < l3.size(); i++) {
            String s = (String) l3.get(i);
            System.out.println("s = " + s);
        }
    }
}