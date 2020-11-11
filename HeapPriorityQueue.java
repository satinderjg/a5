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
		
		while(hasLeftChild(index)){
			// If there is a child 
			int smaller_child_i = getLeftIndex(index);
			int rt_child_i = getRightIndex(index);


			if( (hasRightChild(index)) && (storage[smaller_child_i].compareTo(storage[rt_child_i])>0 ) ){
				// if it has rt child and rt is smaler than left 
				smaller_child_i = rt_child_i;
			}

			if(storage[index].compareTo(storage[smaller_child_i]) >=0){
				// parent with kid elemet 
				swap(index,smaller_child_i); 
			}else{
				// kids have smaller value no need to continue code
				return;
			}

			index = smaller_child_i;

		}		

		/*
		int lt_child_i = getLeftIndex(index);

		int rt_child_i = getRightIndex(index);

		if(index >=currentSize){
			return;
		}
		if(!hasLeftChild(index)){
			System.out.println("no left child");
			return;
		}
		Comparable lt_kid = this.storage[lt_child_i];
		Comparable rt_kid = this.storage[rt_child_i];

		//first.compareTo(secound) <0
		if(is_first_index_smaller(rt_child_i,lt_child_i) && is_first_index_smaller(lt_child_i,index)){
			swap(lt_child_i,index);
			bubbleDown(lt_child_i);
		}

		if(is_first_index_smaller(lt_child_i,rt_child_i) && is_first_index_smaller(rt_child_i,index)){
			swap(rt_child_i,index);
			bubbleDown(rt_child_i);
		}

		

		if(lt_kid.equals(rt_kid)){
			if(is_first_index_smaller(lt_child_i,index)){
				swap(lt_child_i,index);
				bubbleDown(lt_child_i);
			}
		}
*/
		
	}



	private boolean is_first_index_smaller(int index1,int index2){
		// this is the shady part of code 
		// this works well but I don't know how 
		Comparable first = this.storage[index1];
		Comparable secound = this.storage[index2];

		if(first.compareTo(secound) <0){
			//bigger.compariedto(smaller) 
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
		if(is_first_index_smaller(index,parent_index)){
			//7.compareto(4) <0
			swap(parent_index,index);
			bubbleUp(parent_index);
		}
	}


	 public void insert(Comparable element){
	 	// this works perfectly 
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
	 	
	 	
	 	Comparable head = storage[1];
	 	swap(1,currentSize);
	 	currentSize--;

	 	// if(currentSize ==2){
	 	// 	return head;
	 	// }

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
		for(int i=1;i<=currentSize;i++) {
			s+= sep + storage[i];
			sep = " ";
		}
		return s;
	}

	/*
		Extra helper funtions 
	*/
	protected int getLeftIndex(int i) {
        return i * 2;
    }
    

	protected boolean hasLeftChild(int i) {
        return getLeftIndex(i) <= currentSize;
    }

    protected int getRightIndex(int i) {
        return i * 2 + 1;
    }
    
    
    
    
    
    protected boolean hasRightChild(int i) {
        return getRightIndex(i) <= currentSize;
    }


}
