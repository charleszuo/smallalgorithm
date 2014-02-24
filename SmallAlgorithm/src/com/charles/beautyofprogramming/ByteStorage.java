package com.charles.beautyofprogramming;

/**
 * 
 * @author charles@126.com 充分利用byte的位操作，使1个byte存储多个变量的值 解决《编程之美》书中的将帅问题
 * & 0 可以关闭位， | 1可以打开位
 * 要设置某几个位的值，要先把这几位关闭，然后再设置
 */
public class ByteStorage {
	// 00001111, 可以关闭左侧4位
	private static final byte LEFT_MASK = (byte) 0x0F;

	// 11110000, 可以关闭右侧4位
	private static final byte RIGHT_MASK = (byte) 0xF0;

	private static final byte[] bitMask = new byte[8];

	static {
		bitMask[7] = (byte) 0x80;
		bitMask[6] = (byte) 0x40;
		bitMask[5] = (byte) 0x20;
		bitMask[4] = (byte) 0x10;
		bitMask[3] = (byte) 0x08;
		bitMask[2] = (byte) 0x04;
		bitMask[1] = (byte) 0x02;
		bitMask[0] = (byte) 0x01;
	}

	// 打印byte的二进制串
	public static String toBinaryString(int b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 7; i >= 0; i--) {
			// Java使用的是有符号系统，1开头的为负数，所以得用绝对值代替
			sb.append(Math.abs(bitMask[i] & b) / (int) Math.pow(2, i));
		}
		return sb.toString();
	}

	// 注意：对于有符号数取左边四位，最后右移之后还要把左边的符号位关闭
	public static byte getLeft(byte b) {
		return (byte)(((b & RIGHT_MASK) >> 4) & LEFT_MASK);
	}
	
	// 有可能变符号
	public static byte setLeft(byte b, byte i) {
		return (byte) ((b & LEFT_MASK) | (i << 4));
	}

	// 不需要考虑符号，因为左边都已经关闭成0
	public static byte getRight(byte b) {
		return (byte)(b & LEFT_MASK);
	}

	// 不改变符号
	public static byte setRight(byte b, byte i) {
		return (byte) ((b & RIGHT_MASK) | i);
	}

	public static void solution1() {
		// 解将帅不能碰面的问题
		// 只使用 v 一个变量
		byte v = 0;
		for (v = setLeft(v, (byte)1); getLeft(v) <= 9; v = setLeft(v,(byte)(getLeft(v) + 1))) {
			for (v = setRight(v, (byte)1); getRight(v) <= 9; v = setRight(v, (byte)(getRight(v) + 1))) {
				if (getLeft(v) % 3 != getRight(v) % 3) {
					System.out.printf("(%d, %d)\n", getLeft(v), getRight(v));
				}
			}
		}
	}
	
	// 对一个数取模，可以形成0到这个数-1的区间。本题中，有9个位置，分为3列，将在1列是，帅只能在2，3列，所以得有9个数的区间，和3个数的区间
	// 所以 % 9 % 3。因为最后1个位置是9，所以从81开始
	public static void solution2(){
		byte i = 81;
		while(i != 0){
			if(i / 9 % 3 != i % 9 % 3){
				System.out.printf("(%d, %d)\n", i / 9 + 1, i % 9 + 1);
			}
			i --;
		}
	}

	public static void main(String[] args) {
//		System.out.println(toBinaryString(LEFT_MASK));
//		System.out.println(toBinaryString(RIGHT_MASK));
//		System.out.println(toBinaryString((byte) 48));
//		System.out.println(getLeft(48));


//		solution1();
		solution2();
	}

}
