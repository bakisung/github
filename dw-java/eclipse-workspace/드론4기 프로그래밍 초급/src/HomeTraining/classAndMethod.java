package HomeTraining;

import java.util.Scanner;

public class classAndMethod {

	public static void main(String[] args) {

		/*
		 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
		 * 
		 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
		 * 사용자의 가위 바위 보는 showInputDialog() 를 이용해서 입력받는다.
		 * 
		 * 입력시간은 5초로 제한하고, 카운트다운을 진행한다.
		 * 5초 안에 입력이 없으면 게임에 진것으로 처리한다.
		 * 
		 * 5초 안에 입력이 완료되면 승패를 구해서 출력한다.
		 * 결과 예시)
		 * 	-- 결	과 --
		 * 	컴퓨터 : 가위
		 * 	사용자 : 바위
		 * 	  <승!!> 
		 */
		
		Scanner s = new Scanner(System.in);
		Guide g = new Guide();
		UserNum u = new UserNum();
		ComNum c = new ComNum();
		Result r = new Result();
		
		g.guide(); // 게임 시작 가이드
		int userNum = Integer.parseInt(s.nextLine());
		u.userNum();
		c.comNum();
		r.result();
		
	}

}

// 게임 시작 가이드
class Guide {
	public void guide() {
		System.out.println("가위 바위 보 게임을 시작합니다.");
		System.out.println("보기중 한가지의 번호를 입력하세요.");
		System.out.println("1) 가위\t2) 바위\t3) 보");
	}
}

class UserNum {
	public void userNum() {
		System.out.println("\n당신의 선택은 ");

	}
}

class ComNum {
	public void comNum() {
		int comInputNum = (int)(Math.random() * 3) + 1;
		if (comInputNum == 1) {
			System.out.println("컴퓨터의 선택은 [가위] 입니다.");	
		} else if (comInputNum == 2) {
			System.out.println("컴퓨터의 선택은 [바위] 입니다.");
		} else if (comInputNum == 3) {
			System.out.println("컴퓨터의 선택은 [보] 입니다.");
		}
	}
}

class Result {
	public void result() {

	}
}