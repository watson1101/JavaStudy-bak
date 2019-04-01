package com.hong.DataStructure;

/**
 * 自定义数组
 *
 * @author hongw
 *
 */
public class MyArray {
	// define an Array
	private long[] arr;
	// 数组长度
	private int element;

	/**
	 * 默认构造方法，长度为50
	 */
	public MyArray() {
		arr = new long[50];
	}

	/**
	 * 重载构造方法
	 *
	 * @param maxSize
	 */
	public MyArray(int maxSize) {
		arr = new long[maxSize];
	}

	/**
	 * 添加数据
	 *
	 * @param value
	 */
	public void insert(long value) {
		arr[element] = value;
		element++;
	}

	/**
	 * 遍历显示数据
	 */
	public void display() {
		System.out.print("[");
		// for (long ele : arr) {
		// System.out.print(ele + " ");
		// }
		for (int i = 0; i < element; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}

	/**
	 * 根据值来查找，返回index
	 *
	 * @param value
	 * @return
	 */
	public int search(long value) {
		int i;
		for (i = 0; i < element; i++) {
			if (value == arr[i]) {
				break;
			}
		}
		if (i == element) {
			return -1;
		} else {
			return i;
		}
	}

	/**
	 * 根据索引查找数据
	 *
	 * @param index
	 * @return
	 */
	public long get(int index) {
		if (index >= element || index < 0) {
			System.out.println("error index..." + index);
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return arr[index];
		}
	}

}
