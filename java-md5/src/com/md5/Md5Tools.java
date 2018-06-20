/**
 * 
 */
package com.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ignore1992
 *
 * 2018-6-20
 */
public final class Md5Tools
{
	/**信息摘要器.*/
	private static MessageDigest digest;
	
	static
	{
		try
		{
			digest =  MessageDigest.getInstance("md5");
		} 
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param aText
	 * @return
	 */
	public static String md5(String aText)
	{
		digest.update(aText.getBytes());
		
		//加密结果集中元素是128位的长整数
		byte[] tmpArray = digest.digest();
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < tmpArray.length; i++)
		{
			int tmpE = tmpArray[i];
			
			if(tmpE < 0)
			{
				tmpE = 256 + tmpE;
			}
			
			if(tmpE < 16)
			{
				builder.append("0");
			}
			
			builder.append(Integer.toHexString(tmpE));
		}
		
		return builder.toString();
	}

	/**
	 * 
	 * @param aBytes
	 * @return
	 */
	public static String md5(byte[] aBytes)
	{
		String s = null;
		
		//用于将字节转换成16进制字符
		char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		
		try
		{
			digest.update(aBytes);
			
			//加密结果集中元素是128位的长整数
			byte[] tmpArray = digest.digest();
			
			//每个字节用16进制表示，使用两个字符，所以表示成16进制需要32个字符
			char[] str = new char[16 * 2];
			
			//表示转换结果中对应字符位置
			int k = 0;
			
			for(int i = 0; i < 16; i++)
			{
				//从第一个字节开始，对md5的每个字节转换成16进制字符
				byte tmpByte = tmpArray[i];
				//取字节中高4位的数字转换
				str[k++] = hexDigits[tmpByte >>> 4 & 0xf];
				//取字节中低4位的数字转换
				str[k++] = hexDigits[tmpByte & 0xf];
			}
			
			s = new String(str);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return s;
	}
}
