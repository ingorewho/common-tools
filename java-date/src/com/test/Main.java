/**
 * 
 */
package com.test;

import com.date.DateTools;

/**
 * @author ignore1992
 *
 * 2018-6-22
 */
public class Main
{
	public static void main(String[] args)
	{
		//1.测试时间格式化
		System.out.println(DateTools.formatTimeMills(System.currentTimeMillis()));
		//2.测试获取所给秒数，除去时分秒毫秒后的long值
		System.out.println(DateTools.computeFirstMillForDay(System.currentTimeMillis()));
		//3.测试获取所给秒数，向前推多少天前凌晨零秒的时间戳
		System.out.println(DateTools.computeFirstMillForLastDay(System.currentTimeMillis(), 10));
		//4.测试获取所给秒数，所在周最后一天凌晨零秒的时间戳
		System.out.println(DateTools.computeLastDayFirstMillForWeek(System.currentTimeMillis()));
		//5.测试获取所给秒数，向前推几周之后所在周的最后一天凌晨零秒的时间戳
		System.out.println(DateTools.computeLastDayFirstMillForLastWeek(System.currentTimeMillis(), 10));
		//6.测试获取所给秒数，所在月最后一天凌晨零秒的时间戳
		System.out.println(DateTools.computeLastDayFirstMillForMonth(System.currentTimeMillis()));
		//7.测试获取所给秒数，向前推几月之后所在月的最后一天凌晨零秒的时间戳
		System.out.println(DateTools.computeLastDayFirstMillForLastMonth(System.currentTimeMillis(), 10));
	}
}
