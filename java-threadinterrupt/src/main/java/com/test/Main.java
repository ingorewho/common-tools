/**
 * 
 */
package com.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import com.interrupt.InterruptSevice;

/**
 * @author ignore1992
 *
 * 2018-7-6
 */
public class Main
{
	public static void main(String[] args)
	{
		InterruptSevice.interrupt();
		InterruptSevice.isInterrupted();
		InterruptSevice.interrupted();
		
		InterruptSevice.swallowInterrupt();

		BlockingQueue<String> queue = new LinkedBlockingDeque<String>();
		InterruptSevice.getTask(queue);
		InterruptSevice.fastResponse();
	}
}
