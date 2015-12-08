/*
 	Project Name 	: Assignment2 - Insertion Sorting with Singly and Doubly Linked List
 	
 	Date 			: 21-Aprl-2015 
 */
public class DoublyNode 
{
	public DoublyNode prev; 		// Previous Node from current pointer
	public DoublyNode next; 		// Next node Node from current pointer
	
	// Integer Value to the list
	public int key; 
		
	
	// This will add nodes one after another
	public DoublyNode (int key, DoublyNode next, DoublyNode prev)
	{
		this.key = key; 
		this.next = next; 
		this.prev = prev; 
	}
	
	/*
	This Class will add the first node
 	Head and Tail are pointing to only one node becasue 
	it has only one item in the list.
	 */
	public DoublyNode (int key)
	{
		this (key, null, null); 
	}
	
}
