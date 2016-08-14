/**
 * 
 */
package com.santhosh.algorthms.careercup.string;

import java.util.Scanner;

/**
 * @author SESA383564
 *
 */
public class ReverseString {
	
	private final char[] originalCharArray;
	public ReverseString(char[] originalCharArray)
	{
		this.originalCharArray=originalCharArray;
	}
	
	public void reverseString()
	{
		int strLength=originalCharArray.length;
		
		for(int i=0,j=strLength-1;i<j;i++,j--)
		{
			char tmp=originalCharArray[j];
			originalCharArray[j]=originalCharArray[i];
			originalCharArray[i]=tmp;
		}
		
		System.out.println(originalCharArray.length);
		for(int i=0;i<originalCharArray.length;i++)
		{
			System.out.print(originalCharArray[i]);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*try(Scanner scanner=new Scanner(System.in))
		{*/
		char[] input={'a','b','c','d'};
		
		ReverseString reverseString=new ReverseString(input);
		reverseString.reverseString();
	//}
	}

}
