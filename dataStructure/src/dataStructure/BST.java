package dataStructure;

public class BST <Key extends Comparable<Key>, Value>{
	public BSTNode<Key, Value> root;
	public BSTNode<Key, Value> getRoot() {return root;}
	public BST(Key newId, Value newName) {
		root = new BSTNode<Key, Value>(newId, newName);
	}
	
}
