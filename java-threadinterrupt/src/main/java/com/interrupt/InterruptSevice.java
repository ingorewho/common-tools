/**
 * 
 */
package com.interrupt;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author ignore1992
 *
 * 2018-7-6
 */
public class InterruptSevice
{
	/**
	 * 验证interrupt()方法
	 */
	public static void interrupt()
	{
		//interrupt方法是设置当前线程的中断状态为true，具体线程的中断处理在方便的时候执行
		Thread.currentThread().interrupt();
		try
		{
			//线程进入阻塞状态，这时就是方便处理中断的时候
			TimeUnit.SECONDS.sleep(10);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 验证isInterrupted()方法
	 */
	public static void isInterrupted()
	{
		Thread.currentThread().interrupt();
		System.out.println(String.format("首次调用interrupt方法，返回:%s", Thread.currentThread().isInterrupted()));
		System.out.println(String.format("再次调用interrupt方法，返回:%s", Thread.currentThread().isInterrupted()));
	}
	
	/**
	 * 验证interrupt()方法
	 */
	public static void interrupted()
	{
		Thread.currentThread().interrupt();
		System.out.println(String.format("首次调用interrupted方法，返回:%s", Thread.interrupted()));
		System.out.println(String.format("再次调用interrupted方法，返回:%s", Thread.interrupted()));
	}
	
	
	/**
	 * 吞掉中断异常，其他接收者无法再次中断
	 */
	public static void swallowInterrupt()
	{
		Thread.currentThread().interrupt();
		try
		{
			System.out.println("休眠1秒!");
			TimeUnit.SECONDS.sleep(1);
		} 
		catch (InterruptedException e)
		{
			System.out.println("线程中断!");
			System.out.println("吞掉异常!");
		}
		
		try
		{
			System.out.println("休眠2秒!");
			TimeUnit.SECONDS.sleep(2);
		} 
		catch (InterruptedException e)
		{
			System.out.println("线程再次中断!");
		}
	}
	
	/**
	 * 利用中断判断方法实现快速响应
	 */
	public static void fastResponse()
	{
		while(true)
		{
			if(Thread.currentThread().isInterrupted())
			{
				System.out.println("当前中断状态为true，跳出循环!");
				break;
			}
		}
	}
	
	/**
	 * 利用中断方法实现任务的不可取消
	 * @param queue .
	 * @return .
	 */
	public static String getTask(BlockingQueue<String> queue)
	{
		boolean isIntterrupted = false;
		try
		{
			while(true)
			{
				try
				{
					return queue.take();
				}
				catch (InterruptedException e)
				{
					isIntterrupted = true;
				}
			}
		}
		finally
		{
			if(isIntterrupted)
			{
				Thread.currentThread().interrupt();
			}
		}
	}
}
