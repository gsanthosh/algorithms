/**
 * 
 */
package com.santhosh.algorithms.random;

import java.util.Scanner;

/**
 * @author SESA383564
 *
 */
public class UniqueSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String input=scanner.next();
		int length=input.length();
		int curLongStrLen=0;
		String curLongSubstring=null;
		input=input.toLowerCase();
		char[] inputArray=input.toCharArray();
		StringBuilder builder=new StringBuilder();
		int[] countArray=new int[256];
		curLongStrLen=1;
		if(length==1)
		{
			builder.append(inputArray[0]);
			curLongSubstring=builder.toString();
		}
		else
		for(int i=0;i<length-1;i++)
		{ 
			countArray[inputArray[i]]=1;
			builder.append(inputArray[i]);
			for(int j=i+1;j<length;j++)
			{
				if(countArray[inputArray[j]]==1)
				{
					break;
				}
				countArray[inputArray[j]]=1;
				builder.append(inputArray[j]);
			}
			
			if(builder.length()>curLongStrLen)
			{
				curLongStrLen=builder.length();
				curLongSubstring=builder.toString();
								
			}
			builder.setLength(0);
			countArray=new int[256];
			
		}
			System.out.println(curLongSubstring);
	}

}
