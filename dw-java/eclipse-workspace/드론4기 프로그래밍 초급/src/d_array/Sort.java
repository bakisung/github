package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		
		//=======================================절취선=======================================

//		int[] arr = new int[10];
//		
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 100) + 1;
//		}
//		System.out.println(Arrays.toString(arr));
//		
//		// 석차구하기
//		// 처음에는 다 1등으로 시작해서 비교
//		int[] arr2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // 등수를 저장할 배열
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				if(arr[j] > arr[i]) {
//					arr2[i]++;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr2));
		
		//=======================================절취선=======================================
		
		// 배열에 속한 열가지의 숫자중 가장 작은숫자부터 왼쪽에 정렬된다
//		int arr[] = new int[10]; // arr 배열 공간 만들고 그 안에 10 만큼 넣는다.
//		for (int i = 0; i < arr.length; i++) { // arr 배열에 넣을 랜덤값을 10번 넣는다.
//			arr[i] = (int)(Math.random() * 100) + 1;
//		}
//		System.out.println(Arrays.toString(arr)); // 랜덤값이 입력된 순서대로 배열에 넣는다.
//
//		// 선택정렬
//		System.out.println("======");
//		System.out.println("선택정렬");
//		System.out.println("======");
//		int temp = 0; // 배열의 첫번째 자리를 지정해주기위해 0을 미리 선언해둔다.
//		for (int i = 0; i < arr.length-1; i++) { // 이전에 만든 배열과 비교하기 위해 새로운 배열을 만든다.
//			int minIndex = i; // 배열의 i번째 인덱스를 선언해준다.
//			for (int j = i + 1; j < arr.length; j++) { //
//				if (arr[j] < arr[minIndex]) {
//					minIndex = j;
//				}
//			}
//			temp = arr[i];
//			arr[i] = arr[minIndex];
//			arr[minIndex] = temp;
//			System.out.println(Arrays.toString(arr));
//		}
		
		//=======================================절취선=======================================
		
		// 삽입 정렬

//		int arr[] = new int[10];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 100) + 1;
//		}
//		System.out.println(Arrays.toString(arr));
//		
//		System.out.println("======");
//		System.out.println("삽입정렬");
//		System.out.println("======");
//		for (int i = 1; i < arr.length; i++) {
//			for (int j = i; j >= 1; j--) {
//				if (arr[j] < arr[j - 1]) {
//					int tmp = arr[j];
//					arr[j] = arr[j - 1];
//					arr[j - 1] = tmp;
//				} else {
//					break;
//				}
//			}
//			System.out.println(Arrays.toString(arr));
//		}
		
		//=======================================절취선=======================================

		System.out.println("======");
		System.out.println("기존배열");
		System.out.println("======");
		
		// 버블 정렬
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println("======");
		System.out.println("버블정렬");
		System.out.println("======");
		for (int i = 0; i < arr.length; i++) {
			boolean changed = false; // 이거 넣어주면 속도가 훨씬 빨라짐
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
					changed = true; // 이거 넣어주면 속도가 훨씬 빨라짐2
				}
			}
			if(!changed) break;
			System.out.println(Arrays.toString(arr));
		}
		
		
		
		
		
		
		
		//=======================================절취선=======================================

		
	}

}
