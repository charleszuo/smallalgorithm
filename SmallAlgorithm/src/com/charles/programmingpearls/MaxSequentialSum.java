package com.charles.programmingpearls;

/**
 * 
 * @author charleszuo@126.com
 * 编程珠玑的第8章的问题，从数列{ 31, -41, 59, 26, -53, 58, 97, -93, -23, 84 }中找到连续子向量的最大值
 *
 */
public class MaxSequentialSum {
	
	// 使用二维数组存储各点到各点的距离, O(n^2)
	public static void solution1(int[] data){
		int length = data.length;
		int[][] values = new int[length][length];
		for(int i = 0; i < length; i ++){
			values[i][i] = data[i];
		}
		for(int m = 0; m < length - 1; m++){
			for(int n = m + 1; n < length - 1; n++){
				values[m][n] = values[m][n-1] + data[n]; 
			}
		}
		for(int k = 0; k < length; k++){
			int maxsofar = 0;
			int v = 0;
			for(int w = 0; w < length; w++){
				if(values[k][w] > maxsofar){
					maxsofar = values[k][w];
					v = w;
				}
			}
			System.out.println("Max " + maxsofar + " From " + k + " to " + v);
		}
	}
	
	// 用maxsofar记录当前最大的值，用begin, end记录开始和结束的点. O(n^2)
	public static void solution2(int[] data){
		int length = data.length;
		int maxsofar = 0;
		int begin = 0;
		int end = 0;
		for(int m = 0; m < length - 1; m++){
			int sum = 0;
			for(int n = m; n < length - 1; n++){
				sum = sum + data[n];
				if(sum > maxsofar){
					maxsofar = sum;
					begin = m;
					end = n;
				}
			}
		}
		System.out.println("Max " + maxsofar + " From " + begin + " to " + end);
	}
	
	// 分治法，先划分，再解决，再递归。比较从中间开始计算，和左半部分，右半部分的大小(nlogn)
	public static int solution3(int[] data, int begin, int end){
		if(begin > end){
			return 0;
		}else if(begin == end){
			return data[begin];
		}
		int mid = (end + begin) / 2;
		int lmax = -100;
		int sum = 0;
		for(int i = mid; i >= 0; i--){
			sum = sum + data[i];
			if(sum > lmax){
				lmax = sum;
			}
		}
		int rmax = -100;
		sum = 0;
		for(int i = mid + 1; i <= end; i++){
			sum = sum + data[i];
			if(sum > rmax){
				rmax = sum;
			}
		}
		
		
		int maxmid = lmax + rmax;
		int maxleft = solution3(data, begin, mid);
		int maxright = solution3(data, mid + 1, end);
		int maxsofar = -100;
		maxsofar = maxleft > maxright ? maxleft : maxright;
		maxsofar = maxmid > maxsofar ? maxmid : maxsofar;
		return maxsofar;
	}
	
	// 用当加上负数小于0之后，重新计算maxendhere，设置为0； maxsofar记录当前最大值。O(n)
	public static void solution4(int[] data){
		int maxsofar = 0, maxendhere = 0;
		int i = 0, begin = 0, end = 0;
		
		while(i < data.length){
			maxendhere += data[i];
			if(maxendhere < 0){
				maxendhere = 0;
				begin = i + 1;
			}
			if(maxendhere > maxsofar){
				maxsofar = maxendhere;
				end = i;
			}
			i++;
		}
		System.out.println("Max " + maxsofar + " From " + begin + " to " + end);
	}
	
	public static void main(String[] args) {
		int[] data = { 31, -41, 59, 26, -53, 58, 97, -93, -23, 84 };
		solution4(data);
		
		System.out.println("Max " + solution3(data, 0, data.length -1));
	}
	
}
