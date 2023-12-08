package ch13;

public class ThreadMainEx {
	public static void main(String[] args) {
		long id = Thread.currentThread().threadId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("Thread name : " + name);
		System.out.println("Thread id : " + id);
		System.out.println("Thread priority : " + priority);
		System.out.println("Thread state : " + s);
	}
}
