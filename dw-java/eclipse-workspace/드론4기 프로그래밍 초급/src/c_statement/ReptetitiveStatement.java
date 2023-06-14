package c_statement;

import java.util.Scanner;

public class ReptetitiveStatement {

	public static void main(String[] args) {

		/*
		 * << for문 >>
		 * - for(int i = 1; i <= 10; i++) { }
		 * - for (1부터 10까지 1씩 증가하면서 반복) { }
		 */
		
		//=======================================절취선=======================================	
		
//		for (int i = 1; i <= 10; i++) {
//			// for(초기화; 조건식; 증감식) {}
//			// 초기화 : 조건식과 증감식에 사용할 변수 초기와
//			// 조건식 : 연산결과가 true 이면 블럭 안의 내용을 수행한다.
//			// 증감식 : 변수를 증가/감소시켜 반복문을 제어한다.
//			System.out.println(i + "번째 반복"); // 초기화한 변수를 블럭 안에서 사용할 수 있다.
//		}
		
		//=======================================절취선=======================================	
		
//		int i;
//		for(i = 0; i < 3; i++) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		System.out.println("==========================");
		
		//=======================================절취선=======================================
		
//		int i;
//		for(i = 1; i <= 100; i++) {
//			System.out.print(i + " ");
//		}
		
		//=======================================절취선=======================================
		
		//========================================절취선=============================================

//		*
//		**
//		***
//		****
//		*****
		
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 1;	j < i ; j++) {
//				System.out.print("*");
//			}
//			System.out.println("*");
//		}
//		System.out.println();
		
		//========================================절취선=============================================
		
//			*
//		   **
//		  ***
//		 ****
//		*****
		
//		for (int i = 5; i >= 1; i--) {
//			for (int j = 1; j < i; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 4; k >= i; k--) {
//				System.out.print("*");
//			}
//			System.out.println("*");
//		}
//		System.out.println("");
	
		//=======================================절취선=======================================	
		
//		*****
//		****
//		***
//		**
//		*
		
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 5; j >= i; j--) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
//		System.out.println("");
		
		//=======================================절취선=======================================		
		
		/*
		 * *****
		 *  ****
		 *   ***
		 *    **
		 *     *
		 */
		
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 1; j < i; j++) {
//				System.out.print(" ");
//			}
//			for (int k = 5; k >= i; k--) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
//		System.out.println("");
		
		//=======================================절취선=======================================	
		
		/*
		 *     *
		 *    ***
		 *   *****
		 *  *******
		 * *********
		 */
		
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 5; j > i; j--) {
//				System.out.print(" ");
//			}
//			for (int k = 1; k <= i; k++) {
//				System.out.print("*");
//			}
//			for (int l = 1; l < i ; l++) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
//		System.out.println("");
		
		//=======================================절취선=======================================	
		
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 5; j > i; j--) {
//				System.out.print(" ");
//			}
//			for (int k = 1; k <= i; k++) {
//				System.out.print("*");
//			}
//			for (int l = 1; l < i ; l++) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
//		for (int i2 = 1; i2 <= 5; i2++) {
//			for (int j2 = 1; j2 <= i2; j2++) {
//				System.out.print(" ");
//			}
//			for (int k2 = 3; k2 >= i2; k2--) {
//				System.out.print("*");
//			}
//			for (int l2 = 4; l2 >= i2; l2--) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
		
		//=======================================절취선=======================================	
		
		/*
		 * << while >>
		 * - while(조건식) { }
		 * - 조건식의 결과가 true인 동안 계속해서 반복
		 * - 반복횟수를 알 수 없을때 사용한다.
		 */
		
//		int a = 0;
//		while(a < 10) {
//			System.out.println(a + " ");
//			a++;
//		}
//		
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i + " ");
//		}
		
//		int b = 0;
//		while(true) {  // while을 true 값으로 주었기 때문에 계속 실행되어 무한루프가 된다.
//			if (b > 10) {
//				break;
//			}
//			System.out.println(b + " ");
//			b++;
//		}
		
		//=======================================절취선=======================================
		
		// 사용자가 입력한 단의 구구단을 출력하는 프로그램을 만들어주세요.
		// 특정 값을 입력했을때 종료가 되게 만들어 주세요.
		
		while (true) {
			int a = 1;
			System.out.println("\n\n몇단을 불러올까요?\n" + "종료를 원하시면 0을 입력해주세요.");
			Scanner s = new Scanner(System.in);
			int inputNum = Integer.parseInt(s.nextLine());
			
			if (inputNum == 0) {
				System.out.println("종료합니다.");
				break;
			}
			
			System.out.println(inputNum + "단을 불러옵니다.");
		
			while (true) {
				System.out.print(inputNum * a + " ");
				a++;
				if (a >= 10) {
					break;
				}
			}
		}
		
		
		
		
		
		//=======================================절취선=======================================	
		
	}
}
