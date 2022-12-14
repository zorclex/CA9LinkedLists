package pack;

public class LinkedListsDouble {
	
	public DNode head;
	public DNode tail;
	private int count = 0;
	
	public LinkedListsDouble()
	{
		this.head = null;
		this.tail = this.head;
		this.count = 0;
	}
	
	public LinkedListsDouble(int initialData)
	{
		this.head = new DNode(initialData);
		this.tail = this.head;
		this.count = 1;
	}
	
	public int length()
	{
		return this.count;
	}

	public boolean isEmpty()
	{
		return this.head == null || this.tail == head || this.count == 0;
	}
	
	public void append(int data)
	{
		DNode newNode = new DNode(data);
		if(this.count == 0 || this.head == null)
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.count++;
	}
	
	public void preappend(int data)
	{
		DNode newNode = new DNode(data);
		if(this.head == null)
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}		
		this.count++;
	}
	
	public void insertAt(int data, int position)
	{
		if (this.isEmpty())
		{
			this.append(data);
		} 
		else if(position == 0) //if head
		{
			this.preappend(data);
		}
		else if(position >= this.count) //if inserted after the tail
		{
			this.append(data);
		}
		else //if middle
		{
			DNode currNode = this.head;

			for(int i = 0; i < position; i++)
			{
				currNode = currNode.next;
			}
			DNode preNode = currNode.prev;
			DNode newNode = new DNode(data);		

			preNode.next = newNode;
			newNode.prev = preNode;
			newNode.next = currNode;
			currNode.prev = newNode;
			this.count++;
		}
		
	}
	
	public boolean removeAt(int position)
	{
		DNode currNode = head;
		
		if(position > this.count || position > 0) //false, out of bounds
		{
			
			System.out.println("position is greated than count : out of bounds");
			return false;
		}
		else if (position == 0) //removes head (0 or 1??)
		{
			DNode nextNode = currNode.next;
			
			this.head = nextNode;
			currNode = this.head;
			nextNode.prev = null;
			this.count--;
			System.out.println("removing Head. Count should now be " + this.count);
			return true;
		}
		else if (position == this.count) //removes tail
		{
			currNode = this.tail;
			currNode.prev.next = null;
			currNode.prev = this.tail;
			currNode.prev = null;
			currNode = null;
			this.count--;
			return true;
		}
		else //remove middle node
		{
			for(int i = 0; i < position; i++)
			{
				currNode = currNode.next;
				System.out.println("curr is node at " + i);
			}
//			System.out.println("currNode(" + currNode + ") is currently: next: " + currNode.next + ", prev: " + currNode.prev);
			DNode preNode = currNode.prev;
			DNode nextNode = currNode.next;
			preNode.next = currNode.next;
			nextNode.prev = currNode.prev;
			currNode.next = null;
			currNode.prev = null;
			currNode = null;
			this.count--;
			return true;
		}
	}
	
	public int indexOf(int data)
	{
		int counter = 0;
		if (this.isEmpty())
		{
			return -1;
		}
		else 
		{
			DNode currNode = this.head;
						
			while(currNode != null && currNode.payload != data)
			{
				counter++;
				if(currNode.payload == data)
				{
					return counter;
				}				
				currNode = currNode.next;			
			}
		}
		return counter;
	}
	
	public void traverse()
	{
		String output ="===Traverse=== Head/";
		
		DNode currNode = this.head;
		
		while(currNode != null)
		{
			output = output + currNode.payload + " > "; // "=" + currNode +  > to check exact pointers
		    currNode = currNode.next;
		}
		output = output + "/Tail";
		
		System.out.println(output);
	}
	
	public DNode nodeAt(int position) //returns the node at position specified
	{
		DNode currNode = this.head;
		for(int i = 0; i < position; i++)
		{
			currNode = currNode.next;
//			System.out.println("curr is node at " + i);
		}
		return currNode;
	}
	
	public void BubbleSort() 
	{		
		boolean changing = true;
		while(changing)
		{

			DNode currNode = this.head;
			DNode nextNode = currNode.next;
			changing = false;
			while(currNode != this.tail)
			{

				if(currNode.payload > nextNode.payload) //swap nodes
				{					
					if(currNode.prev != null)
					{
						nextNode.prev = currNode.prev; //next reaches back
						currNode.prev.next = nextNode;
					}
					else //meaning it is null, and nextNode is the head after swapping
					{
						this.head = nextNode;
						nextNode.prev = null;
					}
					currNode.prev = nextNode;
					
					if(nextNode.next != null)
					{
						currNode.next = nextNode.next; //curr reaches forwards
						nextNode.next.prev = currNode;
					}
					else //meaning it is null, and nextNode is the tail
					{
						this.tail = currNode;
						currNode.next = null;
					}
					nextNode.next = currNode;
    			   
					changing = true;
				}
    		   	else
		   		{
    		   		currNode = nextNode;    			   
    		   	}
    		   	nextNode = currNode.next;
//    		   	this.traverse();
           }
       }
       
       return;
   }
}
