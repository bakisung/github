package e_oop;

public class Calculator {

	// + - * / % 를 연산해주는 5개의 메소드를 만들어주세요.
	// 각각의 메소드는 2개의 파라미터를 받는다. 그 후 결과값 리턴
	
	// +
	double plus(double parameter1, double parameter2) {
		return parameter1 + parameter2;
	}
	
	// -
	double minus(double parameter1, double parameter2) {
		return parameter1 - parameter2;
	}
	
	// *
	double multiply(double parameter1, double parameter2) {
		return parameter1 * parameter2;
	}
	
	// /
	double division(double parameter1, double parameter2) {
		return parameter1 / parameter2;
	}
	
	// %
	double persent(double parameter1, double parameter2) {
		return parameter1 % parameter2;
	}
	
}
