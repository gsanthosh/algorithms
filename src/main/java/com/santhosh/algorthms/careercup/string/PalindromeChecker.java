package com.santhosh.algorthms.careercup.string;

import java.util.Scanner;

public class PalindromeChecker {
	
	public static void main(String args[])
	{
		Scanner scanner= new Scanner(System.in);
		String input=scanner.next();
		PalindromeChecker checker =new PalindromeChecker();
		System.out.println("Is it a  palindrome"+checker.checkPalindrome(input));
	}
	
	public boolean checkPalindrome(String palindrome)
	{
		if(palindrome==null)
			return false;
		int length=palindrome.length();
		if(length==1)
			return true;
		int i,j;
		char[] palindromeCharArr=palindrome.toCharArray();
		for(i=0,j=length-1;j>i;i++,j--)
		{
			if(palindromeCharArr[i]!=palindromeCharArr[j])
				return false;
		}
		return true;
	}
	

}
