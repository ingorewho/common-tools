/**
 * 
 */
package com.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author ignore1992
 *
 */
public class HttpGet
{
	public static String send(String url, List<HttpParam> params)
	{
		System.out.println(String.format("http get参数:%s", params));
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		try
		{
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
			String newUrl = url + "?" + param;
			URL tmpUrl = new URL(newUrl);
			conn = (HttpURLConnection)tmpUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			
			conn.connect();
			
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
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return null;
	}
}
