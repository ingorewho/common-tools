/**
 * 
 */
package com.json.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.json.iterator.JsonComponentIterator;

/**
 * @author ignore1992
 * 定义json叶子
 * 2018年9月15日
 */
public class JsonLeaf extends JsonComponent
{
	private String name;
	
	private List<JsonComponent> components = new ArrayList<>();
	
	public JsonLeaf(String name)
	{
		this.name = name;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public void add(JsonComponent component)
	{
		components.add(component);
	}
	
	@Override
	public void remove(JsonComponent component)
	{
		components.remove(component);
	}
	
	@Override
	public List<JsonComponent> getComponentList()
	{
		return components;
	}
	
	@Override
	public Iterator<JsonComponent> createIterator()
	{
		return new JsonComponentIterator(components.iterator());
	}
	
	@Override
	public String toJsonString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("\"" + name + "\"");
		builder.append(":");
		builder.append("{");
		
 		Iterator<JsonComponent> iterator = components.iterator();
		while(iterator.hasNext())
		{
			JsonComponent component = iterator.next();
			builder.append(component.toJsonString());
			if(iterator.hasNext())
			{
				builder.append(",");
			}
		}
		builder.append("}");
		return builder.toString();
	}
	
	@Override
	public String toJsonString1()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("\"" + name + "\"");
		builder.append(":");
		
		return builder.toString();
	}
}
