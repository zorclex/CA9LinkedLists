package pack;

public class Main {

	public static void main(String[] args) 
	{
		
		System.out.println("=================\nSingly-linked List test\n=================\n");
		
		//singly linked list
		LinkedLists slist = new LinkedLists(0);
		
//		System.out.println("the current length is " + slist.length());
		slist.append(3);
		slist.append(6);
		slist.append(4);
		slist.traverse();
//		System.out.println("the current length is " + slist.length());
		slist.preappend(7);
		slist.insertAt(16, 1);
		slist.traverse();
		System.out.println("remove is: " + slist.removeAt(5));
		slist.traverse();
		slist.append(8);
		System.out.println("the current length is " + slist.length()); 
		slist.insertAt(60, 8);
		slist.traverse();
		slist.head = slist.SelectionSort(slist.head);
		
		System.out.println("\n=-=-=-=-=--=-=--=-=-=-=-=-=-=-=-=-=");
		slist.traverse();
		
		System.out.println("\n===============================================================================");
		System.out.println("===============================================================================\n");
		
		
		System.out.println("=================\nDoubly-linked List test\n=================\n");

		
		// doubly linked list
		LinkedListsDouble dlist = new LinkedListsDouble();
		int numAt = 2;
		
		dlist.append(3);
		dlist.append(5);
		dlist.append(1);
		dlist.append(4); 
		dlist.append(2);
		dlist.traverse();
		System.out.println("remove is: " + dlist.removeAt(6));
		dlist.traverse();
		dlist.preappend(9);
		dlist.append(8);
		dlist.traverse();
		dlist.insertAt(16, 3);
		System.out.println("teh item at position " + numAt + " is " + dlist.nodeAt(numAt).payload);
		System.out.println("the current list is " + dlist.length() + " long and data 8 is found at position " + dlist.indexOf(8) + " while item 5 is found at " + dlist.indexOf(5));
		dlist.insertAt(72, 3);
		dlist.traverse();
		dlist.BubbleSort();
		
		System.out.println("\n=-=-=-=-=--=-=--=-=-=-=-=-=-=-=-=-=");
		dlist.traverse();
		
		
		//cabbage
	}

}
