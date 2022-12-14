package pack;

public class DNode {
	
	//DNode for Doubly Linked Node
	public int payload;
	public DNode next;
	public DNode prev;
	
	DNode(int payload)
	{
		this.payload = payload;
		this.next = null;
		this.prev = null;
	}
}
