/**
 * 
 */
package com.json.controller;

import com.json.dto.JsonComponent;
import com.json.dto.JsonLeaf;
import com.json.dto.JsonNode;
import com.json.service.JsonService;
import com.json.service.impl.JsonServiceImpl;

/**
 * @author ignore1992
 *
 * 2018年9月15日
 */
public class JsonController
{
	public static JsonService<JsonComponent> jsonService = new JsonServiceImpl();
	
	public static void main(String[] args)
	{
		testTrans2Json();
	}
	
	public static void testTrans2Json()
	{
		JsonComponent mainItem = new JsonLeaf("主节点");
		JsonComponent leafItem1 = new JsonLeaf("次节点1");
		JsonComponent leafItem2 = new JsonLeaf("次节点2");
		JsonComponent nodeItem1 = new JsonNode("叶子节点1", "叶子节点1value");
		JsonComponent nodeItem2 = new JsonNode("叶子节点2", "叶子节点2value");
		leafItem1.add(nodeItem1);
		leafItem2.add(nodeItem2);
		mainItem.add(leafItem1);
		mainItem.add(leafItem2);
		//采用内部迭代方式
		System.out.println(jsonService.transfer2Json(mainItem));
	}
}
