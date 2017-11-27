package com.santhosh.algorithms.sorting;

public class ShellSort {
	
	public void shellSort(int inputArr[]) throws InterruptedException {
		int length=inputArr.length;
		int gap=new Double(Math.sqrt(length)).intValue();
		
		for(;gap>0;gap=gap/2) {
			int startPos=0;
			int numTimes=length/gap;
			
			for(int i=0;i<numTimes;i++) {
				Thread t =new Thread(new ThreadInsertionSortWithGap(inputArr, gap,++startPos)); 
				t.start();
				t.join();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int[] arr= {23,5,24,2345,25,73,67,34,7,54,46,84,454,364,3356,3,64,6833,3,23,0,2552,-21,23,5,24,2345,25,73,67,34,7,54,46,84,454,364,3356,3,64,6833,3,23,0,2552,-21};
		ShellSort sort=new ShellSort();
		sort.shellSort(arr);
		for(int a :arr) {
			System.out.println(a);
		}
	}

}
