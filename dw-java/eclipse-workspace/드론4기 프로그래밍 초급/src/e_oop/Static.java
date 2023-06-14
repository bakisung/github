package e_oop;

public class Static {

	/*
	 * - static을 붙이면 프로그램 실행시 메모리에 올라간다.
	 * - 객체생성을 하지 않아도 사용할 수 있다.
	 * - static을 붙인 변수는 개체간에 변수의 값을 공유한다.
	 * - static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드
	 * - static이 붙지 않은 멤버의 명칭 : 인스턴스 변수, 인스턴스 메서드
	 */
	
	static int var;
	
	public static void main(String[] args) {

		Human 철수 = new Human();
		Human 영희 = new Human();
		
		철수.savemoney(100000);
		영희.savemoney(200000);
		
		철수.saveDateMoney(200000);
		영희.saveDateMoney(200000);
		
	}

}


class Human {
	int account;
	
	// 메서드 선언 ==> 반환타입 메서드명() { };
	void savemoney(int money) {
		account += money;
		System.out.println("통장 잔고 : " + account);
	}
	
	static int dateAccount;
	
	void saveDateMoney(int money) {
		dateAccount += money;
		System.out.println("데이트 통장 잔고 : " + dateAccount);
	}
}