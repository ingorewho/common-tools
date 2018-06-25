/**
 * 
 */
package com.httpclient.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

/**
 * @author ignore1992
 *
 * 2018-6-25
 */
public class HttpClientGet
{
	public static String send(String url, Map<String, String> params)
	{
		System.out.println(String.format("httpget url:%s 参数:%s", url, params));
		String result = "";
		HttpClient client = new DefaultHttpClient();
		
		Iterator<Entry<String, String>> iter = params.entrySet().iterator();
		String param = "";
		while(iter.hasNext())
		{
			Entry<String, String> entry = iter.next();
			if(iter.hasNext())
			{
				param += String.format("%s=%s&", entry.getKey(), entry.getValue());
			}
			else
			{
				param += String.format("%s=%s", entry.getKey(), entry.getValue());
			}
		}
		String newUrl = url + "?" + param;
		
		HttpGet request = new HttpGet(newUrl);
		//设置请求编码
		request.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
		//设置服务端返回json格式，编码为UTF-8
		request.setHeader(new BasicHeader("Accept", "application/json;charset=utf-8"));
		try
		{
			HttpResponse response = client.execute(request);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				//读取json结果
				result = EntityUtils.toString(response.getEntity());
				System.out.println(String.format("httpClient get请求响应结果:%s", result));
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
