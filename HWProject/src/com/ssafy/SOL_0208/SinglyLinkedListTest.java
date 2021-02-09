package com.ssafy.SOL_0208;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addLastNode("������");
		System.out.println(list.getLastNode());
		list.printList();
		
		list.addLastNode("������");
		list.printList();
		
		list.addFirstNode("����ƾ");
		list.printList();
		
		Node preNode = list.getNode("������");
		list.insertAferNode(preNode, "������");
		list.printList();
		
		System.out.println(list.getPreviousNode(list.getNode("������")));
		
		list.deleteNode("������");
		list.printList();
		
		list.deleteNode("����ƾ");
		list.printList();
	}

}
