package dataStructure;
import java.util.EmptyStackException;

public class SLLStack <E>{
	private Node <E> top;
	private int size;
	public SLLStack () {
		top = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E peek() {
		if(isEmpty()) throw new EmptyStackException();
		
		return top.getItem();
	}
	
	public void push(E newItem) {
		Node <E> newNode = new Node <E>(newItem, top);
		top = newNode;
		size++;
	}
	
	public E pop() {
		if(isEmpty()) throw new EmptyStackException();
		E topitem = top.getItem();
		top = top.getNext();
		size--;
		return topitem;
	}
}
