/**
 * 
 */
package com.httpclient.test;

import java.util.HashMap;
import java.util.Map;

import com.httpclient.service.HttpClientGet;
import com.httpclient.service.HttpClientPost;

/**
 * @author ignore1992
 *
 * 2018-6-25
 */
public class Main
{
	public static void main(String[] args)
	{
		String url = "http://biz.emoboo.com/api/mt/index.jsp?";
		Map<String, String> params = new HashMap<String, String>();
		params.put("u", "user");
		params.put("p", "13000000000");
		params.put("m", "123");
		params.put("c", "%B2%E2%CA%D4test123");
		params.put("z", "5451F74A301FC17D27AA6F1BD3CA9871");
		//1.测试HttpClient get请求方式
		HttpClientGet.send(url, params);
		//2.测试HttpClient post请求方式
		HttpClientPost.send(url, params);
	}
}
