package pack;

public class LinkedLists {
	
	public LNode head;
	public LNode tail;
	public int count = 0;
	
	public LinkedLists()
	{
		this.head = null;
		this.count = 0;
	}
	
	public LinkedLists(int initialData)
	{
		this.head = new LNode(initialData);
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
        LNode newNode = new LNode(data);
        if(this.count == 0 || this.head == null)
        {
            this.head = newNode;
            this.tail = newNode;
        }
        else
        {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.count++;
    }
    
    public void preappend(int data)
    {
        LNode newNode = new LNode(data);
        if(this.head == null)
        {
            this.head = newNode;
            this.tail = newNode;
        }
        else
        {
            newNode.next = this.head;
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
            LNode currNode = this.head;
            LNode preNode = currNode;
            currNode = currNode.next;
            for(int i = 1; i < position; i++)
            {
            	preNode = currNode;
                currNode = currNode.next;
            }
            LNode newNode = new LNode(data);        

            newNode.next = currNode;
            preNode.next = newNode;
            this.count++;
        }
        
    }
    
    public boolean removeAt(int position)
    {
        LNode currNode = head;
        
        if(position >= this.count || position < 0) //false, out of bounds
        {
            System.out.println("===  ! position is out of bounds");
            return false;
        }
        else if (position == 0) //removes head (0 or 1??)
        {
            LNode nextNode = currNode.next;
            
            this.head = nextNode;
            currNode = this.head;
            this.count--;
            return true;
        }
        else if (position == this.count-1) //removes tail
        {
        	LNode preNode = currNode;
        	currNode = currNode.next;
            for(int i = 1; i < position - 1; i++)
            {
                preNode = currNode;
                currNode = currNode.next;
            }
            this.tail = preNode;
            preNode.next = null;
            this.count--;
            return true;
        }
        else //remove middle node
        {
        	LNode preNode = currNode;
        	currNode = currNode.next;
            for(int i = 1; i < position; i++)
            {
                preNode = currNode;
                currNode = currNode.next;
            }
            preNode.next = currNode.next;
            currNode.next = null;
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
            LNode currNode = this.head;
                        
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
        
        LNode currNode = this.head;
        
        while(currNode != null)
        {
            output = output + currNode.payload + " > ";
            currNode = currNode.next;
        }
        output = output + "/Tail";
        
        System.out.println(output);
    }
    
    public LNode SelectionSort(LNode head) //recursively 
    {
        if(head == null)
        {
//            System.out.println("===== List is empty or end of list reached =====");
            return head;
        }
        
        LNode minNode = head;
        LNode preNode = null;
        LNode i = null;
        for(i = head; i.next != null; i = i.next)
        {
            if(i.next.payload < minNode.payload)
            {
                minNode = i.next;
                preNode = i;
            }
        }
        
        if(minNode != head) //swap nodes
        {
            preNode.next = minNode.next;
            minNode.next = head;
            head = minNode;
            
        }
        
        head.next = SelectionSort(head.next);
        
        return head;
    }
	
}
