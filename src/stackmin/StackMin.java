package stackmin;

import pack.LinkedLists;

public class StackMin {
	
	public LinkedLists stack;
	public LinkedLists stackMin;
	
	public StackMin()
	{
		stack = new LinkedLists();
		stackMin = new LinkedLists();
	}
	
	public StackMin(int initialData)
	{
		stack = new LinkedLists();
		stack.preappend(initialData);
		stackMin.preappend(initialData);
	}
    
	public int length()
	{
		return stack.count;
	}

	public boolean isEmpty()
	{
		return stack.head == null || stack.tail == stack.head || stack.count == 0;
	}
    
    public void push(int data)
    {
        stack.preappend(data);
        
        if(this.isEmpty())
        {
        	stackMin.preappend(data);
        }
        else if(data < stackMin.head.payload)
        {
        	stackMin.preappend(data);
        }
    }
    
    public int pop()
    {
    	int poppedItem = stack.head.payload;
    	stack.removeAt(0);
    	
    	if(poppedItem == stackMin.head.payload)
    	{
    		stackMin.removeAt(0);
    	}
    	
        return poppedItem;
    }
    
    public int peek()
    {
    	return stack.head.payload;
    }
    
    public int getMin()
    {
    	return stackMin.head.payload;
    }
}