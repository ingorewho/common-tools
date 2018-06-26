/**
 * 
 */
package com.object.service;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ignore1992
 *
 * 2018-6-26
 */
public class ObjectSizeService
{
	/**
	 * 声明Instrumentation实例
	 */
	static Instrumentation instrument;
	
	public static void premain(String args, Instrumentation inst)
	{
		//通过premain函数给Instrumentation实例赋值
		instrument = inst;
	}
	
	/**
	 * 第一种方法：
	 * 计算当前对象占用空间大小，包括:当前类及超类基本类型实例大小、引用类型引用大小、基本类型数组占用空间大小、引用类型数组引用本身大小
	 * 					不包括：当前类及超类继承下来的引用对象大小、引用类型数组对象大小
	 * @param obj .
	 * @return .
	 */
	public static long sizeOf(Object obj)
	{
		return instrument.getObjectSize(obj);
	}
		
	/**
	 * 第二种方法：
	 * 计算当前对象占用空间的总大小，包括：当前类及超类基本类型实例大小、引用类型引用大小、基本类型数组占用空间大小、引用类型数组引用本身大小、当前类及超类继承下来的引用对象大小、引用类型数组对象大小
	 * @param obj .
	 * @return .
	 * @throws Exception .
	 */
	public static long fullSizeOf(Object obj)
	{
		long size = 0;
		Set<Object> visited = new HashSet<Object>();
		Deque<Object> queue = new ArrayDeque<Object>();
		queue.add(obj);
		while(queue.size() > 0)
		{
			Object tmpObj = queue.poll();
			//已经计算的过的不做计算
			size += visited.contains(tmpObj) ? 0 : sizeOf(tmpObj);
			Class<?> tmpClass = tmpObj.getClass();
			//数组需要进行遍历
			if(tmpClass.isArray())
			{
				//判断是否是非基本类型，基本类型类名称长度为2，非基本类型长度名称大于2
				if(tmpClass.getName().length() > 2)
				{
					//获取数组长度
					int length = Array.getLength(tmpObj);
					for(int i = 0; i < length; i++)
					{
						//获取数组元素
						Object tmp = Array.get(obj, i);
						if(tmp != null)
						{
							//因为非基本类型元素对象未做计算，要添加到队列中，做递归计算
							queue.add(tmp);
						}
					}
				}
			}
			else
			{
				while(tmpClass != null)
				{
					Field[] fields = tmpClass.getDeclaredFields();
					for(Field field : fields)
					{
						//判断修饰符是否是静态类型(静态类型变量属于类属性) 判断是否是基本类型(已经做了计算)
						if(Modifier.isStatic(field.getModifiers()) || field.getType().isPrimitive())
						{
							continue;
						}
						
						field.setAccessible(true);
						Object fieldValue = null;
						try
						{
							fieldValue = field.get(tmpObj);
						} 
						catch (Exception e)
						{
							System.out.println(e.getMessage());
						}
						
						if(fieldValue != null)
						{
							//非基本类型值放到队列中进行计算
							queue.add(fieldValue);
						}
					}
					//获取超类
					tmpClass = tmpClass.getSuperclass();
				}
			}
		}
		return size;
	}
}
