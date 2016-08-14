package com.santhosh.geekforgeek;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a dictionary of words, find all strings that matches the given pattern where every character in the pattern is uniquely mapped to a character in the dictionary.

Examples:

Input:  
dict = ["abb", "abc", "xyz", "xyy"];
pattern = "foo"
Output: [xyy abb]
Explanation: 
xyy and abb have same character at index 1 and 2 like the pattern

Input:  
dict = ["abb", "abc", "xyz", "xyy"];
pat = "mno"
Output: [abc xyz]
Explanation: 
abc and xyz have all distinct characters, similar to the pattern

Input:  
dict = ["abb", "abc", "xyz", "xyy"];
pattern = "aba"
Output: [] 
Explanation: 
Pattern has same character at index 0 and 2. 
No word in dictionary follows the pattern.

Input:  
dict = ["abab", "aba", "xyz", "xyx"];
pattern = "aba"
Output: [aba xyx]
Explanation: 
aba and xyx have same character at index 0 and 2 like the pattern
 */


import java.util.Scanner;
import java.util.StringTokenizer;

public class StringPatternMatcher {
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the pattern String");
		String patternString = scanner.nextLine();
		System.out.println("Enter the dictonary words");
		String dictionaryWords=scanner.nextLine();
		StringPatternMatcher stringPatternMatcher=new StringPatternMatcher();
		String pattern=stringPatternMatcher.getPattern(patternString);
		StringTokenizer stringTokenizer=new StringTokenizer(dictionaryWords);
		while(stringTokenizer.hasMoreTokens())
		{
			String currentWord=stringTokenizer.nextToken();
			if(stringPatternMatcher.doesWordMatchPattern(pattern, currentWord))
			{
				System.out.println(currentWord);
			}
		}
				
	}

	public boolean doesWordMatchPattern(String pattern,String word)
	{
		if(pattern.equals(getPattern(word)))
		{
			return true;
		}
		return false;
	}
	public String getPattern(String pattern)
	{
		int counter=0;
		Map<Character,Integer> patternMap=new HashMap<>();
		StringBuilder patternBuilder=new StringBuilder();
		for(Character patternCharacter:pattern.toCharArray())
		{
		if(patternMap.containsKey(patternCharacter))
		{
			patternBuilder.append(patternMap.get(patternCharacter));
		}
		else
		{
			patternMap.put(patternCharacter, ++counter);
			patternBuilder.append(counter);
		}
		}
		return patternBuilder.toString();
	}
}
