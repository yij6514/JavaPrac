package dataStructure;

public class Test {

	public static void main(String[] args) {
		
		ArrayStack<Integer> st = new ArrayStack<Integer>();
		st.insertLast(3);
		
		System.out.println(st.peek());
		
		st.push(10);
		System.out.println(st.peek());
		//System.out.println(st.pop());
		//System.out.println(st.peek());
		int a[] = {1,2,3};
		System.out.println(a[3]);
	}
}
