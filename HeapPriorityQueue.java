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
    //Min heap
	protected final static int DEFAULT_SIZE = 10000;

	protected Comparable[] storage;
	protected int currentSize;

	private void swap(int index_from,int index_to){
		Comparable temp = this.storage[index_from];
		this.storage[index_from]= this.storage[index_to];
		this.storage[index_to]= temp;
	}

	private void bubbleDown(int index){

	}
	private void bubbleUp(int index){
		if(index==1){
			//top most
			return;
		}
		int parent_index=(int)Math.floor(index/2);
		Comparable parent = this.storage[parent_index].getElement();
		Comparable kid = this.storage[index].getElement();
		//if(storage[parent_index].getElement().compareTo(storage[index] <0){
		if(parent.compareTo(kid) <0){
			//7.compareto(4) <0
		
			swap(parent_index,index);
			bubbleUp(parent_index);
		}else{
			// if it is == or smaller
			return;
			}
	}


	 public void insert(Comparable element){
	 	if(currentSize==DEFAULT_SIZE){
	 			throw new HeapFullException("Cannot insert heap is full!");
	 	}
	 	// very first element
	 	
		if(currentSize==0){
			currentSize++;
			storage[currentSize]=element;
			return; //exit this methord right away
		}
		currentSize++;
		storage[currentSize]=element;
		// swap last and frist element //not in this on this will usefull in del 
		//swap(1,currentSize);

		// new element is at top of heap now bubbleUp!
		bubbleUp(currentSize);



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
