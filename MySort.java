/*
 	Project Name 	: Assignment2 - Insertion Sorting with Singly and Doubly Linked List
 	
 	Date 			: 21-Aprl-2015 
 */


import java.util.Random;	// Importing Random Package



/**
	This class will sort the unsorted linked list to sorted linked list
	by calling the objects.  
*/
public class MySort 
{

	
	public static void main(String[] args) 
	{
		// Creating DoublyLinkedList object
		DoublyLinkedList dLink = new DoublyLinkedList ();
		
		// Creating SinglyLinkedList object
		SinglyLinkedList singleSort = new SinglyLinkedList (); 
		
		// Creating Random object
		Random rnd = new Random (); 
		
		long start = 0; 
		long end = 0; 
		long totalTime = 0; 
		
	
		if (args.length == 2)
		{
			String direction = args [0]; 				// Getting the direction
			int randNum = Integer.parseInt(args [1]); 	// Getting the number of integers
			
			// Calculating the time
			start = System.currentTimeMillis();
			if (direction.toLowerCase().equals("-b") || direction.toLowerCase().equals("b"))
			{
				for(int i=0;i<randNum;i++)
					dLink.add(rnd.nextInt());
				
				dLink.iSort(); 
				dLink.prettyPrint();
				
				// Printing the number of Comparison
				System.out.println("Number of Comparison : " + dLink.count()); 
			}
			else if (direction.toLowerCase().equals("-fb") || direction.toLowerCase().equals("fb"))
			{
				for(int i=0;i<randNum;i++)
					dLink.add(rnd.nextInt());
				
				dLink.iSortForward(); 
				dLink.prettyPrint();
				
				// Printing the number of Comparison
				System.out.println("Number of Comparison : " + dLink.count()); 
			}		
			else if (direction.toLowerCase().equals("-f") || direction.toLowerCase().equals("f"))
			{
				for(int i=0;i<randNum;i++)
					singleSort.add(rnd.nextInt());
				
				singleSort.iSort(); 
				
				singleSort.prettyPrint(); 
				
				// Printing the number of Comparison
				System.out.println("Number of Comparison : " + singleSort.countComparion()); 
			}
			
			
			
			
		}
		else 
		{
			System.out.println();
			System.out.println("\nYou should enter like this.");
			System.out.println("To Print Backward  :  \t <fileName> <-b> <50000> or");
			System.out.println("To Print Forward  :  \t <fileName> <-f> <50000> or");
			System.out.println("To Print Doubly Linked List Forward  :  \t <fileName> <-b> <50000> or");
			System.out.println("Eg. java MySort -f 5000"); 
		}
		
		end = System.currentTimeMillis();	
		totalTime =  end - start; 
			
		System.out.println ("Time to take Inserting Sort : " + totalTime + " ms"); 	
		System.out.println("\n\nProgram Finished ...."); 

		
	
	}

}
