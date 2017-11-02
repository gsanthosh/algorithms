/**
 * 
 */
package com.santhosh.algorthms.trie;

/**
 * @author santhosh Class represent a trie data structure.Support basic trie
 *         operations.
 */
public class Trie {

	private final TrieNode root = new TrieNode();
	private final int INITIAL_ROOT_POSITION = 'a';

	public boolean isEmpty() {
		return root.isLastNode();
	}

	/**
	 * Insert the given word into a trie
	 * 
	 * @param word
	 *            - the word to be inserted
	 */
	public void insertWord(String word) {
		if (word == null) {
			return;
		}
		insertWord(word.toCharArray());
	}

	/**
	 * Insert the given word into a trie
	 * 
	 * @param word
	 *            - the word to be inserted
	 */
	public void insertWord(char[] charList) {
		if (isWordEmpty(charList)) {
			return;
		}
		TrieNode node = root;

		for (char c : charList) {
			int pos = c - INITIAL_ROOT_POSITION;
			TrieNode charNode = node.getChildNodes()[pos];
			if (charNode == null) {
				TrieNode childNode = new TrieNode();
				node.getChildNodes()[pos] = childNode;
				node.setLastNode(false);
				node = childNode;
			} else {
				charNode.incrementCount();
				node = charNode;
			}

		}

	}

	/**
	 * Search the given trie for a particular word
	 * 
	 * @param word
	 *            - search the trie for given word
	 * @return
	 */
	public boolean searchWord(String word) {
		if (word == null) {
			return false;
		}

		if (isEmpty()) {
			return false;
		}
		TrieNode crawlNode = root;
		for (char c : word.toCharArray()) {

			int relativePos = c - INITIAL_ROOT_POSITION;
			TrieNode charNode = crawlNode.getChildNodes()[relativePos];
			if (charNode == null) {
				return false;
			}
			crawlNode = charNode;
		}
		return true;
	}

	/**
	 * 
	 * @param charList
	 * @return
	 */
	public int getPrefixCount(String prefix) {
		
		int count=0;
		
		if (prefix == null || prefix.trim().isEmpty()) {
			return 0;
		}

		if (isEmpty()) {
			return 0;
		}
		
		TrieNode crawlNode = root;
		for (char c : prefix.toCharArray()) {
			int relativePos = c - INITIAL_ROOT_POSITION;
			TrieNode charNode = crawlNode.getChildNodes()[relativePos];
			if (charNode == null) {
				return 0;
			}
			
			crawlNode = charNode;
			count=crawlNode.getCount();
		}
		return count;
	}

	private boolean isWordEmpty(char[] charList) {
		if (charList == null || charList.length == 0) {
			return true;
		}
		return false;
	}

}
