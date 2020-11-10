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
		// Smaller number should go up
		// Bigger number go down
		int lt_child_i = 2*(index);
		int rt_child_i = 2*(index)+1;

		if(index >=currentSize){
			return;
		}
		// which of both child is bigger, or bigger and longer in q
		if(is_first_index_bigger(lt_child_i,rt_child_i)){
			//rt kid < than left
			//check if parent > rt kid
			if(is_first_index_bigger(index,rt_child_i)){
			// parent is > than rt kid becouse smaller number should go up
			// swap rt child with parentNode
			swap(rt_child_i,index);
			bubbleDown(rt_child_i);
			}

		}else{
			// lt kid is smaller than rt or == and in the q for longer time prediod.
			if(is_first_index_bigger(index,lt_child_i)){
				swap(lt_child_i,index);
				bubbleDown(lt_child_i);
			}
		}


	}

	private boolean is_first_index_bigger(int index1,int index2){

		Comparable first = this.storage[index1];
		Comparable secound = this.storage[index2];

		if(first.compareTo(secound) <0){
			// 7.compairedTo(4)
			return true;
		}else{
			// smaller or == i.e longer in q
			return false;
		}
		
	}
	private void bubbleUp(int index){
		// smaller number should go and bigger go down
		if(index==1){
			//top most
			return;
		}
		int parent_index=(int)Math.floor(index/2);
		//Comparable parent = this.storage[parent_index];
		//Comparable kid = this.storage[index];
		//if(storage[parent_index].getElement().compareTo(storage[index] <0){
		if(is_first_index_bigger(index,parent_index)){
			//7.compareto(4) <0
			swap(parent_index,index);
			bubbleUp(parent_index);
		}
	}


	 public void insert(Comparable element){
	 	int l = storage.length;
	 	if(currentSize==l-1){
	 			throw new HeapFullException("Cannot insert heap is full!");
	 	}
	 	//System.out.println(currentSize);
		this.currentSize++;
		storage[currentSize]=element;

		// new element is at top of heap now bubbleUp!
		bubbleUp(currentSize);
	 }

	 public Comparable removeMin(){
	 	// no element
	 	if(currentSize==0){
	 		throw new HeapEmptyException("Heap is empty Cannot removeLow");
	 	}
	 	//if only one element 
	 	if(currentSize ==1){
	 		currentSize--;
	 	}
	 	Comparable head = storage[1];
	 	swap(1,currentSize);
	 	currentSize--;

	 	bubbleDown(1);

	 	return head;
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
		storage = new Comparable[s+1];
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
		for(int i=0;i<=currentSize;i++) {
			s+= sep + storage[i];
			sep = " ";
		}
		return s;
	}

}
