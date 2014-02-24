package com.charles.beautyofprogramming;

public class BinaryQuestions {
	// 最后一个1的位置. 对2取模只有0，1两种情况
	public static int checkBinaryLast1Position(int n){
		int low = 0;
		while((n % 2) == 0){
			n = n >> 1;
			low ++;
		}
		return low;
	}
	
	// 最后一个1的位置. 
	public static int checkBinaryLast1Position_Pro(int n){
		int low = 0;
		// 检查最后1位是否为1
		while((n & 0x01) != 1 && n != 0){
			n = n >> 1;
			low ++;
		}
		return low;
	}
	
	// 是否是2的幂
	public static boolean checkIf2mi(int n){
		return (n & (n -1)) == 0;
	}
	
	// n的二进制表示法里1的个数
	public static void howmany1InBinary(byte n){
		int num = 0;
		while(n != 0){
			n = (byte) (n & (n - 1));
			num ++;
		}
		System.out.println("There are " + num + " one in " + n + " binary");
	}
	
	// N！末尾有几个0，其实就是算N！有几个2 * 5，因为2的个数肯定比5多，所以其实就是计算N!有几个5的因子
	public static void howmany0infact(int n){
		int num = 0;
		int fact = factorial(n);
		while(fact % 5 == 0){
			fact = fact / 5;
			num ++;
		}
		System.out.println("There are " + num + " zero in end");
	}
	
	// 求阶乘
	public static int factorial(int n){
		if(n <= 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		n = n * factorial(n - 1);
		return n;
	}
	
	public static void main(String[] args){
		System.out.println(checkBinaryLast1Position(100));
		System.out.println(checkBinaryLast1Position_Pro(100));
		System.out.println(ByteStorage.toBinaryString(100));
		System.out.println(checkIf2mi(65535));
		howmany1InBinary((byte)15);
		howmany0infact(5);
	}
}
