package kr.or.dw.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		
		// Thread를 사용하는 방법
		/*
		 *  방법1)
		 *  Thread 클래스를 상속한 Class를 작성하고, 이 클래스의 인스턴스를 생성한 후
		 *  이 인스턴스의 start() 메서드를 호출해서 실행한다.
		 */
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		/*
		 *  방법2)
		 *  Runnable 인터페이스를 구현한 Class를 작성하고, 이 클래스의 인스턴스를 생성하고
		 *  이 인스턴스를 Thread 객체를 생성할 때 생성자의 매개값으로 넘겨준다. 이때 생성된
		 *  Thread의 인스턴스의 start()메서드를 호출해서 실행한다.
		 */
		Runnable r1 = new MyRun();
		Thread th2 = new Thread(r1);
		th2.start();
	}

}

// 방법1 - 쓰레드를 상속 받는 클래스를 생성
class MyThread1 extends Thread {

	@Override
	public void run() {
		// 이 run() 메서드 안에 쓰레드에서 처리할 내용을 기술한다.
		for(int i = 1; i <= 200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간) :	이 메서드는 주어진 '시간'동안 작업을 잠시 멈춘다.
				//						시간은 밀리 세컨드 단위를 사용한다. (1/1000초 단위)
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

// 방법2
class MyRun implements Runnable {

	@Override
	public void run() {
		// 쓰레드가 처리할 내용을 run() 메서드에 기술한다.
		for(int i = 1; i <= 200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}