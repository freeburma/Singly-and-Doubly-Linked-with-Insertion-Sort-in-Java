/*
 	Project Name 	: Assignment2 - Insertion Sorting with Singly and Doubly Linked List
 
 	Date 			: 21-Aprl-2015 
 */

/*
 	SinglyLinkedList class will point the object one after another
 	as a chain. The current object will remember only the next
 	item in the list. 
 	
 	This can go forward only. 
 */
public class SinglyLinkedList 
{
	private Node head; 			// Head Item
	private Node tail;			// Tail Item
	private Node sortedHead ; 	// Sorted Head
	private Node sortedTail ; 	// Sorted Tail
	
	
	private int countFrequency; 	// Counting the number of comaprison
	
	/*
	 	Constructor - will define the object which is created form 
	 	class.
	 */
	 public SinglyLinkedList ()
	 {
		head = null; 
		tail = null;
		sortedHead = null; 
		sortedTail = null; 
		
	 }
	
	// **** Start Orignal List *****
	
	/**
	 	This method will add to the original singly linked list
	 * @param key - the value of the integers for the list
	 */
	public void add (int key)
	{
		
		
		if (head == null)
		{
			head = new Node (key, head); 
			tail = head; 
		}
		else 
		{
			tail.next = new Node (key, null); 
			tail = tail.next;
		}
		
		
	}
	
	/**
	 	This method will delete the head node of the original list
	 */
	public void deleteHeadNode ()
	{
		if (head != null)
		{
			head = head.next; 
		}
		else
			System.out.println("\nThe Original List is empty....\nNothing to delete."); 
	}
	
	// **** End Orignal List *****
	
	/**
	 This will count the number of comparison 
	 * @return	- Original Integer value
	 */
	public int countComparion ()
	{
		return countFrequency ++;
	}
	
	// **** Start Sorted List *****
	
	
	/**
	 	This will get the items from draft linked list
	 * @param key	- Integer Key
	 */
	
	public void addSort (int key)
	{
		if (sortedHead == null)
		{
			sortedHead = new Node (key, sortedHead);
			sortedTail = sortedHead; 
		}
		
		else
		{
			sortedTail.next = new Node (key, null);
			sortedTail = sortedTail.next; 
		}
	}
	

	/**
	 	This will add the draft linked list to final linked list. 
	 	This will remove the head item of the linked list and insert 
	 	it to the list. 
	 */
	private void add ()
	{
		Node tmp = head; 
		
		// Removing the head item by the end of the finish,  
		// the head item will be empty after the loop
		while (tmp != null)
		{
			// This method will delete the head node
			deleteHeadNode (); 
			// Putting the list to the draftSortedList
			addSort (tmp.key); 
			
			tmp = tmp.next;
		}// End while
	}
	
	/**
	 	This will sort the entire linked list 
	 */
	public Node iSort (Node headPosition)
	{
		
		// Checking the empty list. 
		if (headPosition == null || headPosition.next == null)
			return headPosition; 
			
		
		Node newHead = new Node (headPosition.key); 
		Node current = headPosition.next; 
		
		// Looping through each element in the list 
		while (current != null)
		{
			// Counting the comparsion times
			countFrequency ++;
			
			// Insert this element to the new List 
			 
			Node innerCurrentNode = newHead; 
			Node next = current.next; 
			
			if (current.key <= newHead.key)
			{
				// Counting the number of comparison
				countFrequency ++;
				
				// Swap the node between the previous node and current
				Node oldHead = newHead; 
				newHead = current; 
				newHead.next = oldHead; 
			}
			else
			{
				// Checking the entire list
				while (innerCurrentNode.next != null)
				{
					// Counting the comparison times
					countFrequency ++;
					
					/*
					    Checking the previous Node and current Node.
					 	If the current node is greather and equal to adjacent nodes,
					 	this will insert the node in between. 
					 */
					if (current.key > innerCurrentNode.key && current.key <= innerCurrentNode.next.key)
					{
						// Counting the number of comparison
						countFrequency ++;
						// Swaping the adjacent nodes 
						
						Node oldNext = innerCurrentNode.next; 
						innerCurrentNode.next = current; 
						current.next = oldNext; 
					}
					
					innerCurrentNode = innerCurrentNode.next; 
				}// End while
				
				
				// Checking the for the biggest node and insert it to the end of the list
				if (innerCurrentNode.next == null && current.key > innerCurrentNode.key)
				{
					// Counting the number of comparison
					countFrequency ++;
					
					innerCurrentNode.next = current; 
					current.next = null; 
				}
				
				
			}
			
			current = next; 
			
		}// End While 
		
		return newHead; 
			
		
	
	}
	
	
	// **** End Sorted List *****
	/**
 	This will sort the entire linked list by calling the iSorted. 
 	This will pass the linkedList as object.
 */
	public void iSort ()
	{
		
		// Removing the head item and adding to to linked list
		add (); 
		
		Node node = iSort (sortedHead);
		sortedHead = node; 
		
		
	}
	
	/**
	 	Printing the sorted linked list
	 */
	public void prettyPrint ()
	{
		Node tmp = sortedHead; 
		
		// Removing the head item by the end of the finish,  
		// the head item will be empty after the loop
		while (tmp != null)
		{
			
			System.out.println(tmp.key ); 
			
			// Going to next node
			tmp = tmp.next;
		}// End while
	}
	
	
	
	
	
}
