package com.charles.beautyofprogramming;

public class BinaryQuestions {
	public static int checkBinaryLast1Position(int n){
		int low = 0;
		while((n % 2) == 0){
			low ++;
			n = n >> 1;
		}
		return low;
	}
	
	public static boolean checkIf2mi(int n){
		return (n & (n -1)) == 0;
	}
	
	public static void main(String[] args){
		System.out.println(checkBinaryLast1Position(100));
		System.out.println(checkIf2mi(65535));
	}
}
