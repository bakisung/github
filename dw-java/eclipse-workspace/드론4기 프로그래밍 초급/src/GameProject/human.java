package GameProject;

public class human {
	
	// 선언
	String name;
	int cm;
	int kg;
	int age;
	String sex;
	String hobby;
	
	// 인물
	human(int cm, int kg) {
		this.cm = cm;
		this.kg = kg;
	}
	
	public static void main(String[] args) {
		
		human 박희성 = new human(180, 70);
		human 김봉주 = new human(280, 78);
		human 송현준 = new human(121, 90);
		
		System.out.println("박희성의 키는 " + 박희성.cm + "cm 이다");
		System.out.println("김봉주의 키는 " + 김봉주.cm + "cm 이다");
		System.out.println("송현준의 키는 " + 송현준.cm + "cm 이다");
		System.out.println(박희성.kg);
		
	}

}
