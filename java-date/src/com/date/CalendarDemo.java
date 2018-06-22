package com.date;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author ignore1992
 *
 * 2018-6-21
 */
public class CalendarDemo
{
	public static void main(String[] args)
	{
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance(Locale.CHINA);
		Calendar c3 = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"));
		Calendar c4 = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"), Locale.US);
		
		System.out.println("日历信息:" + c1);
		System.out.println("日历信息:" + c2);
		System.out.println("日历信息:" + c3);
		System.out.println("日历信息:" + c4);
		
		compareAddSetRoll();
		compareRolls();
		compareSets();
		compareBeforeAfter();
		testSetFirstDayOfWeek();
		testSetMinimalDaysInFirstWeek();
		testSetLenient();
		testGetTime();
	}
	
	
	private static void compareAddSetRoll()
	{
		Calendar c1 = Calendar.getInstance();
		//月份会变，天数也会变
		c1.add(Calendar.DAY_OF_MONTH, 31);
		System.out.println("compareAddSetRoll当前时间:" + c1.getTime());
		
		Calendar c2 = Calendar.getInstance();
		//根据实际进行调整，如果本月没有31天，则算到下个月一号
		c2.set(Calendar.DAY_OF_MONTH, 31);
		System.out.println("compareAddSetRoll当前时间:" + c2.getTime());
		
		Calendar c3 = Calendar.getInstance();
		//月份不会变，天数会变
		c3.roll(Calendar.DAY_OF_MONTH, 31);
		System.out.println("compareAddSetRoll当前时间:" + c3.getTime());
	}
	
	private static void compareRolls()
	{
		Calendar c1 = Calendar.getInstance();
		c1.roll(Calendar.DAY_OF_MONTH, true);
		System.out.println("compareRolls当前时间:" + c1.getTime());
		c1.roll(Calendar.DAY_OF_MONTH, false);
		System.out.println("compareRolls当前时间:" + c1.getTime());
		c1.roll(Calendar.DAY_OF_YEAR, 31);
		System.out.println("compareRolls当前时间:" + c1.getTime());
		c1.roll(Calendar.DAY_OF_YEAR, -31);
		System.out.println("compareRolls当前时间:" + c1.getTime());
	}
	
	
	
	private static void compareSets()
	{
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println("compareSets当前时间:" + c1.getTime());
		c1.set(2018, 1, 1);
		System.out.println("compareSets当前时间:" + c1.getTime());
		c1.set(2018, 1, 1, 1, 1);
		System.out.println("compareSets当前时间:" + c1.getTime());
		c1.set(2018, 1, 1, 1, 1, 1);
		System.out.println("compareSets当前时间:" + c1.getTime());
	}
	
	private static void compareBeforeAfter()
	{
		//当前是2018年
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2017);
		System.out.println("当前时间比2017年较早:" + c.before(c1));
		System.out.println("当前时间比2017年较晚:" + c.after(c1));
	}
	
	
	private static void testSetFirstDayOfWeek()
	{
		Calendar c1 = Calendar.getInstance();
		System.out.println("一周的第一天是:" + c1.getFirstDayOfWeek());
		c1.setFirstDayOfWeek(Calendar.MONDAY);
		System.out.println("一周的第一天是:" + c1.getFirstDayOfWeek());
	}
	
	
	private static void testSetMinimalDaysInFirstWeek()
	{
		Calendar c1 = Calendar.getInstance();
		c1.setMinimalDaysInFirstWeek(5);
		System.out.println("本月有多少周:" + c1.get(Calendar.WEEK_OF_MONTH));
		c1.setMinimalDaysInFirstWeek(2);
		System.out.println("本月有多少周:" + c1.get(Calendar.WEEK_OF_MONTH));
	}
	
	private static void testSetLenient()
	{
		Calendar c1 = Calendar.getInstance();
		c1.setLenient(true);
		c1.set(Calendar.DAY_OF_MONTH, 32);
		System.out.println("testSetLenient当前时间:" + c1.getTime());
		c1.setLenient(false);
		c1.set(Calendar.DAY_OF_MONTH, 32);
		System.out.println("testSetLenient当前时间:" + c1.getTime());
	}
	
	private static void testGetTime()
	{
		Calendar c1 = Calendar.getInstance();
		c1.setTimeZone(TimeZone.getTimeZone("GMT-8"));
		System.out.println("当前时间：" + c1.getTime());
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-8"));
		System.out.println("当前时间：" + c1.getTime());
	}
}
