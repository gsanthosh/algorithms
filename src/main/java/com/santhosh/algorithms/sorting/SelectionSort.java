package com.santhosh.algorithms.sorting;

import java.util.Scanner;

public class SelectionSort {
	public void selectionSort(int[] numToSort){
		for(int i=0;i<numToSort.length;i++){
			for(int j=0;j<numToSort.length-(i+1);j++)
			{
				if(numToSort[j]>numToSort[j+1])
				{
					int tmp=numToSort[j];
					numToSort[j]=numToSort[j+1];
					numToSort[j+1]=tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		try(Scanner inputScanner=new Scanner(System.in)){
		      int numOfIntegers=inputScanner.nextInt();
		      int[] inputInt=new int[numOfIntegers];
		      for(int i=0;i<numOfIntegers;i++){
		    	  inputInt[i]=inputScanner.nextInt();
		      }
		      new SelectionSort().selectionSort(inputInt);
		      for(int i=0;i<inputInt.length;i++){
		    	  System.out.println(inputInt[i]);
		      }
		}
	}
}
