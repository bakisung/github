package kr.or.dw.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {

	public static void main(String[] args) {
		// 객체를 파일에 저장하는 매체
		Member mem1 = new Member("홍길동", 24, "대전시 중구 선화동");
		Member mem2 = new Member("홍길서", 24, "대전시 중구 선화서");
		Member mem3 = new Member("홍길남", 24, "대전시 중구 선화남");
		Member mem4 = new Member("홍길북", 24, "대전시 중구 선화북");
		
		// 객체를 파일에 저정하기
		
		try {
			// 파일 저장용 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("C:/Users/admin/Documents/연습용/memObj.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			// 쓰기 작업 수행
			System.out.println("객체 저장 시작!!!");
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);
			System.out.println("객체 저장 완료!!!");
			
			// 스트림 닫기
			oout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ObjectInputStream oin = null;
		// 저장된 객체를 읽어와 그 내용을 화면에 출력하기
		
		// 입력용 스트림 객체 생성
		try {
			oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:/Users/admin/Documents/연습용/memObj.bin")));
			
			Object obj;	// 읽어온 객체를 저장할 변수
			
			// readObject() 메서드의 반환값은 Object 형이다.
			// readObject() 메서드가 데이터를 끝까지 다 읽어오면 EOFException 이 발생한다.
			while((obj = oin.readObject()) != null) {
				Member mem = (Member)obj;
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
			}
			
			// 스트림 닫기
			oin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

// 데이터 저장용 클래스 작성
class Member implements Serializable{
	// Serialization(직렬화)
	// 직렬화란? 객체를 직렬화하여 전송 가능한 형태로 만드는 것을 의미한다.
	// 객체들의 데이털르 연속적인 데이터로 변형하여 Stream을 통해 데이터를 읽도록 해준다.
	// 주로 객체들을 통째로 파일로 저장하거나 전송하고 싶을 때 주로 사용한다.
	
	private String name;
	// transient : 직렬화가 되지 않을 인스턴스 변수에 지정한다.(직렬화 시키고 싶지 않은)
	// 			 : 직렬화가 되지 않은 인스턴스 변수는 기본값으로 저장된다.
	private transient int age;
	private transient String addr;
	
	public Member(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
