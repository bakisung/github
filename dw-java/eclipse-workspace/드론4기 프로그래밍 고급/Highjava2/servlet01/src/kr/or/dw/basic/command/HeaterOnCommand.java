package kr.or.dw.basic.command;

public class HeaterOnCommand implements Command{
	
	// OKGoogle 클래스에서 참조하면 heater 클래스 객체를 여기서 참조시키는 구조
	private Heater heater;
	
	public HeaterOnCommand(Heater heater) {
		this.heater = heater;
	}

	@Override
	public void run() {
		System.out.println("Heater On");
	}
}
