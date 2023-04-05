package dataStructure;

public class BSTNode <Key extends Comparable<Key>, Value>{
	private Key id;
	private Value name;
	private BSTNode <Key, Value> left,right;
	public BSTNode(Key id, Value name) {
		this.id = id;
		this.name = name;
		left = right = null;
	}
	public Key getKey() {
		return id;
	}
	public void setKey(Key id) {
		this.id = id;
	}
	public Value getValue() {
		return name;
	}
	public void setValue(Value name) {
		this.name = name;
	}
	public BSTNode<Key, Value> getLeft() {
		return left;
	}
	public void setLeft(BSTNode<Key, Value> left) {
		this.left = left;
	}
	public BSTNode<Key, Value> getRight() {
		return right;
	}
	public void setRight(BSTNode<Key, Value> right) {
		this.right = right;
	}
	
}
