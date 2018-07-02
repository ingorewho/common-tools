/**
 * 
 */
package com.image.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

/**
 * @author ignore1992
 *
 *        2018年7月2日
 */
public class ImageService
{
	/**
	 * 读取图片信息
	 */
	public static void readImageInfo(File file)throws Exception
	{
		Metadata metadata = ImageMetadataReader.readMetadata(file);
		
		Map<String, String> imageMap = new HashMap<String, String>();
		for (Directory directory : metadata.getDirectories())
		{
			for (Tag tag : directory.getTags())
			{
				//标签名称
				String tagName = tag.getTagName(); 
				//标签描述
				String desc = tag.getDescription(); 
				//读取源信息
				System.out.println(String.format("%s  %s", tagName, desc));
				imageMap.put(tagName, desc);
			}
		}
		
		//读取拍摄手机信息
		System.out.println(String.format("拍摄手机：手机类型=%s, 手机型号=%s", imageMap.get("Make"), imageMap.get("Model")));
		//读取经纬度信息
		System.out.println(String.format("拍摄地点：经度=%s, 纬度=%s", imageMap.get("GPS Latitude"), imageMap.get("GPS Longitude")));
		//读取拍摄时间
		System.out.println(String.format("拍摄时间：%s", imageMap.get("Date/Time Original")));
	}

}
