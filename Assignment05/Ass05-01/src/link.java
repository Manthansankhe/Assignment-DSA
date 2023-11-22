
public class link {
	static class Node{
		private int data;
		private Node next;
		private Node prev;
		
		public Node(int value) {
			data = value;
			prev = next = null;
		}
	}
	private Node head;
	
	public link() {
		head = null;
	}
		public boolean isEmpty() {
			return head == null;
		}
		
		public void addFirst(int value) {
			//1. create node
			Node nn = new Node(value);
			//2. if list is empty
			if(isEmpty()) {
				//a. add newnode into head
				head = nn;
				//b. make list circular
				head.next = nn;
				head.prev = nn;
			}
			//3. if list is not empty
			else {
				//a. add first node into next of newnode
				nn.next = head;
				//b. add last node into prev of newnode
				nn.prev = head.prev;
				//c. add newnode into next of last node
				head.prev.next = nn;
				//d. add newnode into prev of first node
				head.prev = nn;
				//e. move head on newnode
				head = nn;
			}
		}
		
		public void addPosition(int value,int pos) {
			Node nn = new Node(value);
			if(pos == 1 && head==null) {
				head = nn;
				nn.next=nn;
				nn.prev  = nn;
			}
//			else if(pos ==1 && head!=null) {
//				Node trav = head;
//				nn.prev = trav.prev;
//				nn.next = trav;
//				trav.prev = nn;
//				trav.next.prev = nn;
//			}
			else {
				Node trav = head;
				for(int i=1; i<pos-1;i++ ) 
					trav = trav.next;
				nn.prev = trav;
				nn.next = trav.next;
				trav.next.prev = nn;
				trav.next = nn;
			}
		}
		public void deletePosition(int value,int pos) {			
			if(head==null) {
				System.out.println("List is Empty");
			}
			else if(head.next == null) {
				head = null;
			}
			else {
				Node trav = head;
				for(int i=1;i<pos;i++) 
					trav = trav.next;
				trav.prev.next =trav.next;
				trav.next.prev=trav.prev;
			}
			
		}
		public  void display() {
			Node trav = head;
			System.out.print("Forward List : ");
			do {
				System.out.print(" " + trav.data);
				trav = trav.next;
			}while(trav.next != head);
			System.out.println(" "+trav.data);
		}
		
	

}
