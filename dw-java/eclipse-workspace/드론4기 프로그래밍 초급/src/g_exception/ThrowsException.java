package g_exception;

import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) {

		/*
		 * 메소드에서 예외 선언하기
		 * - 메소드 호출 시 발생할 수 있는 예외를 선언해줄 수 있다.
		 * - void method() throws IOException {}
		 * - 메소드의 구현부 끝에 throws 예약어와 예외 클래스명으로 예외를 선언할 수 있다.
		 * - 예외를 선언하면 예외처리를 하지 않고 자식을 호출한 메서드로 예외처리를 넘겨준다.
		 */
		
		try {
			method();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void method() throws IOException {
		throw new IOException();
	}
	
}
