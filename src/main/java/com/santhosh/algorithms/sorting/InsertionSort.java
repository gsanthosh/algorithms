package com.santhosh.algorithms.sorting;

import java.util.Scanner;

public class InsertionSort {
	public static int[] insertionSort(int[] numToBeSorted)
	{
		int length=numToBeSorted.length;
		if(length==0)
			return null;
		
		if(length==1)
			return numToBeSorted;
		
		for(int i=1;i<length;i++)
		{
			int sortNum=numToBeSorted[i];
			for(int j=i-1;j>=0;j--)
			{
				if(sortNum>=numToBeSorted[j])
				{
					break;
				}
				
				while(j>=0 && sortNum<numToBeSorted[j])
				{
					numToBeSorted[j+1]=numToBeSorted[j];
					j--;
				}
				numToBeSorted[j+1]=sortNum;
				
			}
		}
		
		
		return numToBeSorted;
	}
	
	public static void main(String[] args) {
		try(Scanner inputScanner=new Scanner(System.in))
		{
		      int numOfIntegers=inputScanner.nextInt();
		      int[] inputInt=new int[numOfIntegers];
		      for(int i=0;i<numOfIntegers;i++)
		      {
		    	  inputInt[i]=inputScanner.nextInt();
		      }
		      InsertionSort.insertionSort(inputInt);
		      for(int i=0;i<inputInt.length;i++)
		      {
		    	  System.out.println(inputInt[i]);
		      }
		}
	}
}
