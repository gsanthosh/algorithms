package com.santhosh.algorithms.sorting;

import java.util.Scanner;

public class MergeSort {

	public void mergeSort(int p, int r, int[] input) {
		if (r > p) {
			int q = (p + r) / 2;
			mergeSort(p, q, input);
			mergeSort(q + 1, r, input);
			merge(input, p, q, r);
		}
	}

	public void merge(int[] input, int p, int q, int r) {
		// create two tmp subarrays
		int[] leftArray = new int[(q - p) + 2];
		int[] rightArray = new int[(r - q) + 1];
		for (int i = 0; i < leftArray.length - 1; i++) {
			leftArray[i] = input[p + i];
		}
		leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
		for (int i = 0; i < rightArray.length - 1; i++) {
			rightArray[i] = input[(q + 1) + i];
		}
		rightArray[rightArray.length - 1] = Integer.MAX_VALUE;
		// Compare values of rightArray and leftArray
		int leftArrayPointer = 0;
		int rightArrayPointer = 0;
		for (int k = p; k <= r; k++) {
			if (leftArray[leftArrayPointer] <= rightArray[rightArrayPointer]) {
				input[k] = leftArray[leftArrayPointer];
				leftArrayPointer++;
			} else {
				input[k] = rightArray[rightArrayPointer];
				rightArrayPointer++;
			}
		}

	}

	public static void main(String[] args) {
		MergeSort mergeSort=new MergeSort();
		try (Scanner inputScanner = new Scanner(System.in)) {
			int numOfIntegers = inputScanner.nextInt();
			int[] inputInt = new int[numOfIntegers];
			for (int i = 0; i < numOfIntegers; i++) {
				inputInt[i] = inputScanner.nextInt();
			}
			mergeSort.mergeSort(0,inputInt.length-1,inputInt);
			for (int i = 0; i < inputInt.length; i++) {
				System.out.println(inputInt[i]);
			}
		}
	}

}
