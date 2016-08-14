package com.santhosh.algorithms.random;

import java.util.Scanner;

public class TransposeMatrix {

	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		int m=scanner.nextInt();
		int n=scanner.nextInt();
		int[][] originalArray=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				originalArray[i][j]=scanner.nextInt();
			}
		
		int[][] transposedArray=new int[n][m];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				transposedArray[j][i]=originalArray[i][j];
			}
		
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(originalArray[i][j]+"\t\t");
			}
			System.out.println("\n");
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(transposedArray[i][j]+"\t\t");
			}
			System.out.println("\n");
		}
	}
}
