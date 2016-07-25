/**
 * 
 */
package com.santhosh.algorthms.binarytree;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author SESA383564
 *
 */
public class BinarySearchTree {
	
	private Node rootNode;
	
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	public BinarySearchTree(int[] nodeData)
	{
		buildTree(nodeData);
	}

	public Node buildTree(int[] nodeData) {
		if(nodeData.length==0)
			return null;
		if(nodeData.length==1)
		{
			rootNode=buildRootNode(nodeData[0]);
		    return rootNode;
		}
		
		rootNode=buildRootNode(nodeData[0]);		
		for(int i=1;i<nodeData.length;i++)
		{
			buildTree(rootNode,nodeData[i]);
		}
		return rootNode;
	}

	public BinarySearchTree() {
		super();
	}

	/**
	 * Create a root node
	 * @param nodeData - root node data
	 * @return root node pointer
	 */
	private Node buildRootNode(int nodeData) {
		rootNode=new Node();
		rootNode.setData(nodeData);
		return rootNode;
	}
	
	/*
	 * Build a tree given root node
	 */
	public void buildTree(Node rootNode,int data)
	{
		if(rootNode==null)
			return;
		//if root node greater than data insertion then left tree
		if(rootNode.getData()>=data)
		{
			//if left node is not null traverse left node
			if(rootNode.getLeftNode()!=null)
			{
				buildTree(rootNode.getLeftNode(), data);
			}
			else
			{
				//create a node and attach it to left node
				Node node=new Node();
				node.setData(data);
				rootNode.setLeftNode(node);
			}
		}
		//data greater than root node
		else
		{
			//if right node is not null traverse right node
			if(rootNode.getRightNode()!=null)
			{
				buildTree(rootNode.getRightNode(), data);
			}
			else
			{
				//create a node and attach it to right node
				Node node=new Node();
				node.setData(data);
				rootNode.setRightNode(node);
			}
			
		}
	}

	/*
	 * Inorder traversal - visit left child first, then root and then right
	 */
	public void inorderTraversal(Node rootNode,LinkedList<Node> traversalList)
	{
		if(rootNode==null)
		{
			return;
		}
		inorderTraversal(rootNode.getLeftNode(),traversalList);
		traversalList.add(rootNode);
		inorderTraversal(rootNode.getRightNode(),traversalList);
	}
	/*
	 *  visit root and then left and right
	 */
	public void preOrderTraversal(Node rootNode)
	{
		if(rootNode==null)
		{
			return;
		}
		System.out.println(rootNode.getData());
		preOrderTraversal(rootNode.getLeftNode());
		preOrderTraversal(rootNode.getRightNode());
	}
	/*
	 * visit left,right and root
	 */
	public void postOrderTraversal(Node rootNode)
	{
		if(rootNode==null)
		{
			return;
		}
		postOrderTraversal(rootNode.getLeftNode());
		postOrderTraversal(rootNode.getRightNode());
		System.out.println(rootNode.getData());
	}

	/**
	 * max depth
	 */
	public int maxDepth(Node rootNode)
	{
		if(rootNode==null)
		{
			return 0;
		}
		int maxLeftNodeDepth=maxDepth(rootNode.getLeftNode());
		int maxRightNodeDepth=maxDepth(rootNode.getRightNode());
		if(maxLeftNodeDepth > maxRightNodeDepth)
		{
			return (1+maxLeftNodeDepth);
		}
		else
		{
			return (1+maxRightNodeDepth);
		}
	}
	
	/*
	 * minValue
	 */
	public int minValue(Node rootNode)
	{
		if(rootNode==null)
		{
			return 0;
		}
		if(rootNode!=null && rootNode.getLeftNode()==null)
		{
			return rootNode.getData();
		}
		else
		{
			return minValue(rootNode.getLeftNode());
		}
	}
	
	/*
	 * Print all paths from root to leaf
	 */
	public void printAllPaths(Node rootNode,LinkedList<Node> nodeList)
	{ 
		//reached the leaf print values
		if(rootNode==null)
		{
			printNodeList(nodeList);
		}
		
		nodeList.add(rootNode);
		
		if(rootNode.getLeftNode()==null && rootNode.getRightNode()==null)
		{
			printNodeList(nodeList);
		}
		else if(rootNode.getRightNode()==null)
		{
			printAllPaths(rootNode.getLeftNode(),new LinkedList<>(nodeList));
		}
		else if(rootNode.getLeftNode()==null)
		{
			
			printAllPaths(rootNode.getRightNode(),new LinkedList<>(nodeList));
		}
		else
		{
			printAllPaths(rootNode.getLeftNode(),new LinkedList<>(nodeList));
			printAllPaths(rootNode.getRightNode(),new LinkedList<>(nodeList));
		}
		
		
	}

	private void printNodeList(LinkedList<Node> nodeList) {
		if(nodeList!=null && !nodeList.isEmpty())
		{
			StringBuilder builder=new StringBuilder();
			for(Node node:nodeList)
			{
				builder.append(node.getData()+" ");
			}
			System.out.println("Path String :  "+builder.toString());
		}
	}
}
