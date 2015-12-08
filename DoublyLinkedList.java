/*
 	Project Name 	: Assignment2 - Insertion Sorting with Singly and Doubly Linked List
 	Date 			: 21-Aprl-2015 
 */


/*
 	DoublyLinkedList class will point the object one after another
 	as a chain. The current object will  the next and the previous
 	item in the list. 
 	
 	The list can go either forward or backward.
 */
public class DoublyLinkedList 
{
	private DoublyNode head; 	// Head Item
	private DoublyNode tail; 	// Tail Item
	
	private DoublyNode sortedHead; // Sorted Head
	private DoublyNode sortedTail; // Sorted Tail
	
	private int countFrequency; 	// Counting the number of comaprison
	
	/*
	 	Constructor - will define the object which is created form 
	 	class.
	 */
	public DoublyLinkedList ()
	{
		head = null; 
		tail = null; 
		
		countFrequency = 0; 
	}
	
	/**
	 This will count the number of comparison 
	 * @return	- Original Integer value
	 */
	public int count ()
	{
		return countFrequency; 
	}
	
	/**
 		This method will add to the original singly linked list
	 * @param key - the value of the integers for the list
	 */
	public void add (int num)
	{
		if (head == null)
		{
			tail = new DoublyNode (num);
			head = tail; 
		}
		else 
		{
			tail.next = new DoublyNode (num, null, tail);
			tail = tail.next;
		}
		
	}
	
	/**
		This method will add to the original singly linked list
	 * @param key - the value of the integers for the list
	 */
	public void addDraft (int num)
	{
		if (sortedHead == null)
		{
			sortedTail = new DoublyNode (num);
			sortedHead = sortedTail; 
		}
		else 
		{
			sortedTail.next = new DoublyNode (num, null, sortedTail);
			sortedTail = sortedTail.next;
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
	
	
	/**
	 	This will add the draft linked list to final linked list. 
	 	This will remove the head item of the linked list and insert 
	 	it to the list. 
	 */
	public void add ()
	{
		DoublyNode current = head;
		
		while (current != null)
		{
			// Deleting head node
			deleteHeadNode (); 
			
			addDraft (current.key); 
			current = current.next;
		}
	}

	
	
	/**
 		This will sort the entire linked list 
	 */
	public DoublyNode iSortForward (DoublyNode headPosition)
	{
		// Checking the empty list. 
		if (headPosition == null || headPosition.next == null)
			return headPosition; 
			
		
		DoublyNode newHead = new DoublyNode (headPosition.key); 
		DoublyNode current = headPosition.next; 
		
		// Looping through each element in the list 
		while (current != null)
		{
			// Counting the comparsion times
			countFrequency ++;
			
			// Insert this element to the new List 
			 
			DoublyNode innerCurrentNode = newHead; 
			DoublyNode next = current.next; 
			
			if (current.key <= newHead.key)
			{
				// Counting the number of comparison
				countFrequency ++;
				
				// Swap the node between the previous node and current
				DoublyNode oldHead = newHead; 
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
						
						DoublyNode oldNext = innerCurrentNode.next; 
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
	
	/**
	 	This will sort the entire linked list by calling the iSorted. 
	 	This will pass the linkedList as object.
	 */
	public DoublyNode iSort (DoublyNode headPosition)
	{
		// Checking the empty list. 
			if (headPosition == null || headPosition.next == null)
				return headPosition; 
				
			
			DoublyNode newHead = new DoublyNode (headPosition.key); 
			DoublyNode current = headPosition.next; 
			
			// Looping through each element in the list 
			while (current != null)
			{
				// Counting the comparsion times
				countFrequency ++;
				
				// Insert this element to the new List 
				 
				DoublyNode innerCurrentNode = newHead; 
				DoublyNode next = current.next; 
				
				if (current.key <= newHead.key)
				{
					// Counting the number of comparison
					countFrequency ++;
					
					// Swap the node between the previous node and current
					DoublyNode oldHead = newHead; 
					newHead = current; 
					newHead.next = oldHead; 
				}
				else
				{
					// Reversing the entire list
					while (innerCurrentNode.prev != null)
					{
						// Counting the comparison times
						countFrequency ++;
						
						/*
						    Checking the previous Node and current Node.
						 	If the current node is greather and equal to adjacent nodes,
						 	this will insert the node in between. 
						 */
						if (innerCurrentNode.next != null && current.key > innerCurrentNode.key && current.key <= innerCurrentNode.next.key)
						{
							// Counting the number of comparison
							countFrequency ++;
							// Swaping the adjacent nodes 
							
							DoublyNode oldNext = innerCurrentNode.next; 
							innerCurrentNode.next = current; 
							current.next = oldNext; 
						}
						
						innerCurrentNode = innerCurrentNode.prev; 
					}// End while
					
					
					// Checking the for the biggest node and insert it to the end of the list
					if (innerCurrentNode.prev == null && current.key > innerCurrentNode.key)
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
	
	/**
		Printing the sorted linked list
	 */
	public void iSortForward ()
	{
		// Removing the head item and putting into the list.
		add (); 
		
		
		// Sorting the nodes 
		DoublyNode node = iSortForward (sortedHead);
		sortedHead = node; 
		
		
		
	}
	
	/**
 		Printing the sorted linked list
	 */
	public void iSort ()
	{
		// Removing the head item and putting into the list.
		add (); 
		
		
		// Sorting the nodes 
		DoublyNode node = iSort (sortedHead);
		sortedHead = node; 
		
		
		
	}
	
	/**
 		Printing the sorted linked list
	 */
	public void prettyPrint ()
	{
		DoublyNode tempHead = sortedHead; 

		while (tempHead != null)
		{
			System.out.println(tempHead.key + " ");
			
			// Going to next node
			tempHead = tempHead.next; 
			
		}
		
	}
	
	

}
