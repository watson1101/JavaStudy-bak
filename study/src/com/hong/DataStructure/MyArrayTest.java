package com.hong.DataStructure;

public class MyArrayTest {

	public static void main(String[] args) {
		MyArray myArray = new MyArray();
		myArray.insert(12);
		myArray.insert(23);
		myArray.insert(44);
		myArray.insert(36);
		myArray.display();
		// 查找
		System.out.println("search 1:" + myArray.search(23));
		System.out.println("search 2:" + myArray.search(32));

		// System.out.println(myArray.get(-2));
		System.out.println(myArray.get(2));
		// System.out.println(myArray.get(4));
	}

}
