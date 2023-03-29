package dataStructure;

public class TNode <Key extends Comparable<Key>>{
	private Key item;
	private TNode<Key> left;
	private TNode<Key> right;
	
	public TNode(Key newItem, TNode<Key> lt, TNode<Key> rt) {
		item = newItem;
		left = lt;
		right = rt;
	}
	
	public Key getKey() {return item;}
	public TNode<Key> getLeft(){return left;}
	public TNode<Key> getRight(){return right;}
	
	public void setKey(Key newItem) {item = newItem;}
	public void setLeft(TNode<Key> newlf) {left = newlf;}
	public void setRight(TNode<Key> newrt) {right = newrt;}
}
