package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Array {

	public static void main(String[] args) {

		String[] classGroup = {"최진혁", "최유빈", "한이람", "이고잉"};
		System.out.println(classGroup[0]);
		System.out.println(classGroup[1]);
		System.out.println(classGroup[2]);
		System.out.println(classGroup[3]);

		String[] members = {"박희성", "김봉주", "김지민"};
		for (int i = 0; i < members.length; i++) {
			String member = members[i];
			System.out.println(member + "이 상담을 받았습니다.");
		}
		
//===============================================================================================
		
//		System.out.println("\n======1번 문제 시작======");
////		int[] arrayx;
////		arrayx = new int[10];
//		int[] arrayx = new int[10];
//		
//		for (int i = 0; i < arrayx.length; i++) {
//			arrayx[i] = (int)(Math.random() * 100) + 1;
//		}
//		System.out.println(Arrays.toString(arrayx)); // 배열의 값들을 불러오는 방법이다.
//		
//		// 위에서 만든 임의의 숫자 10개 배열에서 최대값과 최소값을 구해주세요.
//		// max와 min을 선언하고 배열들과 비교하여 for문으로 반복한 arrayx[i] 중에서 가장 큰 값이 결국 마지막 max값이 되고, 가장 작은 값이 마지막 min값이 된다.
//		
//		int max = arrayx[0];
//		int min = arrayx[0];
//		
//		for (int i = 0; i < arrayx.length; i++) {
//			if (arrayx[i] > max) {
//				max = arrayx[i];
//			} else if (arrayx[i] < min) {
//				min = arrayx[i];
//			}
//		}
//		System.out.println("최대값은 " + max + " 이다.");
//		System.out.println("최소값은 " + min + " 이다.");
//		System.out.println("======1번 문제 종료======");
		
//===============================================================================================
		
//		System.out.println("\n======2번 문제 시작======");
//		
////		 1 ~ 10 까지의 숫자들이 중복되지않게 배열 x에 랜덤하게 배치하세요.
//		
//		int[] x = new int[10];
//		for (int i = 0; i < x.length; i++) {
//			x[i] = (int)((Math.random() * 10) + 1);
//			for (int j = 0; j < i; j++) {
//				if (x[i] == x[j]) {
//					i--;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(x));
//		
//		System.out.println("======2번 문제 종료======");

//===============================================================================================
		
		System.out.println("\n======3번 문제 시작======");

		// 1 ~ 10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 배열에 담아 출력해주세요.

		int[] array = new int[10];
		
		for (int i = 0; i < 500; i++) {
			int randomNumber = (int)(Math.random() * 10);
				array[randomNumber] += 1;
		}
		System.out.println(Arrays.toString(array));
				
				
				
				
				
				
		System.out.println("======3번 문제 종료======");

		
		
		
		
		
		
	} // 메인 종료

} // 클래스 종료
