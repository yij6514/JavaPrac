package dataStructure;
import java.util.NoSuchElementException;

public class DList <E>{
	protected DNode <E> head, tail;
	protected int size;
	
	public DList() {
		head = new DNode<E> (null,null,null);
		tail = new DNode<E> (null,head,null);
		head.setNext(tail);
		size = 0;
	}
	
	public DList(DNode<E> newnode) {
		head = newnode;
		
	}
	
	public void insertBefore (DNode <E> p, E newitem) {
		DNode <E> t = p.getPrevious();
		DNode <E> tmp = new DNode <E> (newitem,t,p);
		p.setPrevious(tmp);
		t.setNext(tmp);
		size++;
	}
	
	public void insertAfter (DNode <E> p, E newitem) {
		DNode <E> t = p.getNext();
		DNode <E> tmp = new DNode<E> (newitem,p,t);
		t.setPrevious(tmp);
		p.setNext(tmp);
		size++;
	}
	
	public void delete(DNode <E> x) {
		if(x == null) throw new NoSuchElementException();
		DNode <E> p = x.getPrevious();
		DNode <E> n = x.getNext();
		p.setNext(n);
		n.setPrevious(p);
		size--;
	}
	
	public void read() {
		DNode <E> tmp = head;
		while(tmp != null) {
			System.out.print(tmp.getItem().toString() + "\t");
			tmp = tmp.getNext();
		}
		System.out.println("");
	}
}
