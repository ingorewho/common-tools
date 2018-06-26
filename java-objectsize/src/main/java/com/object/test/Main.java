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
		//1.测试非基本类型对象大小
		System.out.println(String.format("sizeof(new A):%s", ObjectSizeService.sizeOf(new A())));
		System.out.println(String.format("fullsizeof(new A):%s", ObjectSizeService.fullSizeOf(new A())));
		System.out.println(String.format("sizeof(new B):%s", ObjectSizeService.sizeOf(new B())));
		System.out.println(String.format("fullsizeof(new B):%s", ObjectSizeService.fullSizeOf(new B())));
		
		//2.测试基本类型数组对象的大小
		System.out.println(String.format("sizeof(new int[1]):%s", ObjectSizeService.sizeOf(new int[1])));
		System.out.println(String.format("fullsizeof(new int[1]):%s", ObjectSizeService.fullSizeOf(new int[1])));
		System.out.println(String.format("sizeof(new int[2]):%s", ObjectSizeService.sizeOf(new int[2])));
		System.out.println(String.format("fullsizeof(new int[2]):%s", ObjectSizeService.fullSizeOf(new int[2])));
		System.out.println(String.format("sizeof(new int[3]):%s", ObjectSizeService.sizeOf(new int[3])));
		System.out.println(String.format("fullsizeof(new int[3]):%s", ObjectSizeService.fullSizeOf(new int[3])));
		
		
		//3.测试非基本类型数组对象的大小
		System.out.println(String.format("sizeof(new Integer[1]):%s", ObjectSizeService.sizeOf(new Integer[1])));
		System.out.println(String.format("fullsizeof(new Integer[1]):%s", ObjectSizeService.fullSizeOf(new Integer[1])));
		System.out.println(String.format("sizeof(new Integer[2]):%s", ObjectSizeService.sizeOf(new Integer[2])));
		System.out.println(String.format("fullsizeof(new Integer[2]):%s", ObjectSizeService.fullSizeOf(new Integer[2])));
		System.out.println(String.format("sizeof(new Integer[3]):%s", ObjectSizeService.sizeOf(new Integer[3])));
		System.out.println(String.format("fullsizeof(new Integer[3]):%s", ObjectSizeService.fullSizeOf(new Integer[3])));
		
		//4.测试非基本类型数组对象的大小
		System.out.println(String.format("sizeof(new A[1]):%s", ObjectSizeService.sizeOf(new A[1])));
		System.out.println(String.format("fullsizeof(new A[1]):%s", ObjectSizeService.fullSizeOf(new A[1])));
		System.out.println(String.format("sizeof(new A[2]):%s", ObjectSizeService.sizeOf(new A[2])));
		System.out.println(String.format("fullsizeof(new A[2]):%s", ObjectSizeService.fullSizeOf(new A[2])));
		System.out.println(String.format("sizeof(new A[3]):%s", ObjectSizeService.sizeOf(new A[3])));
		System.out.println(String.format("fullsizeof(new A[3]):%s", ObjectSizeService.fullSizeOf(new A[3])));
		
		//5.测试存在继承关系的非基本类型数组对象的大小
		System.out.println(String.format("sizeof(new B[1]):%s", ObjectSizeService.sizeOf(new B[1])));
		System.out.println(String.format("fullsizeof(new B[1]):%s", ObjectSizeService.fullSizeOf(new B[1])));
		System.out.println(String.format("sizeof(new B[2]):%s", ObjectSizeService.sizeOf(new B[2])));
		System.out.println(String.format("fullsizeof(new B[2]):%s", ObjectSizeService.fullSizeOf(new B[2])));
		System.out.println(String.format("sizeof(new B[3]):%s", ObjectSizeService.sizeOf(new B[3])));
		System.out.println(String.format("fullsizeof(new B[3]):%s", ObjectSizeService.fullSizeOf(new B[3])));
	}
}

class A
{
	int a = 0;
	String str = "123456";
}

class B extends A
{
	int b = 0;
	String str1 = "12345678";
}
