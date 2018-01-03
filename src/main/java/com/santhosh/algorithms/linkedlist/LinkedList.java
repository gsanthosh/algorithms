package com.santhosh.algorithms.linkedlist;

/**
 * @author santhosh
 *
 */
public class LinkedList {

	Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void insertData(int data) {
		Node pointer;
		if (head == null) {
			head = new Node(data, null);
			return;
		}
		pointer = head;
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		pointer.next = new Node(data, null);
	}

	public void printList() {
		Node pointer = head;
		while (pointer != null) {
			System.out.print(pointer.data + "->");
			pointer = pointer.next;
		}
		System.out.println();
	}

	public void removeDupicates() {
		if (getHead() == null || getHead().getNext() == null) {
			return;
		}
		Node currentPointer = head;
		Node nextPointer = head.next;
		while (nextPointer != null) {
			if (currentPointer.data != nextPointer.data) {
				currentPointer = nextPointer;
				nextPointer = nextPointer.next;
			} else {
				while (nextPointer != null && currentPointer.data == nextPointer.data) {
					nextPointer = nextPointer.next;
				}
				if(nextPointer!=null) {
					currentPointer.next=nextPointer;	
					currentPointer = nextPointer;
					nextPointer = nextPointer.next;
				}else {
					currentPointer.next=nextPointer;				
				}
			}
		}
	}

	public void sort() {
		if (head == null || head.next == null) {
			return;
		}
		Node jPointer;
		Node iPointer = head;
		while (iPointer != null) {
			jPointer = head;
			int tmp = iPointer.data;
			while (jPointer != iPointer && jPointer.data <= tmp) {
				jPointer = jPointer.next;
			}

			while (jPointer != iPointer) {
				int tmp2 = jPointer.data;
				jPointer.data = tmp;
				tmp = tmp2;
				jPointer = jPointer.next;
			}
			jPointer.data = tmp;
			iPointer = iPointer.next;
		}
	}
	
	public LinkedList alternateSplit() {
		LinkedList secondList = new LinkedList();
		if (this.getHead() == null || this.getHead().getNext() == null) {
			return new LinkedList();
		}
		Node firstListPointer=head;
		
		
		while(firstListPointer!=null)
		{
			Node secondListPointer=firstListPointer.next;
			if(secondListPointer!=null) {
				secondList.insertData(secondListPointer.getData());
				firstListPointer.next=firstListPointer.next.next;
				firstListPointer=firstListPointer.next;
			} else {
				break;
			}
			
		}
		
		return secondList;
	}
	
	public LinkedList mergeList(LinkedList listOne,LinkedList listTwo) {
		LinkedList merged=new LinkedList();
		Node headOne=listOne.getHead();
		Node headTwo=listTwo.getHead();		
		while(headOne!=null && headTwo!=null) {
			if(headOne.data <= headTwo.data) {
				merged.insertData(headOne.data);
				headOne=headOne.next;
			}
			else {
				merged.insertData(headTwo.data);
				headTwo=headTwo.next;
			}
		}
		while(headOne!=null) {
			merged.insertData(headOne.data);
			headOne=headOne.next;
		}
		while(headTwo!=null) {
			merged.insertData(headTwo.data);
			headTwo=headTwo.next;
		}
		return merged;
	}

	public LinkedList splitList() {
		LinkedList secondList = new LinkedList();
		if (this.getHead() == null || this.getHead().getNext() == null) {
			return new LinkedList();
		}
		Node slowPointer = head;
		Node fastPointer = head.getNext();

		while (fastPointer.getNext() != null && fastPointer.getNext().getNext() != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		// even
		if (fastPointer.getNext() == null) {

			secondList.setHead(slowPointer.next);
			slowPointer.next = null;
			return secondList;
		} else {
			secondList.setHead(slowPointer.next.next);
			slowPointer.next.next = null;
		}

		return secondList;

	}
	
	public LinkedList mergeSort(LinkedList list) {
		if(list==null || list.getHead()==null) {
			return null;
		}
		if(list.getHead().getNext()==null) {
			return list;
		}
		LinkedList listTwo=list.splitList();
		LinkedList one=mergeSort(list);
		LinkedList two=mergeSort(listTwo);
		return mergeList(one, two);
		
	}

	class Node {
		int data;
		Node next;

		public Node() {
		}

		public Node(int nodeData, Node nextNode) {
			this.data = nodeData;
			this.next = nextNode;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertData(1);
		list.insertData(2);
		list.insertData(20);
		list.insertData(1);
		list.insertData(231);
		list.insertData(2);
		list.insertData(12);
		list.insertData(4);
		list.insertData(31);
		list.insertData(5);
		//list.removeDupicates();
		//LinkedList secondList=list.alternateSplit();
		list.printList();
		//secondList.printList();
		//list.printList();
		//LinkedList mergedList =list.mergeList(list, secondList);
		//mergedList.printList();
		list=list.mergeSort(list);
		list.printList();
	}

}
