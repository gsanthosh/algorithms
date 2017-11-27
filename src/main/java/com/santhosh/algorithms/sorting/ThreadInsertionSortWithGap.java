package com.santhosh.algorithms.sorting;

public class ThreadInsertionSortWithGap implements Runnable {
	int[] arr;
	int gap;
	int startPos;

	public ThreadInsertionSortWithGap(int[] arr, int gap, int startPos) {
		this.arr = arr;
		this.gap = gap;
		this.startPos = startPos;
	}

	@Override
	public void run() {
		int length = arr.length;
		for (int i = startPos; i < length; i = i + gap) {
			int j = i - gap;
			int startPosVal = arr[i];
			while (j >= 0 && arr[j] > startPosVal) {
				arr[j + gap] = arr[j];
				j = j - gap;
			}
			arr[j + gap] = startPosVal;
		}		
	}
	
	public static void main(String[] args) {
		int[] arr= {23,5,24,2345,25,73,67,34,7,54,46,84,454,364,3356,3,64,6833,3,23,0,2552,-21};
		ThreadInsertionSortWithGap insSort=new ThreadInsertionSortWithGap(arr,1,0);
		Thread t=new Thread(insSort);
		t.run();
		for(int a :arr) {
			System.out.println(a);
		}
		/*insSort.run();
		for(int a :arr) {
			System.out.println(a);
		}*/
		
		/*ExecutorService executor=Executors.newFixedThreadPool(10);
		executor.execute(insSort);
		for(int a :arr) {
			System.out.println(a);
		}
		executor.shutdown();*/
	}
}
