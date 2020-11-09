package com.nasim;

public class Test {
	public static void main(String[] args) {
		int a = 10;
		a = a++ + ++a - a++ + a++;
		if (a > 55) {
			System.out.println("Valid " +a);
		} else {
			System.out.println("invalid "+a);
		}
		System.out.println("Done");
	}
}
