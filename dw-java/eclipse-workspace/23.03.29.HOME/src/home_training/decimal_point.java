package home_training;

public class decimal_point {

	public static void main(String[] args) {
		
		// 1번 문제
		// *복습 포인트
		// 3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		// 평균은 소수점 둘째자리에서 반올림 해주세요.
		
		int num1 = 59;
		int num2 = 82;
		int num3 = 26;
		
		int sum = num1 + num2 + num3;
		System.out.println("숫자 3개의 합은 " + sum + " 입니다.");
		
		double average = (double)sum / 3; 
		System.out.println(average); // 55.666666666666664
		
		// 이제 소수점 둘째자리에서 반올림 즉 소수점 첫째자리까지 값이 나와야 한다.
		// Math.round 메소드는 소수점 첫번째 자리에서 반올림을 하므로 아래처럼 곱하기와 나누기를 해주어야 소수점 첫째자리가 나온다.
		System.out.println("숫자 3개의 평균값은 " + Math.round(average * 10) / 10.0 + " 입니다."); 
		
//		==================================================================================================
		
		// 2번 문제 (평균의 정답은 46.7)
		// *복습 포인트
		// 3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		// 평균은 소수점 둘째자리에서 반올림 해주세요.
		
		int t1 = 15;
		int t2 = 38;
		int t3 = 87;
		
		double sum2 = t1 + t2 + t3;
		System.out.println("합계는 " + sum2);
		
		double average2 = sum2 / 3;
		System.out.println("평균은 " + Math.round(average2 * 10) / 10.0);
		
		
		
		
		
		
		
		
		
		
		
	}

}
