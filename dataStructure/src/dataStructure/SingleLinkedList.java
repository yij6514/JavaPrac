package dataStructure;
import java.util.NoSuchElementException;

public class SingleLinkedList <E>{
	protected Node<E> head;
	protected int size;
	
	public SingleLinkedList(){
		head = null;
		size = 0;
	}
	
	public SingleLinkedList(Node<E> newNode) {
		head = newNode;
		size = 1;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int search(E target) {
		Node<E> p = head;
		for(int i = 0; i < size; i++) {
			if(target == p.getItem()) return i;
			p = p.getNext();
		}
		return -1;
	}
	
	public void insertFront(E newItem) {
		head = new Node<E>(newItem, head);
		size++;
	}
	
	public void insertAfter(E newItem, Node<E> p) {
		Node<E> tmp = p.getNext();
		p.setNode(new Node<E>(newItem,tmp));
		size++;
	}
	
	public void deleteFront() {
		if(isEmpty()) throw new NoSuchElementException();
		Node<E> tmp = head.getNext();
		head.setNode(tmp);
		size--;
	}
	
	public void deleteAfter(Node<E> p) {
		if(p == null) throw new NoSuchElementException();
		Node<E> tmp = p.getNext();
		p.setNode(tmp.getNext());
		tmp.setNode(null);
		size--;
	}
	
	public void read() {
		Node<E> tmp = head;
		while(tmp != null) {
			System.out.print(tmp.getItem().toString() + "\t");
			tmp = tmp.getNext();
		}
		System.out.println("");
	}
	
	public int getSize() {
		return size;
	}
}

