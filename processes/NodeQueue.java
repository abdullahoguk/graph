package processes;

public class NodeQueue<E> implements Queue<E> {
	protected Node<E> head;
	protected Node<E> tail;
	protected int size; // number of elements in the queue

	public NodeQueue() { // constructs an empty stack
		head = null;
		tail = null;
		size = 0;
	}

	public void enqueue(E elem) {
		Node<E> node = new Node<E>();
		node.setElement(elem);
		node.setNext(null); // node will be new tail node
		if (size == 0)
			head = node; // special case of a previously empty queue
		else
			tail.setNext(node); // add node at the tail of the list
		tail = node; // update the reference to the tail node
		size++;
	}

	public E dequeue() throws EmptyQueueException {
		if (size == 0)
			throw new EmptyQueueException("Queue is empty.");
		E tmp = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null; // the queue is now empty
		return tmp;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E front() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException("Queue is empty.");
		return head.getElement();
	}

	public String toString() {
		Node<E> temp = head;

		String s;
		s = "[";

		for (int i = 1; i <= size(); i++) {
			if (i == 1)
				s += temp.getElement();
			else
				s += ", " + temp.getElement();
			temp = temp.getNext();
		}

		return s + "]";
	}

}