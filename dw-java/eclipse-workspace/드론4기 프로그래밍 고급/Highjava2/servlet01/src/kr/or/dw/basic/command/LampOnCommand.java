package kr.or.dw.basic.command;

public class LampOnCommand implements Command{

	private Lamp lamp;
	
	public LampOnCommand(Lamp lamp) {
		this.lamp = lamp;
	}
	
	@Override
	public void run() {
		System.out.println("Lamp On");
	}

}
