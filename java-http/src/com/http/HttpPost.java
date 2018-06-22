/**
 * 
 */
package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ignore1992
 *
 */
public class HttpPost
{
	public static String send(String url, List<HttpParam> params)
	{
		System.out.println(String.format("http post参数:%s", params));
		HttpURLConnection conn = null;
		OutputStream output = null;
		BufferedReader reader = null;
		try
		{
			URL tmpUrl = new URL(url);
			conn = (HttpURLConnection)tmpUrl.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			//设置请求编码格式
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			String param = "";
			for(int i = 0; i < params.size(); i++)
			{
				HttpParam tmpParam = params.get(i);
				if(i != params.size() -1)
				{
					param += String.format("%s=%s&", tmpParam.getKey(), tmpParam.getValue());
				}
				else
				{
					param += String.format("%s=%s", tmpParam.getKey(), tmpParam.getValue());
				}
			}
			
			System.out.println(param);
			
			output = conn.getOutputStream();
			Charset set = Charset.forName("UTF-8");
			output.write(param.getBytes(set));
			output.flush();
			output.close();
			reader = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));
			
			String result = "";
			String tmpResult = "";
			while((tmpResult = reader.readLine()) != null)
			{
				result += tmpResult;
			}
			return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				conn.disconnect();
			}
			
			if(reader != null)
			{
				try
				{
					reader.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		Map<Long, Map<String, long[]>> groupDatas = new HashMap<Long, Map<String, long[]>>();
		groupDatas.put(1L, new HashMap<String, long[]>());
		Set<Long> tmpSet = groupDatas.keySet();
		if(tmpSet == null || tmpSet.isEmpty())
		{
			System.out.println(11);
		}
	}
	
}
