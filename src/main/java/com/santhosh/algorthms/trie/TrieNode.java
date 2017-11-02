package com.santhosh.algorthms.trie;

public class TrieNode {
	
	final int TRIE_SIZE=26;
	private final TrieNode[] childNodes=new TrieNode[TRIE_SIZE];
	private boolean isLastNode=false;
	private int count=1;
	
	public boolean isLastNode() {
		return isLastNode;
	}
	public void setLastNode(boolean isLastNode) {
		this.isLastNode = isLastNode;
	}
	public TrieNode[] getChildNodes() {
		return childNodes;
	}
	public int getCount() {
		return count;
	}
	public void incrementCount() {
		++count;
	}
}
