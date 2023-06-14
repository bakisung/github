package training;

public class Monster {
	
	String name;
	int maxHp;
	int maxMp;
	int hp;
	int mp;
	int att;
	int def;
	int level;
	int takeExp;
	
	public Monster(String name, int maxHp, int maxMp, int hp, int mp, int att, int def, int level, int takeExp) {
		this.name = name;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def = def;
		this.level = level;
		this.takeExp = takeExp;
	}
	
} // 클래스 종료
