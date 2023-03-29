package dataStructure;
import java.util.*;

public class BinaryTree <Key extends Comparable<Key>>{
	private TNode<Key> root;
	
	public BinaryTree() {root = null;}
	
	public TNode <Key> getRoot() {return root;}
	public void setRoot(TNode<Key> newroot) {root = newroot;}
	public boolean isEmpty() {return root == null;}
	
}
