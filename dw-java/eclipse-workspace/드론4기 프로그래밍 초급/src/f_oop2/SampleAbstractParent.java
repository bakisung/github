package f_oop2;

public abstract class SampleAbstractParent {

	// 추상 메서드 : 선언부만 있고 구현부는 없는 메소드
	abstract void abstractMethod();
	void method() { // 일반 메소드
		
	}
	
}

class SampleAbstractChild extends SampleAbstractParent{

	@Override
	void abstractMethod() {
		
	}
	
}
