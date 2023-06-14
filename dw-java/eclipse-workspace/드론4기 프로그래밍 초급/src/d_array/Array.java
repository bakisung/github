package d_array;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.html.MinimalHTMLWriter;

public class Array {

	public static void main(String[] args) {
		
		//=======================================절취선=======================================

		/*
		 * << 배열 >>
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경할 수 없다.
		 */
		
//		int[] array; // 배열의 주소를 저장할 공간이 만들어진다.
//		array = new int[5]; //배열을 생성하고 그 주소가 저장된다.
		
//		int[] array2 = new int[5];
		
//		array = new int[] {1, 2, 3, 4, 5};
//		array = {1, 2, 3, 4, 5}; // 이 방법은 변수의 선언과 초기화를 동시에 해야한다.
//		int[] array2 = {1, 2, 3, 4, 5};
	
//		System.out.println(array2[0]);
//		System.out.println(array2[1]);
//		System.out.println(array2[2]);
//		System.out.println(array2[3]);
//		System.out.println(array2[4]);
		
//		int sum = 0;
//		for(int i = 0; i < array2.length; i++) {
//			sum += array2[i];
//		}
//		System.out.println("합계: " + sum);
		
//		int[] arrayx;
//		arrayx = new int[10];
//		
//		for (int i = 0; i < arrayx.length; i++) {
//			arrayx[i] = (int)(Math.random() * 100) + 1;
//		}
//		System.out.println(Arrays.toString(arrayx)); // 배열의 값들을 불러오는 방법이다.
		
		// 위에서 만든 임의의 숫자 10개 배열에서 최대값과 최소값을 구해주세요.
		// max와 min을 선언하고 배열들과 비교하여 for문으로 반복한 arrayx[i] 중에서 가장 큰 값이 결국 마지막 max값이 되고, 가장 작은 값이 마지막 min값이 된다.
//
//		int max = arrayx[0];
//		int min = arrayx[0];
//		
//		for (int i = 0; i < arrayx.length; i++) {
//			if (arrayx[i] > max) {
//				max = arrayx[i];
//				
//			} else if (arrayx[i] < min) {
//				min = arrayx[i];
//				
//			}
//		}
//		System.out.println(max + "맥시멈 값");
//		System.out.println(min + "미니멈 값");
		
		//답안
//		int max = arrayx[0];
//		int min = arrayx[0];
//		for (int i = 0; i < arrayx.length; i++) {
//			if (arrayx[i] > max) {
//				max = arrayx[i];
//			} else if (arrayx[i] < min) {
//				min = arrayx[i];
//			}
//		}
//		System.out.println("최대값은 " + max + " 입니다.");
//		System.out.println("최소값은 " + min + " 입니다.");
		
		
		
		//=======================================절취선=======================================
		
//		 1 ~ 10 까지의 숫자들이 중복되지않 배열 x에 랜덤하게 배치하세요.
//		int[] x = new int[10];
//		
//		for (int i = 0; i < x.length; i++) {
//			x[i] = (int)(Math.random() * 10 + 1); // x[i]의 랜덤한 값을 호출함
//			for (int j = 0; j < i; j++) {
//				if (x[i] == x[j]) { // x[i]와 x[j]의 값이 같다면
//					i--; // i의 수를 감소시킨다.
//					// *중요 : 반복문에서 i는 현재 생성될 요소를 나타내고, j는 이전에 생성된 요소를 나타낸다.
//				}
//			}
//		}
//		System.out.println(Arrays.toString(x));
		
		// 답안
//		for (int i = 0; i < x.length; i++) {
//			x[i] = (int)(Math.random() * 10 + 1);
//			for (int j = 0; j < i; j++) {
//				if (x[i] == x[j]) {
//					i--;
//				}
//			}
//		}
//		System.out.print(Arrays.toString(x));
		
		//=======================================절취선=======================================

		// 0 ~ 9 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 배열에 담아 출력해주세요.

//		int[] array = new int[10]; // 배열을 생성한다.
//		for (int i = 0; i < 500; i++) { // 500번 반복하는 for 문을 만든다.
//			int randumNum = (int)(Math.random()*10); // randumNum으로 0~9까지 랜덤한 숫자를 선언한다.
//			array[randumNum] += 1; // array 배열의 [randumNum]번째인 위치에 +1을 시켜준다.
//		} // 즉 0 1 2 3 .. 9 이렇게 각 배열의 위치에 숫자가 호출될때마다 +1이 된다.
//		System.out.println(Arrays.toString(array));
		
		//답안
//		int[] ax = new int[10]; // {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//		for (int i = 0; i < 500; i++) {
//			int a = (int)(Math.random() * ax.length);
//			ax[a] += 1;
//		}
//		System.out.println(Arrays.toString(ax)); // 1부터 10까지의 숫자가 각각 호출된 횟수들을 각 자리에 나열함
		
		//=======================================절취선=======================================
		
		// 위 문제의 최소값, 최대값, 반복횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.
		
//		//스캐너 생성
//		Scanner s = new Scanner(System.in);
//		//최소값
//		System.out.println("범위를 설정합니다.\n최소값을 입력해주세요.");
//		int inputMin = Integer.parseInt(s.nextLine());
//		//최대값
//		System.out.println("범위를 설정합니다.\n최대값을 입력해주세요.");
//		int inputMax = Integer.parseInt(s.nextLine());
//		//반복횟수
//		System.out.println("반복 횟수를 설정합니다.\n원하는 횟수를 입력해주세요.");
//		int inputRepeat = Integer.parseInt(s.nextLine());
//		//설정값
//		System.out.println("최소값은 " + inputMin + ", " +
//				"최대값은 " + inputMax + ", " +
//				"반복 횟수는 " + inputRepeat + " 입니다."
//				);
//		
//		//배열 등등 생성 및 선언
//		int array[] = new int[inputMax - inputMin + 1]; // 최대값 - 최소값으로 범위를 구한다
//		int min = array[0]; // 최소값
//		int max = array[0]; // 최대값
//		
//		for (int i = 1; i <= inputRepeat; i++) {
//			int randomNum = (int)(Math.random() * (inputMax - inputMin + 1) + inputMin); 
//			// ㄴ 최소값과 최대값의 범위를 구하고 마지막에 최소값을 더해줘야 0부터 시작이 아니다.
//			array[randomNum - inputMin] += 1;
//		}
//		System.out.println(Arrays.toString(array));
		
		//=======================================절취선=======================================

		/*
		 * 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요.
		 * 거스름돈 : 2860 -> random() 5000원 미만
		 * 500원 : 5개
		 * 100원 : 3개
		 * 50원 : 1개
		 * 10원 : 1
		 */
		
		//첫번째 방법
//		Scanner s = new Scanner(System.in);
//		for ( ; ; ) {
//			System.out.println("거스름돈을 설정해주세요. 필요한 갯수를 알려드립니다. 설정 가능한 거스름돈은 최대 5000원 입니다.");
//			int inputNum = Integer.parseInt(s.nextLine());
//			
//			if (inputNum > 5000) {
//				System.out.println("설정 가능한 거스름돈은 최대 5000원 입니다.\n");
//				continue;
//			} else {
//				int 거스름돈 = inputNum;
//				int 오백원 = 거스름돈 / 500;
//				int 백원 = (거스름돈 - 500 * 오백원) / 100;
//				int 오십원 = (거스름돈 - (500 * 오백원) - (100 * 백원)) / 50;
//				int 십원 = (거스름돈 - (500 * 오백원) - (100 * 백원) - (50 * 오십원)) / 10;
//				int 최종 = (거스름돈 - (500 * 오백원) - (100 * 백원) - (50 * 오십원) - (10 * 십원)) / 10;
//				int max = 5000;
//				
//				System.out.println(
//					"설정한 거스름돈은 " + 거스름돈 + " 입니다.\n" +
//					"500원 : " + 오백원 + "개, " +
//					"100원 : " + 백원 + "개, " +
//					"50원 : " + 오십원 + "개, " +
//					"10원 : " + 십원 + "개\n"
//				);
//			}
//		}
		
		//두번째 방법
		int money = (int)(Math.random() * 500) * 10;
		System.out.println(money);
		int[] coin = {500, 100, 50, 10};
		int[] res = new int[4];
		
		int 거스름돈 = money;
		for (int i = 0; i < coin.length; i++) {
			res[i] = 거스름돈/coin[i]; // 필요한 동전의 갯수가 순서대로 res 배열에 추가됨
			거스름돈 = 거스름돈 - res[i] * coin[i];
			if (거스름돈 == 0) {
				break;
			}
		}
		System.out.println("거스름돈 : " + money);
		System.out.println(
			"500원 : " + res[0] + "개\n" + 
			"100원 : " + res[1] + "개\n" + 
			"50원 : " + res[2] + "개\n" + 
			"10원 : " + res[3] + "개\n" 
		);
		
		
		
		
		
		
		
		//=======================================절취선=======================================

	}

}
