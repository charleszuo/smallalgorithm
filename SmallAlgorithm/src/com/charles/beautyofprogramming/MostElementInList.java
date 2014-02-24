package com.charles.beautyofprogramming;

public class MostElementInList {
	// 查找一个序列里数量超过50%的那个元素， O(n)
	public static int getMostElementInList(int[] data){
		int nTimes = 0;
		int caididate = 0;
		int i = data.length - 1;
		while(i != 0){
			if(nTimes == 0){
				caididate = data[i];
				nTimes = 1;
			}else{
				if(caididate != data[i]){
					nTimes--;
				}else{
					nTimes++;
				}
			}
			i--;
		}
		return caididate;
	}
	
	public static void main(String[] args){
		int[] data = {1,2,2,1,3,1,1,2,2,1,1};
		System.out.println(getMostElementInList(data));
	}
}
