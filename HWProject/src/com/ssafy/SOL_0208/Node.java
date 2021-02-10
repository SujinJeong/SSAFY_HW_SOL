package com.ssafy.SOL_0208;

public class Node {
	public String data;
	public Node link;
	
	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}
	public Node(String data) {
		super();
		this.data = data;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	
	
}
