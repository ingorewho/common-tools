/**
 * 
 */
package com.object.test;

import com.object.service.ObjectSizeService;

/**
 * @author ignore1992
 *
 * 2018-6-26
 */
public class Main
{
	public static void main(String[] args)
	{
		//1.测试包含非基本类型属性的对象大小
		System.out.println(String.format("sizeof(new A):%s", ObjectSizeService.sizeOf(new A())));
		//2.测试包含非基本类型属性的对象大小
		System.out.println(String.format("sizeof(new B):%s", ObjectSizeService.sizeOf(new B())));
		//3.测试基本类型数组对象的大小
		System.out.println(String.format("sizeof(new int[0]):%s", ObjectSizeService.sizeOf(new int[0])));
		System.out.println(String.format("sizeof(new int[1]):%s", ObjectSizeService.sizeOf(new int[1])));
		//4.测试非基本类型数组对象的大小
		System.out.println(String.format("sizeof(new A[0]):%s", ObjectSizeService.sizeOf(new A[0])));
		System.out.println(String.format("sizeof(new A[1]):%s", ObjectSizeService.sizeOf(new A[1])));
	}
}

class A
{
	//基本类型
	int a = 0;
}

class B
{
	//引用类型
	Integer b = 0;
}
