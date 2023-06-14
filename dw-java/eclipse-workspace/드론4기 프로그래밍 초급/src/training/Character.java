package training;

import java.util.Scanner;

import d_array.Array;

class Character {

	String name;
	int maxHp;
	int maxMp;
	int hp;
	int mp;
	int att;
	int def;
	int level;
	int exp;
	
	Character(String name, int maxHp, int maxMp, int hp, int mp, int att, int def, int level, int exp) {
		this.name = name;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def = def;
		this.level = level;
		this.exp = exp;
	} // 캐릭터 메소드 종료
	
	public void showme() {
		System.out.println("=====================");
		System.out.println("이름 : " + name);
		System.out.println("최대 체력 : " + maxHp);
		System.out.println("최대 마력 : " + maxMp);
		System.out.println("체력 : " + hp);
		System.out.println("마력 : " + mp);
		System.out.println("공격력 : " + att);
		System.out.println("방어력 : " + def);
		System.out.println("레벨 : " + level);
		System.out.println("경험치 : " + exp);
		System.out.println("=====================\n");
	}
	
	void hunt() {
		Monster m = new Monster("고자라니", 10, 10, 10, 10, 1, 1, 1, 10);
		System.out.println("몬스터를 만났습니다.");
		while (true) {
		System.out.println("\n1) 공격한다.\t 2) 도망간다.");
		Scanner s = new Scanner(System.in);
		int inputHunt = Integer.parseInt(s.nextLine());
			if (inputHunt == 1) {
				System.out.println("몬스터를 공격합니다.");
				this.attack(m);
			} else if (inputHunt == 2) {
				System.out.println("몬스터에게서 도망갑니다.\t");
				break;
			}
		} // while 종료
	} // hunt 종료
	
	void attack(Monster m) {
		System.out.println("공격에 성공했습니다.");
		int damage = att -	m.def;
		m.hp = m.hp - damage;
		System.out.println("현재 몬스터의 체력은 " + m.hp + " 입니다.");
		//	몬스터를 공격해도 몬스터의 hp가 감소되지 않는다.
	}
	
	
} // 클래스 종료
