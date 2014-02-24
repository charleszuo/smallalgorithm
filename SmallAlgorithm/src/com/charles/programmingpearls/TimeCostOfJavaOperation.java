package com.charles.programmingpearls;

import java.util.Date;

/**
 * 
 * @author charles
 * Java中基本操作的时间消耗，加减乘除，取模。执行10的9次方次，看消耗了多少纳米，然后除以10的9次方，得到每个基本操作的纳米数
 */

public class TimeCostOfJavaOperation {
	public static void timeCostSet() {
		long a = 0;
		long timeBegin = new Date().getTime();
		for (long i = 0; i < 1000000000; i++) {
			a = 1;
		}
		long timeEnd = new Date().getTime();
		System.out.println("Time cost of Set " + (timeEnd - timeBegin)
				* 1000000 / 1000000000d);
	}
	
	public static void timeCostAdd(){
		long a = 0;
		long timeBegin = new Date().getTime();
		for(long i = 0; i < 1000000000; i++){
			a += 1;
		}
		long timeEnd = new Date().getTime();
		System.out.println("Time cost of Add and Add " + (timeEnd - timeBegin) * 1000000 / 1000000000d);
	}
	
	public static void timeCostSub(){
		long a = 0;
		long timeBegin = new Date().getTime();
		for(long i = 0; i < 1000000000; i++){
			a -= 0;
		}
		long timeEnd = new Date().getTime();
		System.out.println("Time cost of Sub and Set " + (timeEnd - timeBegin) * 1000000 / 1000000000d);
	}
	
	public static void timeCostMul(){
		long a = 1;
		long timeBegin = new Date().getTime();
		for(long i = 0; i < 1000000000; i++){
			a *= 1;
		}
		long timeEnd = new Date().getTime();
		System.out.println("Time cost of Mul and Set " + (timeEnd - timeBegin) * 1000000 / 1000000000d);
	}
	
	public static void timeCostDiv(){
		long a = 1;
		long timeBegin = new Date().getTime();
		for(long i = 0; i < 1000000000; i++){
			a /= 1;
		}
		long timeEnd = new Date().getTime();
		System.out.println("Time cost of Div and Set " + (timeEnd - timeBegin) * 1000000 / 1000000000d);
	}
	
	public static void timeCostMod(){
		long a = 0;
		long timeBegin = new Date().getTime();
		for(long i = 0; i < 1000000000; i++){
			a /= 1;
		}
		long timeEnd = new Date().getTime();
		System.out.println("Time cost of Div and Set " + (timeEnd - timeBegin) * 1000000 / 1000000000d);
	}

	public static void main(String[] args) {
		timeCostSet();
		timeCostAdd();
		timeCostSub();
		timeCostMul();
		timeCostDiv();
		timeCostMod();
	}
}
