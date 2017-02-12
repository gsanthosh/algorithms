package com.santhosh.geekforgeek;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.santhosh.algorthms.careercup.string.ReverseString;

public class LongestPalindrome {
	Map<Character,Integer> oddCountMap= new HashMap<>();
	Map<Character,Integer> evenCountMap= new HashMap<>();
	
	private  void assignCharacterCount(String inputString)
	{
		for(Character ch : inputString.toCharArray())
		{
			if(!oddCountMap.containsKey(ch) && !evenCountMap.containsKey(ch))
			{
				oddCountMap.put(ch, new Integer(1));
			}
			else if(oddCountMap.containsKey(ch))
			{
				Integer count=oddCountMap.get(ch);
				int countInt=count.intValue();
				++countInt;
				evenCountMap.put(ch, countInt);
				oddCountMap.remove(ch);
			}
			else if(evenCountMap.containsKey(ch))
			{
				Integer count=evenCountMap.get(ch);
				int countInt=count.intValue();
				++countInt;
				oddCountMap.put(ch, countInt);
				evenCountMap.remove(ch);
			}
		}
	}
	
	public String getLongestPalindrome(String inputString)
	{
		if(inputString==null || inputString.isEmpty())
		{
			//if its an empty string return
			return "";
		}
		//convert all input string to lower
		inputString=inputString.toLowerCase();
		//assign odd and even count
		assignCharacterCount(inputString);
		//extract all even possibilities from odd count map. For example if odd map contains 3 a ,split as 2 a in even map and 
		// one a in odd map.
		for(Entry<Character,Integer> mapEntry:oddCountMap.entrySet())
		{
			int countValue=mapEntry.getValue().intValue();
			if(countValue<2)
				continue;
			int numEvenChars=countValue/2;
			evenCountMap.put(mapEntry.getKey(),numEvenChars*2);
			oddCountMap.put(mapEntry.getKey(), 1);
		}
		//
		String begin="";
		String mid="";
		StringBuilder beginBuilder=new StringBuilder();
		char[] beginCharArray=begin.toCharArray();
		String reversedBeginString=null;
		for(Entry<Character,Integer> mapEntry:evenCountMap.entrySet())
		{
			int countValue=mapEntry.getValue().intValue();
			for(int i=0;i<countValue/2;i++)
			{
				beginBuilder.append(mapEntry.getKey());
			}
		}
		
		begin=beginBuilder.toString();
		beginCharArray=begin.toCharArray();
		ReverseString reverseString=new ReverseString(beginCharArray);
		reversedBeginString=reverseString.getReversedString();
		if(oddCountMap.size()!=0)
		{
			mid=oddCountMap.keySet().iterator().next().toString();
		}

		if(mid==null||mid.trim().isEmpty())
		{
			return begin+reversedBeginString;
		}
		return begin+mid+reversedBeginString;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the palindrome String");
		String palindromeString = scanner.nextLine();
		System.out.println(new LongestPalindrome().getLongestPalindrome(palindromeString));
			
	}
}
