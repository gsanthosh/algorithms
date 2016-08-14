package com.santhosh.algorithms.random;

import java.util.Scanner;

public class AllPossibleSubString {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String input=scanner.next();
		int length=input.length();		
				
		char[] inputArray=input.toCharArray();
		StringBuilder builder=new StringBuilder();		
		if(length==1)
		{
			builder.append(inputArray[0]);
			System.out.println(builder.toString());
		}
		else
		for(int i=0;i<length;i++)
		{ 
			System.out.println(inputArray[i]);
			builder.append(inputArray[i]);
			
			for(int j=i+1;j<length;j++)
			{	builder.append(inputArray[j]);
				System.out.println(builder.toString());
			}
			
			builder.setLength(0);	
		}
			
	}

}
