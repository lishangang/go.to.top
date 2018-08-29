package com.top.base.sort;

import java.util.Arrays;

/**
 * 测试各种排序
 */
public class Test {

	public static void main(String[] args) {
		// 插入排序
		System.out.println(Arrays.toString(InsertionSort.insertionSort(new int[]{4,1,3,8,2,9,5,10,0,3,6,7})));
		// 选择排序
		System.out.println(Arrays.toString(SelectionSort.selectionSort(new int[]{4,1,3,3,8,2,9,5,10,0,6,7})));
		// 冒泡排序
		System.out.println(Arrays.toString(BubbleSort.bubbleSort(new int[]{4,3,1,3,8,2,9,5,10,0,6,7})));
	}
}
