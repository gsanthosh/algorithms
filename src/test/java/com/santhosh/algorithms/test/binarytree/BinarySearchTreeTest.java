package com.santhosh.algorithms.test.binarytree;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.santhosh.algorthms.binarytree.BinarySearchTree;
import com.santhosh.algorthms.binarytree.Node;
@RunWith(JUnit4.class)
public class BinarySearchTreeTest {
	BinarySearchTree binarySearchTree=null;
	@Before
	public void setUp()
	{
		binarySearchTree=new BinarySearchTree();
	}
	@After
	public void tearDown()
	{
		binarySearchTree=null;
	}
	@Test
	public void testBuildTreeEmpty()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{});
		assertTrue(null==rootNode);
	}
	
	@Test
	public void testBuildTreeRootOnly()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{5});
		assertTrue(rootNode!=null);
		assertEquals(5,rootNode.getData());
		
	}
	
	@Test
	public void testBuildTreeAndInOrderTraversal()
	{
		LinkedList<Node> traversalList=new LinkedList<>();
		Node rootNode=binarySearchTree.buildTree(new int[]{4,5,4,2,7,1,9,3,5,4,6});
		binarySearchTree.inorderTraversal(rootNode, traversalList);
		assertTrue(traversalList!=null);
		assertTrue(!traversalList.isEmpty());
		assertTrue(traversalList.size()==11);
		assertEquals(1,traversalList.get(0).getData());
		assertEquals(2,traversalList.get(1).getData());
		assertEquals(3,traversalList.get(2).getData());
		assertEquals(4,traversalList.get(3).getData());
		assertEquals(4,traversalList.get(4).getData());
		assertEquals(4,traversalList.get(5).getData());
		assertEquals(5,traversalList.get(6).getData());
		assertEquals(5,traversalList.get(7).getData());
		assertEquals(6,traversalList.get(8).getData());
		assertEquals(7,traversalList.get(9).getData());
		assertEquals(9,traversalList.get(10).getData());
	}
	
	@Test
	public void testMaxDepth()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{4,5,4,2,7,1,9,3,5,4,6});
		assertEquals(5,binarySearchTree.maxDepth(rootNode));
	}
	
	@Test
	public void testMaxDepthRoot()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{4});
		assertEquals(1,binarySearchTree.maxDepth(rootNode));
	}
	
	@Test
	public void testMaxDepthEmpty()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{});
		assertEquals(0,binarySearchTree.maxDepth(rootNode));
	}
	
	@Test
	public void testMinValueNullTree()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{});
		assertEquals(0,binarySearchTree.minValue(rootNode));
	}
	
	@Test
	public void testMinValueSingleRoot()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{2});
		assertEquals(2,binarySearchTree.minValue(rootNode));
	}
	
	@Test
	public void testMinValueUnbalancedLeft()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{10,9,8,7,6,5,4,3,2,1});
		assertEquals(1,binarySearchTree.minValue(rootNode));
	}
	
	@Test
	public void testMinValueUnbalancedRight()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{1,2,3,4,5,6});
		assertEquals(1,binarySearchTree.minValue(rootNode));
	}
	
	@Test
	public void testMinValueBalanced()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{4,3,5,2,6,4,5});
		assertEquals(2,binarySearchTree.minValue(rootNode));
	}
	
	@Test
	public void testPrintAllPaths()
	{
		Node rootNode=binarySearchTree.buildTree(new int[]{4,3,5,6,4,7});
		binarySearchTree.printAllPaths(rootNode, new LinkedList<Node>());
	}
	
}

