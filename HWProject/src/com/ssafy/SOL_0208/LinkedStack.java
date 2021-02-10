package com.ssafy.SOL_0208;

class node {
	String data;
	node next;

	public node(String data, node next) {
		this.data = data;
		this.next = next;
	}
}

public class LinkedStack {
	node first;
	public LinkedStack() {
		this.first = new node("first",null);
	}
	public void push(String s) {
		node temp = first;
		while(temp.next!=null)
			temp = temp.next;
		temp.next = new node(s,null);
	}

	public String peek() {
		node temp = first;
		while(temp.next!=null)
			temp = temp.next;
		return temp.data;
		
	}

	public String pop() {
		node temp = first;
		node temp2 =first.next;
		while(temp2.next!=null){
			temp = temp.next;
			temp2 = temp.next;
		}
		temp.next=null;
		return temp2.data;
		
	}
	public void printList() {
		System.out.print("L = (");
		for (node currNode = first; currNode != null; currNode = currNode.next) {
			System.out.print(currNode.data+ " ");
		}
		System.out.println(" )");
	}

	public static void main(String[] args) {
		LinkedStack listStack = new LinkedStack();

		System.out.println("### push ###");
		listStack.push("1");
		listStack.push("2");
		listStack.push("3");
		listStack.push("4");
		listStack.push("5");
		listStack.push("6");
		listStack.printList();

		System.out.println("### peek ###");
		System.out.println(listStack.peek());

		System.out.println("### pop ###");
		System.out.println(listStack.pop());
		System.out.println(listStack.pop());
		System.out.println(listStack.pop());
	}
}