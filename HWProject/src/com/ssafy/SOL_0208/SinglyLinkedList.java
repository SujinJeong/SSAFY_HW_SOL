package com.ssafy.SOL_0208;

public class SinglyLinkedList {
	private Node head;
	
	// ���Ḯ��Ʈ�� ù���� ���ҷ� �����ϱ� (�̰Ŵ� �ʿ�!)
	public void addFirstNode(String data) {
		// ���� ���鸮��Ʈ�̸� null�� �ٱ� ������ �������
		Node newNode = new Node(data, head);
		head = newNode;
	}
	
	// ���Ḯ��Ʈ�� ������ ���� ã�� ��ȯ
	public Node getLastNode() {
		Node currNode = head;
		// null�̸� ���鸮��Ʈ
		if (currNode != null) {
			while (currNode.link != null) {
				currNode = currNode.link;
			}
		}
		
		return currNode;
	}
	
	// ���Ḯ��Ʈ�� ������ ���ҷ� �����ϱ�
	public void addLastNode(String data) {
		// ���鸮��Ʈ�ΰ��
		if (head == null) {
			// �� �տ� �����ϴ� �Ͱ� �Ȱ���
			addFirstNode(data);
			return;
		}
		
		Node lastNode = getLastNode();
		// link�� �������̶� null�̹Ƿ� �������ص� �ȴ�
		Node newNode = new Node(data);
		lastNode.link = newNode;
	}
	
	// �߰���� ����
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
				// target�� �������� ������ �ִ� ��尡 ���� ���!
				if (nextNode == target)
					return currNode;
			}
			// ���ö����� ��� ���󰡾��ϴϱ� �������� ���� ��� �ٲ��ֱ�
			currNode = nextNode;
		}
		
		return null;
	}
	
	// �ش� �����͸� ������ �ִ� ��� ����
	public void deleteNode(String data) {
		if (head == null) {
			System.out.println("���鸮��Ʈ���� ������ �Ұ����մϴ�.");
			return;
		}
		Node targetNode = getNode(data);
		if (targetNode == null) return;
		
		Node preNode = getPreviousNode(targetNode);
		
		// ������� �ϴ� ����� ������尡 ���� �ڱ��ڽ��� ù��° Node�϶�, ��带 �ڷ� �Ѱ���
		if (preNode == null && targetNode == head)
			head = targetNode.link;
		else preNode.link = targetNode.link;
		
		// ���������� ���� ���̻� link�� ���� ���� �ʿ䰡 ����
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
