package kr.or.dw.basic.nonCommand;

public class OKGoogle {
	private static String[] modes = {"heater", "lamp"};
	private String mode;
	
	private Heater heater;
	private Lamp lamp;
	
//	public OKGoogle(Heater heater) {
//		this.heater = heater;
//	}

	public OKGoogle(Heater heater, Lamp lamp) {
		this.heater = heater;
		this.lamp = lamp;
	}

	public void setMode(int idx) {
		this.mode = modes[idx];
	}
	
	public void talk() {
		switch (this.mode) {
		case "heater":
			this.heater.powerOn();
			break;
		case "lamp":
			this.lamp.turnOn();
			break;
		default:
			break;
		}
	}
}
