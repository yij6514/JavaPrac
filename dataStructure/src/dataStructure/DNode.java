package dataStructure;

public class DNode <E> {
	private E item;
	private DNode <E> previous;
	private DNode <E> next;
	
	public DNode (E newitem, DNode <E> p, DNode <E> n) {
		item = newitem;
		previous = p;
		next = n;
	}
	
	public E getItem() {return item;}
	public DNode <E> getPrevious() {return previous;}
	public DNode <E> getNext() {return next;}
	public void setItem(E newitem) { item = newitem;}
	public void setNext(DNode <E> newNode) {next = newNode;}
	public void setPrevious(DNode <E> newNode) {previous = newNode;}
	
}
