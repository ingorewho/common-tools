/**
 * 
 */
package com.test;

import com.md5.Md5Tools;

/**
 * @author ignore1992
 *
 * 2018-6-20
 */
public class Main
{
	public static void main(String[] args)
	{
		String testStr1 = "AAABBBCCC";
		System.out.println(Md5Tools.md5(testStr1));
		System.out.println(Md5Tools.md5(testStr1.getBytes()));
		String testStr2 = "aaabbbccc";
		System.out.println(Md5Tools.md5(testStr2));
		System.out.println(Md5Tools.md5(testStr2.getBytes()));
	}
}
