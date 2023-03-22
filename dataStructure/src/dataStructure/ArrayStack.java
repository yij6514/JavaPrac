package dataStructure;

import java.util.EmptyStackException;

public class ArrayStack <E> extends DynamicArrList <E>{
	private int top = getSize();
	
	public void push(E item) {
		insertLast(item);
	}
	
	public E peek() {
		if(isEmpty()) throw new EmptyStackException();
		return peek(top-1);
	}
	
	public E pop() {
		E tmp = peek(top-1);
		if(isEmpty()) throw new EmptyStackException();
		delete(top-1);
		return tmp;
	}
	
}
