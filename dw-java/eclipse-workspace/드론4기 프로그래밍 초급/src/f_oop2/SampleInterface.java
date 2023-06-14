package f_oop2;

public interface SampleInterface {

	// 인터페이스의 모든 멤버변수는 public static final 제어자가 된다.
	public static final int NUM1 = 1;
	
	// 모든 멤버변수의 제어자가 같기 때문에 생략이 가능하다.
	int NUM2 = 2;
	
	// 인터페이스의 모든 메서드는 public abstract 제어자가 붙는다.
	public abstract void method1();
	
	// 모든 메서드의 제어자가 같기 때문에 생략이 가능하다.
	void method2();
	
}

interface SampleInterface2{
	void method1();
	void method3();
}

class SampleImplement implements SampleInterface, SampleInterface2{

	// 어떤 객체가 있고 그 객체가 특정한 인터페이스를 사용한다면 그 객체는 반드시 인터페이스의 메서드들을 구현해야한다.
	// 만약 인터페이스에서 강제하고 있는 메소드를 구현하지 않으면 이 어플리케이션은 컴파일조차 되지 않는다.
	// 인터페이스는 몸체가 없는 메소드들의 모임이다. 클래스를 구현하기 전에 만들 메소드를 먼저 정해놓는 것이다.
	
	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
		
	}

	@Override
	public void method3() {
		
	}
	
}
