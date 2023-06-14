package e_oop.myGame;

public class Skill {

	String[] skills = {"마이너스통장가입해버리기", "초등학생삥뜯기", "은행털기", "사채쓰기", "엄카쓰기"};
	
	String skillInfoList(int level) {
		String skillList = " ";
		for (int i = 0; i < level; i++) {
			skillList += (i + 1) + ". " + skills[i] + " ";
		}
		return skillList;
	}

	public int skillUtil(int input) {
		int money = 0;
		
		if (input == 0) {
			money += 1000;
		} else if(input == 1) {
			money += 5000;
		} else if(input == 2) {
			money += 10000;
		} else if(input == 3) {
			money += 50000;
		} else if(input == 4) {
			money += 100000;
		}
		
		return money;
	}
}
