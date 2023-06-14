package d_array;

import java.sql.Time;
import java.util.Arrays;

public class Etc_string {

	public static void main(String[] args) {
	//public : 접근 제어자 //static : 어디서든 사용할 수 있다 //void : 반환 타입 (void는 반환이 없다는 뜻)
		
		
		//=======================================절취선=======================================
		
		// 문자열길이
		System.out.println("=============문자열길이==============");
		String str1 = "Hello Java!";
		String str2 = "안녕하세요! 반갑습니다.";
		System.out.println(str1.length());
		System.out.println(str2.length());
		System.out.println("==================================");

		
		// 문자열 검색
		System.out.println("=============문자열 검색==============");
		System.out.println(str1.charAt(1));
		System.out.println(str2.charAt(1));
		System.out.println("==================================");
		
		// indexOf(), lastIndexOf()
		System.out.println("=============indexOf(), lastIndexOf()==============");
		System.out.println(str1.indexOf("a"));
		System.out.println(str1.lastIndexOf("a"));
		System.out.println(str1.indexOf("a", 8));
		System.out.println(str1.lastIndexOf("a", 8));
		System.out.println(str1.indexOf("하십쇼")); // 찾지 못하므로 값은 -1이 나옴
		System.out.println(str1.lastIndexOf("Bye")); // 찾지 못하므로 값은 -1이 나옴
		System.out.println("===================================================");
		
		// 문자열 변환 및 연결
		System.out.println("=============indexOf(), lastIndexOf()==============");
		String str3 = String.valueOf(2.3);
		String str4 = String.valueOf(false);
		System.out.println(str3);
		System.out.println(str4);
		System.out.println("===================================================");
		
		//=======================================절취선=======================================
		
		String str5 = str3.concat(str4);
		System.out.println(str5);
		String str6 = "안녕" + 10;
		System.out.println(str6);
		String str7 = "안녕".concat(String.valueOf(11));
		System.out.println(str7);
		
		System.out.println("==================문자열 수정=====================");
		String str8 = "\"Java Study\"";
		System.out.println(str8.toLowerCase()); // 소문자 변환
		System.out.println(str8.toUpperCase()); // 대문자 변환
		System.out.println(str8.replace("Study", "공부"));
		
		System.out.println(str8.substring(0, 4));
		String[] strArray = null;
		String str9 = "abc/def-ghi ejkl";
		strArray = str9.split("e");
		System.out.println(Arrays.toString(strArray));
		System.out.println("0번 인덱스 : " + strArray[0] + ", 1번 인덱스 : " + strArray[1] + ", 2번 인덱스 : " + strArray[2]);
		
		System.out.println("     abc     ".trim());
		System.out.println("===================================================");
		System.out.println("");
		System.out.println("==================문자열의 내용 비교=====================");
		String str10 = new String("Java");
		String str11 = new String("Java");
		String str12 = new String("java");
		String str13 = "Java";
		
		System.out.println(str10 == str11);
		System.out.println(str11 == str12);
		System.out.println(str12 == str10);
		
		System.out.println(str10.equals(str11));
		System.out.println(str11.equals(str12)); // 대소문자 달라서 false 값이 나옴
		System.out.println(str11.equalsIgnoreCase(str12)); // 대소문자 무시해주기 때문에 true 값이 나옴

		System.out.println("===================================================");

		//=======================================절취선=======================================

	}

}
