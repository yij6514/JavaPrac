package dataStructure;
import java.util.*;

public class BinaryTree <Key extends Comparable<Key>>{
	private TNode<Key> root;
	
	public BinaryTree() {root = null;}
	
	public TNode <Key> getRoot() {return root;}
	public void setRoot(TNode<Key> newroot) {root = newroot;}
	public boolean isEmpty() {return root == null;}
	
	public void preorder(TNode<Key> n) {
		if(n != null) {
			System.out.println(n.getKey() + " ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	public void inorder(TNode<Key> n) {
		if(n != null) {
			preorder(n.getLeft());
			System.out.println(n.getKey() + " ");
			preorder(n.getRight());
		}
	}
	
	public void postorder(TNode<Key> n) {
		if(n != null) {
			preorder(n.getLeft());
			preorder(n.getRight());
			System.out.println(n.getKey() + " ");
		}
	}
	
	public void levelorder(TNode<Key> root) {
		SLLQueue<TNode<Key>> q = new SLLQueue<TNode<Key>>();
		TNode<Key> t;
		q.add(root);
		while(!q.isEmpty()) {
			t = q.remove();
			System.out.println(t.getKey() + " ");
			if(t.getLeft() != null) {
				q.add(t.getLeft());
			}
			if(t.getRight() != null) {
				q.add(t.getRight());
			}
		}
	}
	
	public int size(TNode<Key> n) {
		if(n == null) return 0;
		else return (1 + size(n.getLeft()) + size(n.getRight()));
	}
	
	public int height(TNode<Key> n) {
		if(n == null) return 0;
		else return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
	}
	
	public boolean isEqual(TNode<Key> n, TNode<Key> m) {
		if(n == null || m == null)
			return n == m;
		
		if(n.getKey().compareTo(m.getKey()) != 0)
			return false;
		
		return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
	}
}
