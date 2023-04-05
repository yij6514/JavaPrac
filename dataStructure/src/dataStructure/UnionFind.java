package dataStructure;

public class UnionFind {
	protected UNode[] a;

	public UnionFind(UNode[] a) {
		this.a = a;
	}

	protected int find(int i) {
		if(i != a[i].getParent())
			a[i].setParent(find(a[i].getParent()));
		return a[i].getParent();
	}
	
	public void union (int i, int j) {
		int iroot = find(i);
		int jroot = find(j);
		if(iroot == jroot) return;
		if(a[iroot].getRank() > a[jroot].getRank())
			a[jroot].setParent(iroot);
		else if(a[iroot].getRank() < a[jroot].getRank())
			a[iroot].setParent(jroot);
		else {
			a[jroot].setParent(iroot);
			int t = a[iroot].getRank() + 1;
			a[iroot].setRank(t);
		}
	}
}
