package com.santhosh.algorthms.careercup.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringPermutation {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String scannedString = scanner.nextLine();
		StringPermutation anagrams = new StringPermutation();
		anagrams.generateAnagrams(scannedString, 0);
	}

	public void generateAnagrams(String inputString, int k) {
		if (inputString.length() - 1 == k) {
			System.out.println(inputString);
			return;
		}
			for (int j=k; j < inputString.length(); j++) {
				generateAnagrams(swap(inputString,j,k),k+1);
			}
	}
	
	public boolean checkAnangramList(String inputString,String wordToCheck)
	{
		List<String>  anagramList=new LinkedList<>();
		return createAnagramList(inputString,0,wordToCheck);
		
		
	}
	
	private boolean createAnagramList(String inputString, int k,String wordToCheck) {
		if (inputString.length() - 1 == k ) {
			System.out.println(inputString);	
		 if(inputString.contains(wordToCheck))
			 return true;
		 else
			 return false;
		}
			for (int j=k; j < inputString.length(); j++) {
				createAnagramList(swap(inputString,j,k),k+1,wordToCheck);
			}
			return false;
	}

	private String swap(String inputString, int j, int k) {
		if(j==k)
			return inputString;
		char[] inputCharArr=inputString.toCharArray();
		char tmp=inputCharArr[j];
		inputCharArr[j]=inputCharArr[k];
		inputCharArr[k]=tmp;
		return new String(inputCharArr);
	}

	
}
