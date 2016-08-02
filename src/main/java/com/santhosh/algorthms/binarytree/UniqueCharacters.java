package com.santhosh.algorthms.binarytree;

import java.util.Scanner;

public class UniqueCharacters {

	private final char[] uniqueCharacterArray;

	public UniqueCharacters(char[] uniqueCharacterArray) {
		this.uniqueCharacterArray = uniqueCharacterArray;
	}

	public boolean isUniqueCharacterInsertionSort() {
		int length = uniqueCharacterArray.length;
		if (length == 1) {
			return true;
		}
		if (length == 2) {
			if (uniqueCharacterArray[0] == uniqueCharacterArray[1]) {
				return false;
			}
			return true;
		}
		for (int i = 0; i < length - 1; i++) {
			char charVal = uniqueCharacterArray[i];
			for (int j = i + 1; j < length; j++) {
				if (charVal == uniqueCharacterArray[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		try (Scanner characterScanner = new Scanner(System.in)) {
			String characterInput = characterScanner.next();
			UniqueCharacters uniqueCharacters = new UniqueCharacters(characterInput.toCharArray());
			System.out.println(uniqueCharacters.isUniqueCharacterInsertionSort());
		}
	}

}
