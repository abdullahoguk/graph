package processes;

/** 
 * Interface for a linked list
 */

public interface LinkedList<E> {

	//add new node to the beginning of the list
	public void addFirst(E newElement);
	
	//add new node to the end of the list
	public void addLast(E newElement);
	
	//remove the first node of the list and return its element
	public E removeFirst();
	
	//remove the last node of the list and return its element
	public E removeLast();
	
	//search the list for the given search key and return its index
	public int searchList(E searchKey);
	
	//print the elements of the list
	public void printList();

	//return the number of items in the list
	public int size();

	//return if the list is empty
	public boolean isEmpty();

}
