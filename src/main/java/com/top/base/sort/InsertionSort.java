package com.top.base.sort;

import java.util.Arrays;

/**
 * 插入排序(稳定)
 * 每一个数据向前比较，就像每次来一个数据先放到最后位置，然后往前比较，找到合适位置放下
 * 来个人，你去跟前面几个比比谁最小，你站到比你小的那个人前面
 * 再来个人，你去跟前面几个比比谁最小，你站到比你小的那个人前面
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] a = {4,1,3,8,2,9,5,10,0,6,7};
		insertionSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static int[] insertionSort(int[] a) {
		int n = a.length, j, v;
		for (int i = 1; i < n; i++) {
			for (v = a[i], j = i - 1; j >=0 && v < a[j]; j--) {
				a[j+1] = a[j];
			}
			a[j+1] = v;
		}
		return a;
	}
}
