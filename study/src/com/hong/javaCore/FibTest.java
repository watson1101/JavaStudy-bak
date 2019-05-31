package com.hong.javaCore;

public class FibTest {

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		int r = fib(30);
		long t2 = System.currentTimeMillis();
		System.out.println("result = "+r+" ;time = "+(t2-t1));
	}

	private static int fib(int n) {
		System.out.println("------------ "+n);
		if(n<=1) {
			return n;
		}else {
			return fib(n-1)+fib(n-2);
		}
		
	}

}
