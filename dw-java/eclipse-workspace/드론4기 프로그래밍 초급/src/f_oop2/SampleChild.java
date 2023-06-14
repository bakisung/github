package f_oop2;

public class SampleChild extends SampleParent {
	
	void childMethod() {
		// 상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var);			// 상속받은 변수
		System.out.println(method(7, 13));	// 상속받은 메소드
		System.out.println(k);
		System.out.println(super.k);
	}
	
	// 오버라이딩 : 부모클래스의 메서드 내용을 변경하여 재구성 하는것
	// super, super() : this 와 비슷한 역할. 부모클래스의 멤버와 자식클래스의 멤버가 이름이 똑같을 때,
	//					둘을 구분해 주기 위해서 사용한다.

	@Override
	int method(int a, int b) {
		return a * b;
	}
	
	int var;
	void test() {
		System.out.println(var);		// 지역변수
		System.out.println(this.var);	// 인스턴스 변수
		System.out.println(super.var);	// 부모클래스의 인스턴스 변수
		System.out.println(this.method(10, 20));
		System.out.println(super.method(10, 20));
	}
	
	SampleChild(int var) {
		super();
		// super()를 통해 클래스의 생성자를 호출하고 부모클래스의 인스턴스 변수도 초기화한다.
		this.var = var;
	}
	
	public static void main(String[] args) {
		SampleChild sc = new SampleChild(5);
		SampleParent sp = new SampleParent();
//		sc.childMethod();
//		System.out.println(sp.method(7, 13));
//		System.out.println(sc.method(7, 13));
//		sc.test();
		
//		sc = (SampleChild) sp;	// 부모타입이 자식타입에 들어갈때는 형변환이 필요하고
//		sp = sc;							// 자식타입이 부모타입에 들어갈때는 형변환이 필요없다.
//		SampleChild sc2 = (SampleChild)new SampleParent()s;
		// SampleParent는 3개의 멤버를 가지고 있다.
		// SampleChild는 6개의 멤버를 가지고 있따.
		// SampleChild 타입의 참조변수는 6개의 멤버를 사용할 수 있어야 하는데  SampleParent 객체는
		// 3개의 멤버만 가지고 있다.
		// 그러므로 부모타입의 객체를 자식타입으로 형변환 하는것은 에러를 발생시킨다.
	}

}
