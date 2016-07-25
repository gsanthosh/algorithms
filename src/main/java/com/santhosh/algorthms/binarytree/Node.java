package com.santhosh.algorthms.binarytree;
/*
 * Basic node structure for binary tree
 */
public class Node {

	private int data;
	private Node rightNode;
	private Node leftNode;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
}
