package processes;

import java.util.*;

// TODO 35-40-135-146 civarýndaki node lara e generic type eklendi hata çýkarsa geri al onu.
/** Singly linked list implementation . */
public class SLinkedList<E> implements LinkedList<E>, Iterable<E> {
	protected Node<E> head; // head node of the list
	protected Node<E> tail; // tail node of the list
	protected int size; // number of nodes in the list

	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(head);
	}

	/** Default constructor that creates an empty list */
	public SLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(E newElement) {
		Node<E> newNode = new Node<E>(newElement, null);
		if (size == 0) // if list is empty
			tail = newNode;

		newNode.setNext(head);
		head = newNode;
		size++;
	}

	public void addLast(E newElement) {
		Node<E> newNode = new Node<E>(newElement, null);

		if (size == 0) // if list is empty
			head = newNode;

		if (size != 0) // if list is not empty
			tail.setNext(newNode);

		tail = newNode;
		size++;
	}

	public E removeFirst() {
		Node<E> tempNode = null;
		if (size != 0) {
			if (size == 1)
				tail = null;

			tempNode = head;
			head = head.getNext();
			tempNode.setNext(null);
			size--;
		}

		// if list is empty then return null
		return tempNode.getElement();

	}

	public E removeLast() {
		Node<E> tempNode = head;

		if (size == 0)
			return null;

		if (size == 1) {
			head = null;
			tail = null;
			size--;
			return tempNode.getElement();
		}

		// size is greater than 1
		for (int i = 1; i <= size - 2; i++) {
			tempNode = tempNode.getNext(); // go to element that before the tail
		}

		Node<E> tempNode2 = tail;
		tail = tempNode;
		tail.setNext(null);
		size--;
		return tempNode2.getElement();

	}

	public void remove(E element) {
		int index = 0;
		boolean found = false;
		Node<E> temp = head;
		for (int i = 1; i <= size; i++) {// find the node with element
			index++;
			if (temp.getElement().equals(element)) {
				found = true;
				break;
			}
			temp = temp.getNext();
		}

		if (found) {
			if (index == 1)
				removeFirst();

			else if (index == size)
				removeLast();

			else {
				// find the previous node
				Node<E> prev = head;
				for (int i = 1; i < index - 1; i++) {
					prev = prev.getNext();
				}

				prev.setNext(temp.getNext());
				temp.setNext(null);
				size--;
			}
		}
	}

	public int searchList(E searchKey) {
		if (size == 0)
			return -1;

		Node<E> tempNode = head;
		for (int i = 1; i <= size; i++) {
			if (tempNode.getElement().equals(searchKey))
				return i; // return index of the node
			tempNode = tempNode.getNext();
		}

		return -1; // not found
	}

	public void printList() {
		Node<E> tempNode = head;
		for (int i = 1; i <= size; i++) {
			System.out.print(tempNode.getElement());
			if (i != size) // if it is not last element
				System.out.print(" - ");
			tempNode = tempNode.getNext();
		}
		System.out.println();

	}

}