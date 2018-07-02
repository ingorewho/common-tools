/**
 * 
 */
package com.image.test;

import java.io.File;

import com.image.service.ImageService;

/**
 * @author ignore1992
 *
 * 2018年7月2日
 */
public class Main
{
	public static void main(String[] args)
	{
		String filePath = "D://test.jpg";
		File file = new File(filePath);
		
		try
		{
			ImageService.readImageInfo(file);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
