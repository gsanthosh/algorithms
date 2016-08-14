package com.santhosh.algorithms.random;

import java.util.Scanner;

public class PermutateString {
	
	public void permutate(String input)
	{
		int length=input.length();
		
		if(length==1)
		{
			 System.out.print(input);
		}
		for(int i=0;i<length-1;i++)
		{
			for(int j=i+1;j<length;j++)
			{
			    permutate(input.substring(j)+input.charAt(i));
			    
			}
			
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String input=scanner.next();
		PermutateString ps=new PermutateString();
		ps.permutate(input);
	}

}
