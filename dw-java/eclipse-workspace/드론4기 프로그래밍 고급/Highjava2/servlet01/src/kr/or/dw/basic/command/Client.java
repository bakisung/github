package kr.or.dw.basic.command;

/*
 * 커맨드 패턴(Command Pattern)
 * 커맨드 패턴은 객체의 행위(메서드)를 클래스로 만들어 캡슐화 하는 패턴이다.
 * 즉, 어떤 객체(A)에서 다른 객체(B)의 메서드를 실행하려면 그 객체(B)를 참조하고 있어야 하는 의존성이 발생한다.
 * 그러나 커맨드 패턴을 적용하면 의존성을 제거할 수 있다.
 * 또한, 기능이 수정되거나 변경이 일어날 때 A 클래스 코드를 수정없이 기능에 대한 클래스를 정의하면 되므로 시스템 확장성이 있으면서 유연해진다.
 */

public class Client {
	/*
	 * 커맨드 패턴 사용 이유
	 * 구글홈을 사용하는 사용자를 Client 클래스
	 * 구글홈을 OKGoogle 클래스
	 * 히터를 Heater 클래스로 정의한다.
	 * 
	 * 그러면 OKGoogle 은 히터를 켜기 위해서 Heater 객체를 참조해야 된다.
	 */
	
	public static void main(String[] args) {
		Heater heater = new Heater();
		Lamp lamp = new Lamp();
		
		Command heaterOnCommand = new HeaterOnCommand(heater);
		Command lampOnCommand = new LampOnCommand(lamp);
		OKGoogle okGoogle = new OKGoogle();
//		OKGoogle okGoogle = new OKGoogle(heater, lamp);
		
		// 히터 켜짐
//		okGoogle.setMode(0);
		okGoogle.setCommand(heaterOnCommand);
		okGoogle.talk();

		// 램프 켜짐
//		okGoogle.setMode(1);
		okGoogle.setCommand(lampOnCommand);
		okGoogle.talk();
	}
}
