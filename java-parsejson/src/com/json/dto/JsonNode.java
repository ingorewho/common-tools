/**
 * 
 */
package com.json.dto;

import java.util.Iterator;

import com.json.iterator.NullIterator;

/**
 * @author ignore1992
 * 定义json叶子节点
 * 2018年9月15日
 */
public class JsonNode extends JsonComponent
{
	private String name;
	private String value;
	
	public JsonNode(String name, String value)
	{
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public String getValue()
	{
		return value;
	}
	
	@Override
	public Iterator<JsonComponent> createIterator()
	{
		return new NullIterator();
	}
	
	@Override
	public String toJsonString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("\"" + name + "\"");
		builder.append(":");
		builder.append("\"" + value + "\"");
		
		return builder.toString();
	}
	
	@Override
	public String toJsonString1()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("\"" + name + "\"");
		builder.append(":");
		builder.append("\"" + value + "\"");
		
		return builder.toString();
	}
}
