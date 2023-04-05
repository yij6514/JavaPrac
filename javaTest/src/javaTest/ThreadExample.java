package javaTest;

public class ThreadExample implements Runnable {
    public void run() {
        // 스레드가 실행할 작업을 구현합니다.
        System.out.println("스레드가 실행됩니다.");
    }

    public static void main(String[] args) {
        // Runnable 객체를 생성합니다.
        Runnable threadExample = new ThreadExample();

        // Thread 객체를 생성하고 Runnable 객체를 전달합니다.
        Thread thread = new Thread(threadExample);

        // 스레드를 시작합니다.
        thread.start();

        // 메인 스레드가 실행할 작업을 구현합니다.
        System.out.println("메인 스레드가 실행됩니다.");
    }
}