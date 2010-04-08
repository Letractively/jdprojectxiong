package com.ejd.utils;
import java.sql.Timestamp;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateTimeUtil {
	public final static String SECOND_UNIT = "S";
    public final static String MINUTE_UNIT = "M";
    public final static String HOUR_UNIT = "H";
    public final static String DAY_UNIT = "D";
    public final static long ONE_SECOND = 1000;
    public final static long ONE_MINUTE = ONE_SECOND*60;
    public final static long ONE_HOUR = ONE_MINUTE*60;
    public final static long ONE_DAY = ONE_HOUR*24;
    public final static String TIME_DELIMETER = ":";
    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
    public final static SimpleDateFormat m_simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);


    public static Timestamp getCurrentTimestamp()
    {
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }

    public static Timestamp getTimestampAfterTimeMillis(long timeMillis)
    {
         long currentTime = System.currentTimeMillis();
          return new Timestamp(currentTime+timeMillis);
    }

    public static Timestamp getTimestampBeforeTimeMillis(long timeMillis)
    {
         long currentTime = System.currentTimeMillis();
         long beforeTime = currentTime-timeMillis;
         if(beforeTime<0)
         {
            beforeTime = 0;
         }
         return new Timestamp(beforeTime);
    }

    public static long convertToTimeMillis(String strDuration,String timeUnit)
    {
        long duration = 0;
        try{
             duration = Long.parseLong(strDuration);
        }
        catch(Exception e)
        {
            duration = 0;
        }

        return convertToTimeMillis(duration,timeUnit);
    }
    public static long convertToTimeMillis(long duration,String timeUnit)
    {
          long timeMills = 0;
          if(SECOND_UNIT.equals(timeUnit))
          {
              timeMills = duration*ONE_SECOND;
          }
          else if(MINUTE_UNIT.equals(timeUnit))
          {
              timeMills = duration*ONE_MINUTE;
          }
          else if(HOUR_UNIT.equals(timeUnit))
          {
              timeMills = duration*ONE_HOUR;
          }
          else if(DAY_UNIT.equals(timeUnit))
          {
              timeMills = duration*ONE_DAY;
          }
          return timeMills;
    }

    public static long convertToTimeMillis(float duration,String timeUnit)
    {
          long timeMills = 0;
          if(SECOND_UNIT.equals(timeUnit))
          {
              timeMills = (long)(duration*ONE_SECOND);
          }
          else if(MINUTE_UNIT.equals(timeUnit))
          {
              timeMills = (long)(duration*ONE_MINUTE);
          }
          else if(HOUR_UNIT.equals(timeUnit))
          {
              timeMills = (long)(duration*ONE_HOUR);
          }
          else if(DAY_UNIT.equals(timeUnit))
          {
              timeMills = (long)(duration*ONE_DAY);
          }
          return timeMills;
    }

    public static Date parseDate(String dateString)
    {
         Date date = null;
         try{
            if(StringUtils.isNotEmpty(dateString))
            {
                date =  m_simpleDateFormat.parse(dateString);
            }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        return date;
    }

    public static String formatDate(Date date)
    {
          String formatString = "";
          if(date!=null)
          {
                formatString =  m_simpleDateFormat.format(date);
          }
          return formatString;
    }

    public static long getDuration(Date date)
    {
        long duration = date.getTime() - System.currentTimeMillis();
        return duration>=0?duration:1;
    }

    public static Timestamp convertToTimestamp(Date date)
    {
        return new Timestamp(date.getTime());
    }

    public static long getTimeMillisBeforeTime(String time)
    {
          long timeMillis = 0;
          try{
              StringTokenizer st = new StringTokenizer(time,TIME_DELIMETER);
              int hour = Integer.parseInt(st.nextToken());
              int minute = Integer.parseInt(st.nextToken());
              int second = Integer.parseInt(st.nextToken());
              hour = hour>0?hour % 24:0;
              minute = minute>0?minute % 60:0;
              second = second>0?second % 60:0;
              long targetTime = hour*ONE_HOUR+minute*ONE_MINUTE+second*ONE_SECOND;
              long currentTime = System.currentTimeMillis()+8*ONE_HOUR;
              currentTime = currentTime % ONE_DAY;
              timeMillis=targetTime-currentTime;
              if(timeMillis<0)
              {
                  timeMillis = timeMillis + ONE_DAY;
              }

          }
          catch(Exception e)
          {

          }
          return timeMillis;
    }

    public static String formatDateTime(String value,String format) throws Exception{
        SimpleDateFormat ft=new SimpleDateFormat(format);
        Date date=ft.parse(value);
        Calendar cal=new GregorianCalendar();
        cal.setTime(date);
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int minute=cal.get(Calendar.MINUTE);
        int second=cal.get(Calendar.SECOND);
        int milisecond=cal.get(Calendar.MILLISECOND);

        return ""+year+"-"+(month<10?"0"+month:""+month)+"-"+(day<10?"0"+day:""+day)
                +" "+(hour<10?"0"+hour:""+hour)+":"+(minute<10?"0"+minute:""+minute)+":"+(second<10?"0"+second:""+second)+"."+milisecond;
    }

    public static boolean sameDay(long timeMilisOne,long timeMilisTwo){
        Calendar one=new GregorianCalendar();
        Calendar two=new GregorianCalendar();
        one.setTimeInMillis(timeMilisOne);
        two.setTimeInMillis(timeMilisTwo);
        return  (one.get(Calendar.YEAR)==two.get(Calendar.YEAR)) &&
                    (one.get(Calendar.MONTH)==two.get(Calendar.MONTH)) &&
                    (one.get(Calendar.DAY_OF_MONTH)==two.get(Calendar.DAY_OF_MONTH));
    }
    /* parse date format dd/MM/yyyy to Timestamp */
    public static Timestamp getTimestampFromDateFormat(String dateString){
    	Timestamp stamp = null;
    	try{
    		if(dateString != null && !dateString .equals("")){
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	Date date = sdf.parse(dateString);	
        	stamp = new Timestamp(date.getTime());
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return stamp;
    }

    public static Date addDays(Date d, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + amount);
        return c.getTime();
    }

    public static Date truncateTime(Date d) {
        return DateUtils.truncate(
                DateUtils.truncate(
                        DateUtils.truncate(
                                DateUtils.truncate(d, Calendar.HOUR), Calendar.MINUTE), Calendar.SECOND), Calendar.MILLISECOND);
    }

    public static Timestamp truncateTime(Timestamp t) {
        return new Timestamp(DateUtils.truncate(
                DateUtils.truncate(
                        DateUtils.truncate(
                                DateUtils.truncate((Date)t, Calendar.HOUR), Calendar.MINUTE), Calendar.SECOND), Calendar.MILLISECOND).getTime());
    }
    public static String formatDate(Date date, String format) {
		SimpleDateFormat simple = new SimpleDateFormat(format);
		return simple.format(date);
	}	
	
	public static int getCurYear() {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
	
	public static int getCurMonth() {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	public static int getCurDate() {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public static Date getDateByString(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			return formatter.parse(date);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static java.sql.Date getSqlDateByString(String dateStr) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date = formatter.parse(dateStr);
			return new java.sql.Date(date.getTime());
		} catch(Exception e) { 
			e.printStackTrace();
		}
		return null;
	}
	public static String getCurrentMonthFirstDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
        return CommonUtil.fd(calendar.getTime());        
	}

	 /**
     * Get the current month's Last date
     * <p/>
     * <p/>
     * 
     * @param null
     * @return String, format: dd/mm/yyyy 
     */
	public static String getCurrentMonthLastDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
		return CommonUtil.fd(calendar.getTime());        
	}
	
	 /**
     * Get Input month's First date
     * <p/>
     * <p/>
     * 
     * @param String, format: yyyy/mm
     * @return String, format: dd/mm/yyyy 
     */
	public static String getInputMonthFirstDate(String inputMonth){
		Calendar calendar = Calendar.getInstance();
		int year = Integer.parseInt(inputMonth.substring(0,4));
		
		int month = 0;
		if (inputMonth.substring(5,6).equals("0")) 
			month = Integer.parseInt(inputMonth.substring(6));
		else
			month = Integer.parseInt(inputMonth.substring(5));
		
		calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, (month - 1));
        calendar.set(Calendar.DATE, 1);
		return CommonUtil.fd(calendar.getTime());        
	}		

	 /**
     * Get Input month's Last date
     * <p/>
     * <p/>
     * 
     * @param String, format: yyyy/mm
     * @return String, format: dd/mm/yyyy 
     */
	public static String getInputMonthLastDate(String inputMonth){
		Calendar calendar = Calendar.getInstance();
		int year = Integer.parseInt(inputMonth.substring(0,4));
		int month = 0;
		if (inputMonth.substring(5,6).equals("0")) 
			month = Integer.parseInt(inputMonth.substring(6));
		else
			month = Integer.parseInt(inputMonth.substring(5));

		
		calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, (month -1));
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
		return CommonUtil.fd(calendar.getTime());        
	}	
	
	 /**
     * Get the current month 
     * <p/>
     * <p/>
     * 
     * @param null
     * @return String, format: yyyy/mm 
     */
	public static String getCurrentMonth(){
		Calendar calendar = Calendar.getInstance();
		StringBuffer yearAndMonth = new StringBuffer(); 
		return yearAndMonth.append(calendar.get(Calendar.YEAR)).append("/").append(CommonUtil.lz(calendar.get(Calendar.MONTH) + 1, 2)).toString();        
	}
	/**
     * Get the current month 
     * <p/>
     * <p/>
     * 
     * @param null
     * @return String, format: mm/yyyy
     */
	public static String getCurrentMonthYear(){
		Calendar calendar = Calendar.getInstance();
		StringBuffer monthYear = new StringBuffer(); 		
		return monthYear.append(CommonUtil.lz(calendar.get(Calendar.MONTH) + 1, 2)).append("/").append(calendar.get(Calendar.YEAR)).toString();        
	}
}
