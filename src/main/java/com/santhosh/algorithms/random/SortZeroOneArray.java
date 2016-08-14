package com.santhosh.algorithms.random;

import java.util.Scanner;

//Sort a array made up of zero and one

public class SortZeroOneArray {

	public int[] sortZeroOneArray(int[] zeroOneArray) {
		if (zeroOneArray.length == 0 || zeroOneArray.length == 1) {
			return zeroOneArray;
		}
		for (int i = 0; i < zeroOneArray.length - 1; i++) {
			int lastZeroPosition = i;
			if (zeroOneArray[i] == 0) {
				continue;
			}
			for (int j = i + 1; j < zeroOneArray.length; j++) {
				if (zeroOneArray[j] == 0) {
					lastZeroPosition = j;
				}
			}
			if (lastZeroPosition != i) {
				zeroOneArray[i] = 0;
				zeroOneArray[lastZeroPosition] = 1;
			}
		}
		return zeroOneArray;
	}

	public void printArray(int[] zeroOneArray) {
		for (int i = 0; i < zeroOneArray.length; i++) {
			System.out.println(zeroOneArray[i]);
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int numIntegers = scanner.nextInt();
			int[] zeroOneArray = new int[numIntegers];
			for (int i = 0; i < numIntegers; i++) {
				zeroOneArray[i] = scanner.nextInt();
			}

			SortZeroOneArray sortZeroOneArray = new SortZeroOneArray();
			sortZeroOneArray.printArray(sortZeroOneArray.sortZeroOneArray(zeroOneArray));
		}
	}

}
