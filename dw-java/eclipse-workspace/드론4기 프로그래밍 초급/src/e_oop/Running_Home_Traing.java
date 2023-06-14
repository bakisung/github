package e_oop;

import java.util.Scanner;

public class Running_Home_Traing {

	static Scanner s = new Scanner(System.in);
	static String input;
	static boolean power;
	
	
	
	void power() {
		String powerOnOff = s.nextLine();
		if (powerOnOff.equals("on")) {
			power = true;
			System.out.println("전원이 켜졌습니다. 날래날래 뛰라우");
		} else if (powerOnOff.equals("off")) {
			power = false; 
			System.out.println("전원이 꺼졌습니다. 꺼지세요");
		}
	}
	
	void powerOff() {
		power = false;
	}
	
	int speed = 1;
	void speedUpDown() {
		String speedUpDown = s.nextLine();
		if (speedUpDown.equals("speedup")) {
			speed++;
			System.out.println("속도를 올립니다.\n현재 속도는 " + speed + " 입니다.");
		} else if (speedUpDown.equals("speeddown")) {
			speed--;
			System.out.println("속도를 내립니다.\n현재 속도는 " + speed + " 입니다.");
		}
	}
	
	int incline = 0;
	void inclineUpDown() {
		String inclineUpDown = s.nextLine();
		if (inclineUpDown.equals("inclineup")) {
			incline++;
			System.out.println("경사를 올립니다.\n현재 경사도는 " + incline + " 입니다.");
		} else if (inclineUpDown.equals("inclinedown")) {
			incline--;
			System.out.println("경사를 내립니다.\n현재 경사도는 " + incline + " 입니다.");
		}
	}
	
	
	
	
	
//===========================================절취선===========================================

	public static void main(String[] args) {
		
		// 사용설명서
		System.out.println("런닝머신 사용 설명서 입니다.\n"
				+ "전원 : on / off\n"
				+ "속도 : speedup / speedown\n"
				+ "경사 : inclineup / inclinedown\n");
		
		Running_Home_Traing rm = new Running_Home_Traing();
		
		rm.power();
		
		while (power) {
			String input = s.nextLine();
			if (input.equals("speedup") || input.equals("speeddown")) {
				rm.speedUpDown();
			} else if (input.equals("inclineup") || input.equals("inclinedown")) {
		        rm.inclineUpDown();
			} else if (input.equals("off")) {
				rm.power();
				break;
			}
		}
		
		
		
		
		
		
		

		
		
	} // main 종료선
	
//===========================================절취선===========================================

} // class 종료선
