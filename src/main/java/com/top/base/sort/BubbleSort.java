package com.top.base.sort;

import java.util.Arrays;

/**
 * 冒泡排序(稳定)
 * 
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] a = {4,1,3,8,2,9,5,10,0,7,6};
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static int[] bubbleSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
}
