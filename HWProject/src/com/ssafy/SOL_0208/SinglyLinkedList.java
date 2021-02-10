package com.ssafy.SOL_0208;

public class SinglyLinkedList {
	private Node head;
	
	public void addFirstNode(String data) {
		Node newNode = new Node(data, head);
		head = newNode;
	}
	
	public Node getLastNode() {
		Node currNode = head;
		if (currNode != null) {
			while (currNode.link != null) {
				currNode = currNode.link;
			}
		}
		
		return currNode;
	}
	
	public void addLastNode(String data) {
		if (head == null) {
			addFirstNode(data);
			return;
		}
		
		Node lastNode = getLastNode();
		Node newNode = new Node(data);
		lastNode.link = newNode;
	}
	
	public void insertAferNode(Node preNode, String data) {
		if (preNode == null) {
			System.out.println("���� ��尡 ���� ������ �Ұ��մϴ�.");
			return;
		}
		
		Node newNode = new Node(data, preNode.link);
		preNode.link = newNode;
	}
	
	// �츮�� ���ϴ� ��带 �տ������� Ž���ؼ� ã�� (�̰Ŵ� �ʿ�!)
	public Node getNode(String data) {
		for (Node currNode = head; currNode != null; currNode = currNode.link)
			if (currNode.data.equals(data))
				return currNode;
		return null;
	}
	
	public Node getPreviousNode(Node target) {
		Node currNode = head, nextNode = null;
		if (currNode != null) {
			// �ڽ��� ������ũ�� null�� �ƴϰ�
			while((nextNode = currNode.link) != null) {
				if (nextNode == target)
					return currNode;
			}
			currNode = nextNode;
		}
		
		return null;
	}
	
	public void deleteNode(String data) {
		if (head == null) {
			System.out.println("빈 리스트 입니다");
			return;
		}
		Node targetNode = getNode(data);
		if (targetNode == null) return;
		
		Node preNode = getPreviousNode(targetNode);
		
		// ������� �ϴ� ����� ������尡 ���� �ڱ��ڽ��� ù��° Node�϶�, ��带 �ڷ� �Ѱ���
		if (preNode == null && targetNode == head)
			head = targetNode.link;
		else preNode.link = targetNode.link;
		
		targetNode.link = null;
	}
	
	public void printList() {
		System.out.print("L = (");
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data+ " ");
		}
		System.out.println(" )");
	}
}
