/**
 * 
 */
package com.json.service;

/**
 * @author ignore1992
 *
 * 2018年9月15日
 */
public interface JsonService<T>
{
	/**
	 * 对象转json
	 * @param item 对象
	 * @return json串
	 */
	public String transfer2Json(T item);
	
	/**
	 * json转对象
	 * @param json json串
	 * @return 对象
	 */
	public T transfer2Object(String json);
}
