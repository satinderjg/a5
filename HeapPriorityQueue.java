/*
 * HeapPriorityQueue.java
 *
 * An implementation of a minimum PriorityQueue using a heap.
 * based on the implementation in "Data Structures and Algorithms
 * in Java", by Goodrich and Tamassia
 *
 * This implementation will throw a Runtime, HeapEmptyException
 *	if the heap is empty and removeLow is called.
 *
 * This implementation will throw a Runtime, HeapFullException
 *	if the heap is full and insert is called.
 *
 */

public class HeapPriorityQueue implements PriorityQueue {
    
	protected final static int DEFAULT_SIZE = 10000;

	protected Comparable[] storage;
	protected int currentSize;

	private void swap(int index_from,int index_to){
		Comparable temp = storage[index_from];
		
	}


	 public void insert(Comparable element){
	 	// very first element
		if(currentSize==0){
			currentSize++;
			storage[currentSize]=element;
			return; //exit this methord right away
		}
		currentSize++;
		storage[currentSize]=element;


	 }
	 public Comparable removeMin(){
	 	return null;
	 }
	 public boolean isEmpty(){
	 	return (currentSize==0);	
	 }
	 public int	size (){
	 	return currentSize;
	 }


	/* constructor
	 *
	 * PURPOSE:
	 *  initializes storage to new Comparable[] of DEFAULT_SIZE
	 *      and initializes currentSize to 0
	 *
	 * PARAMETERS:
	 *  none
	 */

	public HeapPriorityQueue(){
		storage = new Comparable[DEFAULT_SIZE];
		currentSize =0;
		storage[0]=null;
	}



	/* constructor
	 *
	 * PURPOSE:
	 *  initializes storage to new Comparable[] of given size
	 *      and initializes currentSize to 0
	 *
	 * PARAMETERS:
	 *  int size
	 */
	public HeapPriorityQueue(int s){
		storage = new Comparable[s];
		currentSize =0;
		storage[0]=null;
	
	}

	
	




	/*
	 * PURPOSE:
	 *    constructs a String representation of the elements in storage
	 *      ordered by their position in storage NOT by priority 
	 *
	 * PARAMETERS:
	 *    None.
	 *
	 * RETURNS:
	 *    String - the String representation
	 *
	 */
	public String toString() {
		String s = "";
		String sep = "";
		for(int i=0;i<currentSize;i++) {
			s+= sep + storage[i];
			sep = " ";
		}
		return s;
	}

}
