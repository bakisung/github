package b_operator;

public class LogiclOperator {

	public static void main(String[] args) {
		
		/*
		 * << 논리 연산자 >>
		 * - &&(AND) : 피연산자 둘 다 true이면 true를 결과로 얻는다.
		 * - ||(OR) : 피연산자 중 하나라도 true이면 true를 결과로 얻는다.
		 * - !(NOT) : 피연산자가 true이면 false를, false이면 true를 결과로 얻는다.
		 * - 피연산자로 boolean만 허용한다.
		 */
		
		// a가 0보다 크고 10보다 작거나 같다.
		int a = 6;
		boolean b1 = 0 < a; // a가 0보다 크다
		boolean b2 = a <= 10; // a가 10보다 작거나 같다.
		boolean b = b1 && b2; // && 둘다 true 이므로 
		System.out.println(b); // ㄴ 결과값이 true가 나온다
		
		// a가 2의 배수이거나 3의 배수인가?
		b = a%2 == 0 || a%3 == 0;
		System.out.println(b);
		
		// a가 2의 배수이거나 3의 배수이고 10 이하인가?
		b = (a%2 == 0 || a%3 == 0) && a <= 10;
		// &&가 ||보다 먼저 수행되기 때문에 문제의 의도와 다르게 되므로 ()로 묶어준다.
		System.out.println(b);
		
		// && = 그리고
		b = true && true; //true
		b = true && false; // false
		b = false && true; // false
		b = false && false; // false
		
		int d = 10;
		b = d < 10 && 0 < d++; // && 앞에서 false가 나왔으므로 그 뒤에 값인 0 < d++는 아예 읽히지도 않는다. 
		System.out.println(d); // ㄴ 따라서 값은 d++이 적용되지 않은 10이 된다.
		
		int x = 1, y = 2;
		b = x + 3 * y > y - 2 || x < 3 && y >= 5;
		// 산술 비교 논리 모두 있을 때 산술>비교>논리 순서로 연산이 된다.
		// b = 1 + 3 * 2 > 2 - 2 || 1 < 3 && 2 >= 5
		// b = 1 + 6 > 0 || 1 < 3 && 2 >= 5
		// b = true || true && false
		// b = true || false
		// b = true
		System.out.println(b);
		
		
		
		
		
		
		
		
		
	}

}
