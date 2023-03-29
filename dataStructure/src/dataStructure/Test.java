package dataStructure;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		palcheck(input);
		sc.close();
	}
	
	public static void palcheck(String input) {
		SLLStack<Character> st = new SLLStack<Character>();
		
		for(int i = 0; i < input.length() / 2; i++) {
			st.push(input.charAt(i));
		}
		
	}
}
