/**
 * 
 */
package com.json.iterator;

import java.util.Iterator;
import java.util.Stack;

import com.json.dto.JsonComponent;
import com.json.dto.JsonLeaf;

/**
 * @author ignore1992
 *
 *         2018年9月15日
 */
public class JsonComponentIterator implements Iterator<JsonComponent>
{
	/** 用栈结构来存储迭代器元素. */
	private Stack<Iterator<JsonComponent>> stack = new Stack<Iterator<JsonComponent>>();

	public JsonComponentIterator(Iterator<JsonComponent> iterator)
	{
		stack.push(iterator);
	}

	@Override
	public boolean hasNext()
	{
		if (!stack.isEmpty())
		{
			Iterator<JsonComponent> iterator = stack.peek();
			if (!iterator.hasNext())
			{
				// 没有元素，说明无法再从该迭代器取元素了，直接出栈
				stack.pop();
				return hasNext();
			}

			return true;
		} else
		{
			return false;
		}
	}

	@Override
	public JsonComponent next()
	{
		Iterator<JsonComponent> iterator = stack.peek();
		JsonComponent item = iterator.next();
		// 判断当前peek出的迭代器元素是否是叶子元素
		if (item instanceof JsonLeaf)
		{
			// 如果是，则压栈
			// 书上写的组合模式是item.createIterator()，但是存在一些问题，会导致叶子节点重复的问题
			stack.push(item.getComponentList().iterator());
		}
		
		return item;
	}
}
