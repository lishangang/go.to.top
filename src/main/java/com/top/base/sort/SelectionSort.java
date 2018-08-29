package com.top.base.sort;

import java.util.Arrays;

/**
 * 选择排序(非稳定)
 * 每次在后面未被排序的数据中查找最小的那个数据，然后放到前面排好
 * 你们谁最小？
 * 我！。。
 * 好，来你占第一个。剩下的你们谁最小？
 * 我！。。
 * 好，来你占第二个
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] a = {4,1,1,3,8,2,9,5,10,0, 5,6,7};
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static int[] selectionSort(int[] a) {
		int n = a.length, j;
		//记录最小的下标
		int minIndex;
		for (int i = 0; i < n; i++) {
			for (minIndex = i, j = i + 1; j < n; j++) {
				if (a[minIndex] > a[j]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		}
		return a;
	}
}
