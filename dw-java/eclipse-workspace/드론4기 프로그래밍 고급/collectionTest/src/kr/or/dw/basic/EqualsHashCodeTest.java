package kr.or.dw.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		/*
		 * - equals() 		==> 두 객체의 내용이 같은지 검사하는 연산자
		 * - hashCode()		==> 두 객체의 동일성을 검사하는 연산자
		 * 
		 * - HashSet, HashTable, HashMap 과 같이 Hash로 시작하는 컬렉션들은 객체의
		 *   의미상의 동일성을 비교하기 위해서 hashCode() 메서드를 호출하여 비교한다.
		 *   그러므로, 객체가 같은지 여부를 결정하려면 hashCode() 메서드를 재정의 해야한다.
		 *  
		 * - hashCode() 메서드에서 사용하는 '해싱 알고리즘'은 서로 다른 객체들에 대해서 같은
		 *   hashCode를 나타낼 수도 있다.
		 */
		
		Person p1 = new Person("홍길동");
//		p1.setId(1);
//		p1.setName("홍길동");
		
		Person p2 = new Person("홍길동");
//		p2.setId(1);
//		p2.setName("홍길동");
		
		System.out.println(p1 == p2);		// 참조값(번지)이 들어가는 거라서 false
		System.out.println(p1.equals(p2));	// equals는 '==' 으로 비교한다.
		
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		
//		List<Person> persons = new ArrayList<>();
//		persons.add(new Person("성춘향"));
//		persons.add(new Person("성춘향"));
//		System.out.println(persons.size());
		
		Set<Person> persons = new HashSet<>();
		persons.add(new Person("성춘향"));
		persons.add(new Person("성춘향"));
		System.out.println(persons.size());
		// hashCode를 equals 메서드와 함께 재정의하지 않으면 코드가 예상과 다르게 작동하는
		// 문제를 일으킨다. 정확히 말하면 hash 값을 사용하는 Collection(HashSet, HashMap, HashTable)을 사용할 때 문제가 발생한다.
		// 왜 그럴까? ==> hash 값을 사용하는 Collection은 객체가 논리적으로 같은 비교할 때 
		// 우선적으로 hashCode() 리턴값을 확인하고 같으면 equals() 리턴값을 확인한다.
		
		
		
	}

}

class Person {
	private String name;
	private int id;
	
	Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		// hash 값을 어떻게 생성해야 균등한지 분포도가 좋은지는 알기 어려우며 거의 수학적 영역에 가깝다.
		// 위의 코드는 정형화된 hashCode를 만들어주는 코드이다.
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Person person = (Person)obj;
		return person.name.equals(name);
	}
	
	
	
}
