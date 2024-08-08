package com.star.sud.arrays.easy;

import java.util.Arrays;
import java.util.List;

public class ValidateSubSequence {

	public static void main(String[] args) {

		List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
		List<Integer> sequence = Arrays.asList(1, 6, -1, 10);

		boolean validSubsequence = isValidSubsequence(array, sequence);
		System.out.println(validSubsequence);

		boolean validSubsequence02 = isValidSubsequence_02(array, sequence);
		System.out.println(validSubsequence02);

	}

	// time - O(n), space - O(1) - where n is length of the array
	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

		int arrayIdx = 0;
		int sequenceIdx = 0;

		while (arrayIdx < array.size() && sequenceIdx < sequence.size()) {
			if (array.get(arrayIdx).equals(sequence.get(sequenceIdx))) {
				sequenceIdx++;
			}
			arrayIdx++;
		}
		return sequenceIdx == sequence.size();
	}

	// time - O(n), space - O(1)
	public static boolean isValidSubsequence_02(List<Integer> array, List<Integer> sequence) {

		int sequenceIdx = 0;

		for (Integer element : array) {

			if (sequenceIdx == sequence.size()) {
				break;
			}

			if (element.equals(sequence.get(sequenceIdx))) {
				sequenceIdx++;
			}

		}
		return sequenceIdx == sequence.size();
	}

}
