/*
 	Project Name 	: Assignment2 - Insertion Sorting with Singly and Doubly Linked List
 	
 	Date 			: 21-Aprl-2015 
 */

public class Node 
{
	public Node prev; 
	public Node next; // Next node Node from current pointer
	
	public int key; 	// Integer value for linked list
	
	
	// This is for singly linked list
	
	public Node (int key, Node next)
	{
		this.key = key;
		this.next = next; 
	}
	
	
	/*
		This Class will add the first node
	 	Head and Tail are pointing to only one node becasue 
		it has only one item in the list.
	*/
	public Node (int key)
	{
		this.key = key; 
		next = null; 
		
		//this (key, null); 	// Calling the sister method above  
		
	}
	
	
}
