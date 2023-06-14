package f_oop2;

public class Starcraft {

	public static void main(String[] args) {
		
		MArine marine = new MArine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
//		scv.repair(marine);
		
	}

}

class Unit {
	int hp; // 체력
	final int MAX_HP; // 최대 체력
	
	Unit(int hp){
		MAX_HP = hp;
		this.hp = hp;
	}
}

class MArine extends Unit {

	MArine() {
		super(40);
	}
	
}

class Tank extends Unit implements Repairable {
	
	Tank() {
		super(150);
	}
}

class Dropship extends Unit implements Repairable {

	Dropship() {
		super(200);

	}
	
}

class SCV extends Unit implements Repairable {

	SCV() {
		super(50);

	}
	
	void repair(Repairable r) {
		if (r instanceof Unit) { // Unit으로 형변환이 가능한지 확인
			Unit u = (Unit) r;
			
			while(u.hp < u.MAX_HP) {
				u.hp++;
			}
		}
	}
	
}

interface Repairable {};
























