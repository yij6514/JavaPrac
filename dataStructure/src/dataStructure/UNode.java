package dataStructure;

public class UNode {
	int parent;
	int rank;
	public UNode(int newParent, int newRank) {
		parent = newParent;
		rank = newRank;
	}
	
	public int getParent() {return parent;}
	public int getRank() {return rank;}
	public void setParent(int newParent) {parent = newParent;}
	public void setRank(int newRank) {rank = newRank;}
}
