package com.ssafy.SOL_0208;

public class SinglyLinkedList {
	private Node head;
	
	// 연결리스트에 첫번쨰 원소로 삽입하기 (이거는 필요!)
	public void addFirstNode(String data) {
		// 만약 공백리스트이면 null이 붙기 때문에 상관없음
		Node newNode = new Node(data, head);
		head = newNode;
	}
	
	// 연결리스트의 마지막 원소 찾아 반환
	public Node getLastNode() {
		Node currNode = head;
		// null이면 공백리스트
		if (currNode != null) {
			while (currNode.link != null) {
				currNode = currNode.link;
			}
		}
		
		return currNode;
	}
	
	// 연결리스트에 마지막 원소로 삽입하기
	public void addLastNode(String data) {
		// 공백리스트인경우
		if (head == null) {
			// 맨 앞에 삽입하는 것과 똑같음
			addFirstNode(data);
			return;
		}
		
		Node lastNode = getLastNode();
		// link은 마지막이라 null이므로 지정안해도 된다
		Node newNode = new Node(data);
		lastNode.link = newNode;
	}
	
	// 중간노드 삽입
	public void insertAferNode(Node preNode, String data) {
		if (preNode == null) {
			System.out.println("선행 노드가 없어 삽입이 불가합니다.");
			return;
		}
		
		Node newNode = new Node(data, preNode.link);
		preNode.link = newNode;
	}
	
	// 우리가 원하는 노드를 앞에서부터 탐색해서 찾기 (이거는 필요!)
	public Node getNode(String data) {
		for (Node currNode = head; currNode != null; currNode = currNode.link)
			if (currNode.data.equals(data))
				return currNode;
		return null;
	}
	
	public Node getPreviousNode(Node target) {
		Node currNode = head, nextNode = null;
		if (currNode != null) {
			// 자신의 다음링크가 null이 아니고
			while((nextNode = currNode.link) != null) {
				// target을 다음노드로 가지고 있는 노드가 이전 노드!
				if (nextNode == target)
					return currNode;
			}
			// 나올때까지 계속 따라가야하니까 다음노드로 지금 노드 바꿔주기
			currNode = nextNode;
		}
		
		return null;
	}
	
	// 해당 데이터를 가지고 있는 노드 삭제
	public void deleteNode(String data) {
		if (head == null) {
			System.out.println("공백리스트여서 삭제가 불가능합니다.");
			return;
		}
		Node targetNode = getNode(data);
		if (targetNode == null) return;
		
		Node preNode = getPreviousNode(targetNode);
		
		// 지우려고 하는 노드의 이전노드가 없고 자기자신이 첫번째 Node일때, 헤드를 뒤로 넘겨줌
		if (preNode == null && targetNode == head)
			head = targetNode.link;
		else preNode.link = targetNode.link;
		
		// 지워지려는 노드는 더이상 link를 물고 있을 필요가 없음
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
