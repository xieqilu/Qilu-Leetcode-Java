
public class Solution {
	//define node class
	private static class Node{
		private int data;
		private Node next = null;
		public Node(int d){
			this.data = d;
		}
	}
	
	//delete method!
	private static Node deleteNode(Node n, int value){
		if(n == null) 
			return null;
		Node head = n;
		Node current = n;
		Node previous = null;
		
		while(current!=null){
			if(current.data == value){
				if(current == head){
					head = head.next;
					current = head;
				}
				else{
					previous.next = current.next;
					current = previous.next;
				}
			}
			else{
				previous = current;
				current = current.next;
			}
		}
		return head;
	}
	
	//display result
	private static void display(Node res){
		if(res == null)
			System.out.print("empty node!");
		while(res!=null){
			if(res.next!=null)
				System.out.print(res.data + "->");
			else
				System.out.print(res.data);
			res = res.next;
		}
		System.out.println();
	}
	
	//test cases
	private static void test(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		Node res = deleteNode(node1,3);
		display(res);
		Node resA = deleteNode(node1,1);
		display(resA);
	}
	
	private static void testA(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(5);
		Node node4 = new Node(5);
		Node node5 = new Node(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		Node res = deleteNode(node1,5);
		display(res);
	}
	
	private static void testB(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(5);
		Node node4 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Node res = deleteNode(node1,5);
		display(res);
	}
	
	private static void testC(){
		Node node1 = new Node(5);
		Node node2 = new Node(5);
		Node node3 = new Node(5);
        Node node4 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Node res = deleteNode(node1,5);
		display(res);
	}
	
	private static void testD(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
        Node node4 = new Node(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Node res = deleteNode(node1,5);
		display(res);
	}
	
	public static void main(String[] args){
		test();
		testA();
		testB();
		testC();
		testD();
	}
}
