package kr.or.dw.basic;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		
		// 형식1) new File(String 파일 또는 경로)
		File file1 = new File("C:\\Users\\admin\\Documents\\file.txt");
		System.out.println("━━━━━━━━━━━━━━━━━━[File1]");
		System.out.println("파일명 : " + file1.getName());
		System.out.println("path : " + file1.getPath());
		System.out.println("디렉토리인가? : " + file1.isDirectory());
		System.out.println("파일인가? : " + file1.isFile());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		File file2 = new File("C:\\Users\\admin\\Documents");
		System.out.println("━━━━━━━━━━━━━━━━━━[File2]");
		System.out.println("파일명 : " + file2.getName());
		System.out.println("path : " + file2.getPath());
		System.out.println("디렉토리인가? : " + file2.isDirectory());
		System.out.println("파일인가? : " + file2.isFile());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		// 형식2) new File(File parent, String child)
		//		: 'parent' 디렉토리 안에 있는 'child' 파일을 갖는다.
		File file3 = new File(file2, "file.txt");
		System.out.println("━━━━━━━━━━━━━━━━━━[File3]");
		System.out.println("파일명 : " + file3.getName());
		System.out.println("path : " + file3.getPath());
		System.out.println("디렉토리인가? : " + file3.isDirectory());
		System.out.println("파일인가? : " + file3.isFile());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		// 디렉토리(폴더) 만들기
		// - mkdir() : File객체의 경로 중 마지막 위치의 디렉토리를 만든다.
		//			 : 반환값 ==> 만들기 성공(true), 만들기 실패(false)
		//			 : 경로의 중간부분의 폴더(디렉토리)들이 모두 만들어져 있어야 한다.
		
		// - mkdirs() : 중간 부분의 경로가 없으면 그 중간 부분의 경로도 같이 만들어 준다.
		
		File file4 = new File("C:\\Users\\admin\\Documents\\연습용");
		
		System.out.println(file4.getName() + " 의 존재 여부 : " + file4.exists());
		
		if (file4.mkdir()) {
			System.out.println(file4.getName() + "폴더 만들기 성공ㅋ");
		} else {
			System.out.println(file4.getName() + "폴더 만들기 실패ㅋ");
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		
	}

}
