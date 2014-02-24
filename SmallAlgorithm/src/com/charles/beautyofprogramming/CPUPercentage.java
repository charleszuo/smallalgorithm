package com.charles.beautyofprogramming;

import java.util.Date;

/**
 * 
 * @author charles@126.com
 * 让CPU监视器一直显示50%
 * 1个基本操作是0.7纳秒，CPU监视器1秒钟刷新一次，那么执行500毫秒，休息500毫秒
 * 执行基本操作的次数 = 500 * 10^6 / 0.7 = 5 * 10^9 / 7
 * 就可以让CPU显示50%。前提是操作都在1个CPU内核，并且CPU只运行这个线程
 * 
 * 问题，用JVM执行，本身JVM就要消耗CPU，所以不精确
 */
public class CPUPercentage {
	
	public static void main(String[] args){
		
		float busytime = 5000000000f / 7;
		long timeBegin = new Date().getTime();
		int a = 0;
		while(true){
			for(int i = 0; i < busytime; i++){
				a = 0;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// 超过20秒退出，防止死循环
			long timeEnd = new Date().getTime();
			if(timeEnd - timeBegin > 20000){
				break;
			}
		}
	}
}
