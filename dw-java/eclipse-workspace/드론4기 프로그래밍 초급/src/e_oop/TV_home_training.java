package e_oop;

import java.util.Scanner;

import javax.swing.Spring;

public class TV_home_training {
	
	static Scanner s = new Scanner(System.in);
	static Spring input;
	
	// 전원
	static boolean power;
	void power() {
		String onOff = s.nextLine();
		if (onOff.equals("on")) {
			System.out.println("전원이 켜집니다. enjoy");
			power = true;
		} else if (onOff.equals("off")) {
			System.out.println("전원이 꺼집니다. 꺼지세요.");
			power = false;
		}
	};
	
	// 볼륨
	int vol = 1;
	void volume() {
		String volUpDown = s.nextLine();
		if (volUpDown.equals("volup")) {
			vol++;
			System.out.println("볼륨을 올립니다.\n현재 볼륨은 " + vol + " 입니다.");
		} else if (volUpDown.equals("voldown")) {
			vol--;
			System.out.println("볼륨을 내립니다.\n현재 볼륨은 " + vol + " 입니다.");
		}
	}
	
	// 채널
	int cha = 1;
	void channel() {
		String chaUpDown = s.nextLine();
		if (chaUpDown.equals("chaup")) {
			cha++;
			System.out.println("채널을 올립니다.\n현재 채널은 " + cha + "번 입니다.");
		} else if(input.equals("chaup")) {
			cha--;
			System.out.println("채널을 내립니다.\n현재 채널은 " + cha + "번 입니다.");
		}
	}
	
//===========================================절취선===========================================

	public static void main(String[] args) {
		
//===========================================절취선===========================================
		
		TV_home_training tv = new TV_home_training();

		System.out.println("TV 사용에 대한 설명입니다.\n"
				+ "전원 : on / off\n"
				+ "볼륨 : volup / voldown\n"
				+ "채널 : chaup / chadown");
		
//		String input = s.nextLine();
		tv.power();
		
		while (power) {
			String input = s.nextLine();
			if (input.equals("volup") || input.equals("voldown")) {
				tv.volume();
			} else if (input.equals("chaup") || input.equals("chadown")) {
				tv.channel();
			} else if (input.equals("off")) {
				System.out.println("전원이 꺼집니다. 꺼지세요.");
				power = false;
			}
		} // while 종료

		
		
		
		
		
		
		
//===========================================절취선===========================================

	} // main 종료



	
//===========================================절취선===========================================

} // class 종료
