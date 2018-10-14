/**
 * 
 */
package com.json.dto;

import java.util.Iterator;
import java.util.List;


/**
 * @author ignore1992
 * 定义json抽象组件
 * 2018年9月15日
 */
public abstract class JsonComponent
{
	public String getName()
	{
		throw new UnsupportedOperationException();
	}
	
	
	public String getValue()
	{
		throw new UnsupportedOperationException();
	}
	
	public void print()
	{
		throw new UnsupportedOperationException();
	}
	
	public void add(JsonComponent component)
	{
		throw new UnsupportedOperationException();
	}
	
	public void remove(JsonComponent component)
	{
		throw new UnsupportedOperationException();
	}
	
	public List<JsonComponent> getComponentList()
	{
		throw new UnsupportedOperationException();
	}
	
	public Iterator<JsonComponent> createIterator()
	{
		throw new UnsupportedOperationException();
	}
	
	public String toJsonString()
	{
		throw new UnsupportedOperationException();
	}
	
	public String toJsonString1()
	{
		throw new UnsupportedOperationException();
	}
}
