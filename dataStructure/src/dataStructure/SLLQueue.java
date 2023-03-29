package dataStructure;
import java.util.NoSuchElementException;

public class SLLQueue <E> {
	private Node <E> front, rear;
	private int size;
	
	public SLLQueue() {
		front = rear = null;
		size  = 0;
	}
	
	public int getSize () {return size;}
	public boolean isEmpty() { return size == 0;}
	
	public void add (E newItem) {
		Node<E> newNode = new Node<E> (newItem, null);
		if(isEmpty()) front = newNode;
		else rear.setNode(newNode);
		
		rear = newNode;
		size++;
	}
	
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();
		
		E frontItem = front.getItem();
		front = front.getNext();
		
		size--;
		if(isEmpty()) rear = null;
		
		return frontItem;
	}
}
