/**
 * 
 */
package com.httpclient.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * @author ignore1992
 *
 * 2018-6-25
 */
public class HttpClientPost
{
	public static String send(String url, Map<String, String> params)
	{
		System.out.println(String.format("httppost url:%s 参数:%s", url, params));
		String result = "";
		HttpClient client = new DefaultHttpClient();
		
		List<NameValuePair> tmpPairs = new ArrayList<NameValuePair>();
		
		Iterator<Entry<String, String>> iter = params.entrySet().iterator();
		while(iter.hasNext())
		{
			Entry<String, String> entry = iter.next();
			
			tmpPairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		
		HttpPost request = new HttpPost();
		try
		{
			request.setURI(new URI(url));
			//设置服务端返回json格式，编码为UTF-8
			request.setHeader("Accept", "application/json;charset=utf-8");
			request.setEntity(new UrlEncodedFormEntity(tmpPairs, HTTP.UTF_8));
			HttpResponse response = client.execute(request);
			//响应成功
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				//读取json结果
				result = EntityUtils.toString(response.getEntity());
				System.out.println(String.format("httpClient post请求响应结果:%s", result));
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
