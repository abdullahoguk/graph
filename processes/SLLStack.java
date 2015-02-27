package processes;

/** Stack implementation using SLinkedList.*/

public class SLLStack<E> implements Stack<E> {
	protected SLinkedList<E> S;		// Generic list used to implement the stack 
	
	public SLLStack() {
		S = new SLinkedList<E>();
	}
	
	public int size() { 
		return S.size();
	}
	
	public boolean isEmpty() {
		return S.isEmpty();
	}
	
	public void push(E element) {
		S.addFirst(element);
	}
	
	public E top() throws EmptyStackException {
		if (isEmpty())
		  throw new EmptyStackException("Stack is empty.");
		return S.head.getElement();
	}
	
	public E pop() throws EmptyStackException {
		if (isEmpty())
		  throw new EmptyStackException("Stack is empty.");

		return S.removeFirst();
	}
	
	public void printStack(){
		S.printList();
	}

}
