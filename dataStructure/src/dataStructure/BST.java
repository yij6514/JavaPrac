package dataStructure;

public class BST <Key extends Comparable<Key>, Value>{
	public BSTNode<Key, Value> root;
	public BSTNode<Key, Value> getRoot() {return root;}
	public BST(Key newId, Value newName) {
		root = new BSTNode<Key, Value>(newId, newName);
	}
	
	public Value get(Key k) { return get(root, k);}
	public Value get(BSTNode<Key, Value> n, Key k) {
		if(n == null) return null;
		int t = n.getKey().compareTo(k);
		if(t > 0) return get(n.getLeft(), k);
		else if( t < 0) return get(n.getRight(), k);
		else return (Value) n.getValue();
	}
}
