package com.ssafy.SOL_0208;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addLastNode("정수진");
		System.out.println(list.getLastNode());
		list.printList();
		
		list.addLastNode("정투디");
		list.printList();
		
		list.addFirstNode("정투틴");
		list.printList();
		
		Node preNode = list.getNode("정수진");
		list.insertAferNode(preNode, "정수기");
		list.printList();
		
		System.out.println(list.getPreviousNode(list.getNode("정투디")));
		
		list.deleteNode("정수진");
		list.printList();
		
		list.deleteNode("정투틴");
		list.printList();
	}

}
