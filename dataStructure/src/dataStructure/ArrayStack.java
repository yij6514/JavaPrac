package dataStructure;

import java.util.EmptyStackException;

public class ArrayStack <E> extends DynamicArrList <E>{
	
	public ArrayStack() {
		super();
	}
	
	public void push(E item) {
		insertLast(item);
	}
	
	public E peek() {
		if(isEmpty()) throw new EmptyStackException();
		return peek(size - 1);
	}
	
	public E pop() {
		E tmp = peek(size-1);
		if(isEmpty()) throw new EmptyStackException();
		delete(size-1);
		return tmp;
	}
	
}
