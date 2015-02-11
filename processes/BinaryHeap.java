package processes;


@SuppressWarnings("rawtypes")
public class BinaryHeap<E extends Comparable>
{
	private static final int DEFAULT_CAPACITY = 10;

 private int currentSize; // Number of elements in heap
 private E [ ] array; // The heap array
	
	
 /**
  * Construct the binary heap.
  */
 public BinaryHeap( )
 {
     this( DEFAULT_CAPACITY );
 }

 /**
  * Construct the binary heap.
  * @param capacity the capacity of the binary heap.
  */
 @SuppressWarnings("unchecked")
public BinaryHeap( int capacity )
 {
     currentSize = 0;
     array = (E[]) new Comparable[ capacity + 1 ];
 }
 
 /**
  * Construct the binary heap given an array of items.
  */
 @SuppressWarnings("unchecked")
public BinaryHeap( E [ ] items )
 {
		currentSize = items.length;
		array = (E[]) new Comparable[ currentSize + 1];

		int i = 1;
		for( E item : items )
			array[ i++ ] = item;
		buildHeap( );
 }
	
	/**
  * Establish heap order property from an arbitrary
  * arrangement of items. Runs in linear time.
  */
 private void buildHeap( )
 {
     for( int i = currentSize / 2; i > 0; i-- )  
         percolateDown( i );
 }

 /**
  * Internal method to percolate down in the heap.
  * @param hole the index at which the percolate begins.
  */
 @SuppressWarnings("unchecked")
private void percolateDown( int hole )
 {
		int child = hole * 2;
		if(child <= currentSize){
			if( child != currentSize &&
					array[ child + 1 ].compareTo( array[ child ] ) < 0 )
				child++;
			if( array[ child ].compareTo( array[hole] ) < 0 ){
				//swap
				E tmp = array[ hole ];
				array[ hole ] = array[ child ];
				array[ child ] = tmp;
				
				percolateDown(child);
			}
		}        
 }
	
	/**
  * Test if the priority queue is logically empty.
  * @return true if empty, false otherwise.
  */
 public boolean isEmpty( )
 {
     return currentSize == 0;
 }
	
	public int size( )
 {
     return currentSize;
 }

 /**
  * Make the priority queue logically empty.
  */
 public void makeEmpty( )
 {
     currentSize = 0;
 }

 /**
  * Insert into the priority queue, maintaining heap order.
  * Duplicates are allowed.
  * @param x the item to insert.
  */
 public void insert( E x )
 {
     if( currentSize == array.length - 1 )
         enlargeArray( array.length * 2 + 1 );

		array[++currentSize] = x;
     // Percolate up       	
     percolateUp(currentSize);
 }
	
	@SuppressWarnings("unchecked")
	private void percolateUp(int hole){
		int parent = hole/2;
		if(parent > 0 && array[hole].compareTo(array[parent]) < 0){
			//swap
			E temp = array[parent];
			array[parent] = array[hole];
			array[hole] = temp;	
			
			percolateUp(parent);
		}
	}


 @SuppressWarnings("unchecked")
private void enlargeArray( int newSize )
 {
		E [] old = array;
		array = (E []) new Comparable[ newSize ];
		for( int i = 0; i < old.length; i++ )
			array[ i ] = old[ i ];        
 }
 
 /**
  * Find the smallest item in the priority queue.
  * @return the smallest item, or throw an UnderflowException if empty.
  */
 public E findMin( )
 {
     if( isEmpty( ) )
         throw new UnderflowException( );
     return array[ 1 ];
 }

 /**
  * Remove the smallest item from the priority queue.
  * @return the smallest item, or throw an UnderflowException if empty.
  */
 public E deleteMin( )
 {
     if( isEmpty( ) )
         throw new UnderflowException( );

     E minItem = findMin( );
     array[ 1 ] = array[ currentSize-- ];
     percolateDown( 1 );

     return minItem;
 }
	
	public boolean remove(E elm){
		//find elm
		int index = -1;
		for(int i = 0; i < size(); i++)
			if(elm.equals(array[i])){
				index = i;
				break;
			}
		
		//if found
		if(index != -1){
			array[index] = array[currentSize--];
			percolateDown(1);
		}
		
		return false;
	}

 public String toString(){
		String result = "[";
		for(int i = 1; i <= currentSize; i++)
			result += " " + array[i];
		result += " ]\n";
		
		return result;
	}	
}
