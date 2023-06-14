package e_oop;

import java.util.Scanner;

public class TV {

	static boolean power; // 전원 : 켰다, 껐다  // 불린으로 하지 않아도 되지만 불린이 가장 적합한 형태임
	int channel; // 채널 : 직접 숫자 누르는 방법, 채널 버튼으로 올리고 내리는 방법
	int volume; // 볼륨 : 음량 올리는 방법, 내리는 방법
	static String what;
	Scanner s = new Scanner(System.in);
	
	void power() {
		String onOff = s.nextLine();
		if (onOff.equals("on")) {
			power = true;
			System.out.println("전원이 켜졌습니다. 현재 채널 : " + channel + "번 / 현재 음량 : " + volume);
		} else if (onOff.equals("off")) {
			power = false;
			System.out.println("전원이 꺼졌습니다. 꺼지세요.");
		}
	}
	
	void poweroff() { // 이렇게 따로 만들어도 되고 만들지 않고 맨 위에서 만든 power가 작동되기 해도됨
		System.out.println("전원이 꺼졌습니다.");
	}
	void channelDirect() {
		System.out.println(what + " 번 채널 입니다.");
		channel = Integer.parseInt(what);
	}
	
	void channelUpAndDown() {
		String ChUpAndDown = what;
		if (ChUpAndDown.equals("chup")) {
			channel++;
			System.out.println(channel + " 번 입니다.");
		} else if(ChUpAndDown.equals("chdown")) {
			channel--;
			System.out.println(channel + " 번 입니다.");
		}
	}
	
	void volumUpAndDown() {
		String volumUpAndDown = what;
		if (volumUpAndDown.equals("volup")) {
			volume++;
			System.out.println("현재 음량 " + volume + " 입니다.");
		} else if (volumUpAndDown.equals("voldown")) {
			volume--;
			System.out.println("현재 음량 " + volume + " 입니다.");
		}
	}
	
	public static void main(String[] args) {

		TV tv = new TV();
		Scanner sc = new Scanner(System.in); // 굳이 sc를 만들지 않고 맨위에 만든 s를 적용해도 된다.
		
		System.out.println("전원 켜기 : on / 전원 끄기 : off / 채널 변경 : 숫자입력 or chup or chdoun / 볼륨 변경 : volup or voldown");
		
		tv.power();
		
		while(power) { // while은 true 값일때 반복문이 돌아가므로 power가 on일때 true 값이므로 실행됨
			what = sc.nextLine();
		
			if(what.equals("chup") || what.equals("chdown")) { // onOff가 안되는 이유는 onOff는 지역 변수기 때문에 what을 선언해서 사용해야됨
				tv.channelUpAndDown();
			} else if(what.equals("volup") || what.equals("voldown")) {
				tv.volumUpAndDown();
			} else if(what.equals("off")) {
				tv.poweroff();
				break;
			} else {
				tv.channelDirect();
			}
		}
	
//		tv.poweroff();
	}

}
