package javaTest;

import java.util.Scanner;

public class ScannerTest {
	static int num1;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int remain = 0;
		
		System.out.print("금액을 입력하시오>>");
		num1 = sc.nextInt();
		
		remain = cal(num1,50000);
		if(remain != 0) {
			System.out.print("오만원권 ");
			System.out.print(remain + "매");
		}
		
		remain = cal(remain,10000);
		if(remain != 0) {
			System.out.print("\n만원권 ");
			System.out.print(remain + "매");
		}
		
		remain = cal(num1,5000);
		if(remain != 0) {
			System.out.print("\n오천원권 ");
			System.out.print(remain + "매");
		}
		
		remain = cal(num1,1000);
		if(remain != 0) {
			System.out.print("\n천원권 ");
			System.out.print(remain + "매");
		}
		
		remain = cal(num1,500);
		if(remain != 0) {
			System.out.print("\n오백원 ");
			System.out.print(remain + "개");
		}
		
		remain = cal(num1,100);
		if(remain != 0) {
			System.out.print("\n백원 ");
			System.out.print(remain + "개");
		}
		
		remain = cal(num1,50);
		if(remain != 0) {
			System.out.print("\n오십원 ");
			System.out.print(remain + "개");
		}
		
		remain = cal(num1,10);
		if(remain != 0) {
			System.out.print("\n십원 ");
			System.out.print(remain + "개");
		}
		
		if(num1 != 0) {
			System.out.print("\n일원 ");
			System.out.print(num1 + "개");	
		}
		
		sc.close();
	}
	
	public static int cal(int income, int num) {
		int tmp = income / num;
		num1 %= num;
		return tmp;
	}
	
}
