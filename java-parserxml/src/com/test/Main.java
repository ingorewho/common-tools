/**
 * 
 */
package com.test;

import java.io.File;

import com.xml.ParserXmlService;

/**
 * @author ignore1992
 *
 */
public class Main
{
	public static void main(String[] args)
	{
		String filePath = new File(Main.class.getResource("").getPath()).getParent() + File.separator +"conf" + File.separator + "systemConf.xml";
		
		ParserXmlService.readConf(filePath);
	}
}
