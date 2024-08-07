package com.star.sud.arrays.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {
	public static void main(String[] args) {
		int[] array = { 3, 5, -4, 8, 11, 1, -1, 6 };
		int targetSum = 10;

		int[] twoNumberSum = twoNumberSum(array, targetSum);
		System.out.println(Arrays.toString(twoNumberSum));

		int[] twoNumberSum2 = twoNumberSum(array, targetSum);
		System.out.println(Arrays.toString(twoNumberSum2));

		int[] twoNumberSum_03 = twoNumberSum_03(array, targetSum);
		System.out.println(Arrays.toString(twoNumberSum_03));

	}

	// time - O(n), Space - O(n)
	public static int[] twoNumberSum(int[] array, int targetSum) {
		Set<Integer> values = new HashSet<>();
		for (int num : array) {
			int potentialMatch = targetSum - num;
			if (values.contains(potentialMatch)) {
				return new int[] { num, potentialMatch };
			} else {
				values.add(num);
			}
		}
		return new int[0];
	}

	// time - O(nlog(n)), Space - O(1)
	public static int[] twoNumberSum_02(int[] array, int targetSum) {

		int leftIdx = 0;
		int rightIx = array.length - 1;
		Arrays.sort(array);
		while (leftIdx < rightIx) {
			int currentSum = array[leftIdx] + array[rightIx];
			if (currentSum == targetSum) {
				return new int[] { array[leftIdx], array[rightIx] };
			} else if (currentSum < targetSum) {
				leftIdx++;
			} else {
				rightIx--;
			}
		}

		return new int[0];
	}

	// time - O(n^2), Space - O(1)
	public static int[] twoNumberSum_03(int[] array, int targetSum) {

		for (int i = 0; i < array.length-1; i++) {
			for (int j = i+1; j < array.length; j++) {
				int firstNum = array[i];
				int secondNum = array[j];
				int currentSum = firstNum + secondNum;
				if (currentSum == targetSum) {
					return new int[] { firstNum, secondNum };
				}
			}
		}
		return new int[0];
	}

}
