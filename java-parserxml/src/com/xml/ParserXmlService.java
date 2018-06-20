/**
 * 
 */
package com.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * @author ignore1992
 *
 */
public final class ParserXmlService
{
	public  static void readConf(String filePath)
	{
		System.out.println(String.format("配置文件路径:%s", filePath));
		SAXBuilder saxBuilder = new SAXBuilder();
		
		File file = new File(filePath);
		
		if(file.exists())
		{
			FileInputStream is = null;
			try
			{
				is = new FileInputStream(file);
				Document doc = saxBuilder.build(is);
				//读取根节点
				Element root = doc.getRootElement();
				//读取节点元素
				Element node1 = root.getChild("node1");
				//读取节点中的属性值
				String node1Value = node1.getAttributeValue("enable");
				
				System.out.println(String.format("节点:%s,属性:%s,值为:%s", "node1", "enable", node1Value));
				
				//....
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
