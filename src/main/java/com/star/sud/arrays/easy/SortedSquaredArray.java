package com.star.sud.arrays.easy;

import java.util.Arrays;

public class SortedSquaredArray {

	public static void main(String[] args) {
		int[] array = new int[] { -5, -3, -2, -1, 4, 6, 8, 9 };

		int[] sortedSquaredArray = sortedSquaredArray(array);
		System.out.println(Arrays.toString(sortedSquaredArray));
	}

	// time - O(nlogn), space - O(n) - where n is the length of the input array
	public static int[] sortedSquaredArray(int[] array) {
		// Write your code here.
		int[] sortedSquaredArray = new int[array.length];

		for (int idx = 0; idx < array.length; idx++) {
			sortedSquaredArray[idx] = array[idx] * array[idx];
		}

		Arrays.sort(sortedSquaredArray); // nlogn
		return sortedSquaredArray; // n + nlogn = 2nlogn = nlogn
	}

	public static int[] sortedSquaredArray02(int[] array) {

		// Assumption: give input is sorted array
		int[] sortedSquaredArray = new int[array.length];

		int smallerValueIdx = 0;
		int largerValueIdx = array.length - 1;

		for (int idx = array.length - 1; idx >= 0; idx--) {

			int smallerValue = array[smallerValueIdx];
			int largerValue = array[largerValueIdx];

			if (Math.abs(smallerValue) > Math.abs(largerValue)) {
				sortedSquaredArray[idx] = smallerValue * smallerValue;
				smallerValueIdx++;
			} else {
				sortedSquaredArray[idx] = largerValue * largerValue;
				largerValueIdx--;
			}
		}
		return sortedSquaredArray;
	}

}
