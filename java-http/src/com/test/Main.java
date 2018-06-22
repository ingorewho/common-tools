/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.List;

import com.http.HttpGet;
import com.http.HttpParam;
import com.http.HttpPost;

/**
 * @author ignore1992
 *
 * 2018-6-21
 */
public class Main
{
	public static void main(String[] args)
	{
		String testUrl = "http://www.baidu.com";
		List<HttpParam> params = new ArrayList<HttpParam>();
		HttpParam param = new HttpParam();
		param.setKey("test-key");
		param.setValue("test-value");
		params.add(param);
		//测试get请求
		HttpGet.send(testUrl, params);
		//测试post请求
		HttpPost.send(testUrl, params);
	}
}
