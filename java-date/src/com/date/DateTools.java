/**
 * 
 */
package com.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author ignore1992
 *
 * 2018-6-21
 */
public final class DateTools
{
	/**时区:东八区.*/
	private static final TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
	
	/**日期时间格式字符串:yyyy-MM-dd HH:mm:ss.*/
	private static final String DATE_TIME_WITH_MIDLLE_LINE = "yyyy-MM-dd HH:mm:ss";
	
	static
	{
		//设置系统默认时区
		timeZone.setDefault(timeZone);
	}
	
	/**
	 * 转换为yyyy-MM-dd HH:mm:ss日期格式
	 * @param mills .
	 * @return .
	 */
	public static String formatTimeMills(long mills)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_WITH_MIDLLE_LINE);
		sdf.setTimeZone(timeZone);
		return sdf.format(mills);
	}
	
	/**
	 * 获取所给秒数，除去时分秒毫秒后的long值
	 * @param millis .
	 * @return .
	 */
	public static long computeFirstMillForDay(long millis)
	{
		Calendar c = Calendar.getInstance(timeZone);
		c.setTimeInMillis(millis);
		int year = c.get(Calendar.YEAR);
		int day = c.get(Calendar.DAY_OF_YEAR);
		c.clear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.DAY_OF_YEAR, day);
		return c.getTimeInMillis();
	}
	
	/**
	 * 获取所给秒数，向前推多少天前凌晨零秒的时间戳
	 * @param millis .
	 * @param lastDays .
	 * @return .
	 */
	public static long computeFirstMillForLastDay(long millis, int lastDays)
	{
		Calendar c = Calendar.getInstance(timeZone);
		c.setTimeInMillis(millis);
		int year = c.get(Calendar.YEAR);
		int day = c.get(Calendar.DAY_OF_YEAR);
		c.clear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.DAY_OF_YEAR, day);
		c.add(Calendar.DAY_OF_YEAR, -1 * lastDays);
		return c.getTimeInMillis();
	}
	
	/**
	 * 获取所给秒数，所在周最后一天凌晨零秒的时间戳
	 * @param millis .
	 * @return .
	 */
	public static long computeLastDayFirstMillForWeek(long millis)
	{
		Calendar c = Calendar.getInstance(timeZone);
		c.setTimeInMillis(millis);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int week = c.get(Calendar.WEEK_OF_YEAR);
		
		//判断所在周是否跨年，month==11表示一年最后一个月，week==1表示一年的第一周
		if(month == 11 && week == 1)
		{
			year++;
		}
		
		c.clear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, week);
		//取周末
		c.add(Calendar.DAY_OF_YEAR, 6);
		return c.getTimeInMillis();
	}
	
	/**
	 * 获取所给秒数，向前推几周之后所在周的最后一天凌晨零秒的时间戳
	 * @param millis
	 * @param lastWeek
	 * @return
	 */
	public static long computeLastDayFirstMillForLastWeek(long millis, int lastWeek)
	{
		Calendar c = Calendar.getInstance(timeZone);
		c.setTimeInMillis(millis);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int week = c.get(Calendar.WEEK_OF_YEAR);
		
		//判断所在周是否跨年，month==11表示一年最后一个月，week==1表示一年的第一周
		if(month == 11 && week == 1)
		{
			year++;
		}
		
		c.clear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, week);
		c.add(Calendar.WEEK_OF_YEAR, -1 * lastWeek);
		//取周末
		c.add(Calendar.DAY_OF_YEAR, 6);
		return c.getTimeInMillis();
	}
	
	/**
	 * 获取所给秒数，所在月最后一天凌晨零秒的时间戳
	 * @param millis .
	 * @return .
	 */
	public static long computeLastDayFirstMillForMonth(long millis)
	{
		Calendar c = Calendar.getInstance(timeZone);
		c.setTimeInMillis(millis);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		
		c.clear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONDAY, month);
		c.set(Calendar.DAY_OF_MONTH, 1);
		//天数变，月份不变
		c.roll(Calendar.DAY_OF_MONTH, -1);
		return c.getTimeInMillis();
	}
	
	/**
	 * 获取所给秒数，向前推几月之后所在月的最后一天凌晨零秒的时间戳
	 * @param millis .
	 * @param lastMonth .
	 * @return .
	 */
	public static long computeLastDayFirstMillForLastMonth(long millis, int lastMonth)
	{
		Calendar c = Calendar.getInstance(timeZone);
		c.setTimeInMillis(millis);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		
		c.clear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONDAY, month);
		c.add(Calendar.MONDAY, -1 * lastMonth);
		c.set(Calendar.DAY_OF_MONTH, 1);
		//天数变，月份不变
		c.roll(Calendar.DAY_OF_MONTH, -1);
		return c.getTimeInMillis();
	}
	
}
