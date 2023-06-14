package GameProject;

import java.util.Scanner;

import d_array.Array;
import myGame2.Item;

public class Main {

	static boolean power; // 전원
	static String input;
	static String username; // 유저 이름
	static String user; // 주인공
	static String boss; // 보스
	static Scanner s = new Scanner(System.in);
	static int tv = 0;
	static int userHp;
	static int bossHp;
	int bosschoice;
	int maxHp = 10;
	int potion;
	
	// 유저 능력치
	int att = 2;
	int def = 1;
	int hp = 10;
	Item[] items;
	
	// 아이템 목록
	int 장화신은고양이의장화;
	int 무하마드알리익스프레스에서구입한장난감칼;
	int 그어떤창에도뚫려버리는방패;
	int 돌대가리로만들어주는초강력투구;
	int 어좁이로만들어주는견장;
	int 헐크의피부색;
	int 피로얼룩진체게바라의ak47;
	int 둔산동헌팅포차에서발견한키높이깔창;
	int 상온에일주일간방치한싱싱한광어회;
	
	// 클리어 횟수
	int life = 1;
	
	// 유저 스탯 플러스
	void userStatPlus() {
		this.att += 1;
		this.def += 1;
		this.maxHp += 1;
		System.out.println("최대 체력, 공격력, 방어력이 모두 1씩 증가합니다.");
	}
	
	// 유저 스텟 조회
	void userStat() {
		System.out.println("\n[" + username + "의 현재 능력치]\n"
				+ "최대 체력 : " + maxHp + "\n"
				+ "공격력 : " + att + "\n"
				+ "방어력 : " + def + "\n\n"
				+ "[장착 아이템 목록]\n");
	}
	
	// 물약
	static void potion() {
		userHp += 10;
		System.out.println("현재 HP는 " + userHp + " 입니다.");
	}
	
	// 보스 스텟 설정
	void bossStat() {
		att = 2;
		def = 1;
		hp = 10;
//		String[] item = new String[10];
	}
	
	// 아이템 목록
	void itemList() {
		
	}
	
//============================================보스 공격 방어=======================================

	void bosschoice() {
		bosschoice = (int)(Math.round(Math.random()));
		System.out.println(bosschoice); // 보스가 공격(0)과 방어(1)를 랜덤으로 선택한다.
	}
	
	
//============================================전원============================================
	
	static void power() {
		String powerOnOff = s.nextLine();
		if (powerOnOff.equals("start")) {
			System.out.println("게임이 시작됩니다.\n\n\"name\"을 입력하면 이름 설정창으로 넘어갑니다.");
			power = true;
		} else if (powerOnOff.equals("end")) {
			System.out.println("게임이 꺼집니다. 꺼지세요.");
			power = false;
		}
		
	}
	
//============================================유저 이름============================================
	
	static void userName() {
		System.out.println("사용할 이름을 입력하세요.");
		String userName = s.nextLine();
		System.out.println("당신의 이름은 " + userName + " 입니다.\n");
		Main.username = userName;
		System.out.println("stage_1을 입력하여 게임을 진행하세요.");
	}
	
//============================================다음============================================
	
	static void next() {
		System.out.println("\n\t\t\t다음 (n)");
	}
	
//============================================스테이지 1============================================
	
	void stage_1() {
		System.out.println("인생 " + life + "회차");
		System.out.println("\nㅡ stage_1 : 고통의 시작 ㅡ\n"
				+ "내 이름은 " + "\"" + username + "\"" + " dw 아카데미의 학생이다.\n"
				+ "내가 dw 아카데미에 첫발을 들인건 2023년 3월..\n"
				+ "지금으로부터 8년전이었다..\n"
				+ "개백수였던 나는 먹고 살길을 찾아 이곳에 왔다..");
		Main.next();
		String inputstage = s.nextLine();
		for ( ; ; ) {
			if (inputstage.equals("n")) {
				System.out.println("오전 8시.. 알람이 울린다..\n오늘은 월요일.. 학원을 어떻게하지?\n"
						+ "1)다시 잔다. 2)ㅈ같지만 일어나서 준비한다.\n\n"
						+ "\t\t\t입력 (1, 2)");
				String inputstage2 = s.nextLine();
				if (inputstage2.equals("1")) {
					System.out.println("다시 생각해\n");
				} else if (inputstage2.equals("2")) {
					System.out.println("(우당탕탕)\n\n\n..\n\n\n나갈 준비는 끝났다.. 뭘 타고 갈까?\n"
							+ "교통 수단을 선택하세요.\n"
							+ "1)차를 가져간다. 2)지하철을 이용한다.\n\n"
							+ "\t\t\t입력 (1, 2)");
					String inputstage3 = s.nextLine();
					if (inputstage3.equals("1")) {
						System.out.println("차가 없으므로 지하철을 이용한다.\n");
						break;
					} else if (inputstage3.equals("2")) {
						System.out.println("지하철을 이용한다.\n");
						break;
					}
				}
			}
		} // for 종료
		System.out.println("stage_2를 입력하면 게임을 진행합니다.");
	}

//============================================스테이지 2============================================
	
	void stage_2() {
		System.out.println("\nㅡ stage_2 : 오전09시08분 ㅡ\n"
				+ "\n학원에 도착해버렸다.. 지문을 찍고 드론 21기 교실로 들어선다.\n"
				+ "클래스를 이해하지 못한 나는 8년째 재수강을 하고 있다..\n"
				+ "이제 그만 수료를 하고 싶다..");
		Main.next();
		String inputstage = s.nextLine();
		if (inputstage.equals("n")) {
			System.out.println("드론4기때 처음만났던 김진용 선생님은 나 때문에\n"
					+ "8년째 클래스 수업만 하고 계신다..\n"
					+ "언제나처럼 아침이면 선생님께서 내게 물으신다.\n");
			Main.next();
			String inputstage2 = s.nextLine();
			if (inputstage2.equals("n")) {
				for ( ; ; ) {
				System.out.println("김진용 선생님 : " + username + "님 복습했어요 안했어요\n"
						+ "1)했다고 구라를 친다. 2)안했다고 솔직하게 말씀드린다.\n\n"
						+ "\t\t\t입력 (1, 2)");
				String inputstage3 = s.nextLine();
				
					if (inputstage3.equals("1")) {
						System.out.println("김진용 선생님 : 솔직히 말하세요.\n");
						
					} else if (inputstage3.equals("2")) {
						System.out.println("김진용 선생님 : ㅂㅅ.. 수업 시작합시다.\n");
						break;
					}
				}
				System.out.println("stage_3를 입력하면 게임을 진행합니다.");
			}
		}
	}
	
//============================================스테이지 3============================================

	void stage_3() {
		System.out.println("\nㅡ stage_3 : 취침 ㅡ\n"
				+ "\n클래스는 ... 인스턴스는...\n지역변.. 전역..#$%^&@\n\n"
				+ "선생님의 목소리가 희미해져간다..\n");
		Main.next();
		String inputstage = s.nextLine();
		if (inputstage.equals("n")) {
			System.out.println("선생님..\n"
				+ "오늘도 죄송합니다..\n"
				+ "저는 오늘도 자신과의 싸움에서 졌습니다..\n"
				+ "드론 22기때 뵙겠습니다..\n\n"
				+ "zZzZ..");
		}
		Main.next();
		String inputstage2 = s.nextLine();
		
			if (inputstage2.equals("n")) {
				System.out.println("얼마나 잤을까..\n\n"
						+ "김진용 선생님 : " + username + "님.." + username + "님!!\n"
								+ "더 이상 안되겠습니다.\n");
				Main.next();
				String inputstage3 = s.nextLine();
				if (inputstage3.equals("n")) {
					for ( ; ; ) {
					System.out.println("오늘 클래스를 이용해서 TV 30대 만들어오세요.\n"
								+ "이제 그만 수료해야죠..!\n"
								+ "1)거절한다. 2)TV를 만든다.");
					String inputstage4 = s.nextLine();
					
						if (inputstage4.equals("1")) {
							System.out.println("\n거절 그딴거 없다.\n");
						} else if (inputstage4.equals("2")) {
							System.out.println("\n네 알겠습니다..\n"
									+ "어디 한번 만들어보자..\n");
							break;
						}
					} // for 종료
				}
			}
		System.out.println("stage_4를 입력하면 게임을 진행합니다.");
	}

//============================================스테이지 4============================================
	
	void stage_4() {
		tv = 0;
		
		System.out.println("\nㅡ stage_4 : TV 제조업 ㅡ \n\n"
				+ "TV 30대를 만들자.\n\n"
				+ "making tv를 입력하면 tv 1개를 만든다.\n"
				+ "현재 TV의 개수는 " + tv + "대 입니다.");
		
		for ( ; ; ) {
			String inputstage = s.nextLine();
			if (tv >= 29) {
					System.out.println("30대 다 만들었다..\n"
							+ "선생님.. 다 했습니다..");
					break;
			} else if (inputstage.equals("making tv")) {
				System.out.println("tv 1대를 완성하였습니다");
				tv++;
				System.out.println("현재 TV의 개수는 " + tv + "대 입니다.");
			}
		}
		Main.next();
		
		String inputstage2 = s.nextLine();
		if (inputstage2.equals("n")) {
			System.out.println("김진용 선생님 : 이제 런닝머신 100대를 만드세요.\n"
					+ username + " : 아니 TV 30대 다 만들었으면 됐잖아요.\n");
			Main.next();
			String inputstage3 = s.nextLine();
				if (inputstage3.equals("n")) {
					for ( ; ; ) {
					System.out.println("김진용 선생님 : 지금 저에게 도전하는건가요?\n" 
							+ "1)결투를 신청한다. 2)런닝머신 100대를 만든다.\n\n"
							+ "\t\t\t입력 (1, 2)");
					String inputstage4 = s.nextLine();
						
							if (inputstage4.equals("1")) {
								System.out.println("죄송합니다 선생님..\n" 
										+ "이렇게된 이상..\n"
										+ "선생님을 쓰러트리고 수료 하겠습니다..\n"
										+ "결투를 신청합니다.\n");
								break;
							} else if(inputstage4.equals("2")) {
								System.out.println("다시 생각해보자..\n");
							}
					}
				}
				System.out.println("boss_stage를 입력하면 게임을 진행합니다.");
		}
		
		
		
	}
	
//============================================보스 스테이지============================================

	void boss_stage() {
		System.out.println("\nㅡ boss_stage : 하극상 ㅡ \n\n"
				+ "보스 스테이지 설명입니다.\n\n"
				+ "보스의 체력은 10이다.\n"
				+ "양측은 매턴마다 공격과 방어를 선택할 수 있다.\n"
				+ "공격과 방어 모두 시전할때마다 체력 -1\n"
				+ "공격 성공시 나의 공격력 만큼 상대방의 체력이 감소한다.\n"
				+ "방어에 성공하면 체력 +1.\n\n"
				+ "결투를 시작합니다.\n"
				+ "야생의 김진용 선생님이 나타났다!\n"
				+ "0)공격 1)방어\n\n"
				+ "\t\t\t입력 (0, 1)\n\n");
		
		// 공격 : 0
		// 방어 : 1
		
		bossHp = 10;
		userHp = maxHp;
		
		for ( ; ; ) {
			int inputstage = Integer.parseInt(s.nextLine());
			bosschoice();
			
			if (userHp <= 0) {
				System.out.println("you die..\n당신의 패배입니다.\n\n"
						+ "드론 22기를 노려보자..");
				break;
			} else if(bossHp <= 0) {
				System.out.println("\n=====당신이 승리했습니다!=====\n\n");
				System.out.println("김진용 선생님의 노트북을 획득했다!\n");
				userStatPlus();
				life += 1;
				userStat();
//				if (userHp) {
//					
//				}
//				userHp = 
				System.out.println("\n1)획득한 아이템을 소지한 상태로 다시 플레이합니다.\n"
						+ "2)엔딩 진행 후 게임이 종료됩니다.\n\n"
						+ "\t\t\t입력 (1, 2)");		
				
				String inputstage2 = s.nextLine();
				if (inputstage2.equals("2")) {
					Main.ending();
					break;
				} else if (inputstage2.equals("1")) {
					System.out.println("이어서 플레이 합니다.\n\n"
							+ "stage_1을 입력하여 게임을 진행해주세요.");
					break;
				}
			} else if (inputstage == 0) {
				System.out.println("공격을 선택했습니다.\n"
						+ "나의 체력이 1만큼 감소합니다.");
				userHp -= 1;
				System.out.println(username + " 체력 : " + userHp);
				if (bosschoice == 0) {
					System.out.println("\n김진용 선생님은 공격을 선택했습니다.\n"
							+ "김진용의 체력이 1만큼 감소합니다.");
					bossHp -= 1;
					System.out.println("김진용 체력 : " + bossHp + "\n");
					
					System.out.println("서로의 공격이 통했습니다!");
					userHp -= 2;
					bossHp -= att;

					System.out.println("ㅡ 최종 체력 ㅡ\n" + username + "체력 : " + userHp);
					System.out.println("김진용 체력 : " + bossHp);
					System.out.println("\n0)공격 1)방어");
	
				} else if (bosschoice == 1) {
					System.out.println("김진용 선생님은 방어를 선택했습니다.\n"
							+ username + "님의 공격이 먹히지 않았습니다.\n"
									+ "김진용이 방어에 성공해 체력을 1만큼 회복합니다.\n");
					System.out.println("ㅡ 최종 체력 ㅡ\n" + username + "체력 : " + userHp);
					System.out.println("김진용 체력 : " + bossHp);
					System.out.println("\n0)공격 1)방어");
				}
			} else if (inputstage == 1) {
				System.out.println("방어를 선택했습니다.\n"
						+ "나의 체력이 1만큼 감소합니다.");
				userHp -= 1;
				System.out.println(username + " 체력 : " + userHp + "\n");
				if (bosschoice == 0) {
					System.out.println("김진용 선생님은 공격을 선택했습니다.\n"
							+ "김진용의 체력이 1만큼 감소합니다.");
					bossHp -= 1;
					System.out.println("김진용 체력 : " + bossHp + "\n");
					
					System.out.println(username + "님이 방어에 성공하셨습니다!\n"
							+ "나의 체력이 1만큼 증가합니다.\n");
					userHp += 1;
					System.out.println("ㅡ 최종 체력 ㅡ\n" + username + "체력 : " + userHp);
					System.out.println("김진용 체력 : " + bossHp);
					System.out.println("\n0)공격 1)방어");
				} else if (bosschoice == 1) {
					System.out.println("김진용 선생님은 방어를 선택했습니다.\n"
							+ "김진용의 체력이 1만큼 감소합니다\n");
					bossHp -= 1;
					System.out.println("김진용 체력 : " + bossHp + "\n");

					System.out.println("서로 방어를 선택해 아무일도 일어나지 않았습니다.\n");
					System.out.println("ㅡ 최종 체력 ㅡ\n" + username + "체력 : " + userHp);
					System.out.println("김진용 체력 : " + bossHp);
					System.out.println("\n0)공격 1)방어");
				} // else if 종료
			} // if 종료
		} // for 종료
		userHp = maxHp;
	}
//==============================================엔딩===============================================

	static void ending() {
		System.out.println("\n\n\n\n\n\n\n\n\n==========엔딩==========\n"
				+ "\n\n\n\n\n클래스를 이해하려 8년간 노력했지만 결국 실패했다..\n"
				+ "하지만 난 김진용 선생님을 제거했고 이젠 미련없이 dw 아카데미를 떠나려 한다..\n\n"
				+ "이제 내 앞길엔 어떤일이 기다리고 있을까?\n\n"
				+ "아디오스.... DW.... (찡긋)\n\n\n\n\n\n\n\n\n"
				+ "Credit\n\n"
				+ "제작 : 박희성\n"
				+ "기획 : 박희성\n"
				+ "편집 : 박희성\n"
				+ "유통 : 박희성\n"
				+ "작사 : 박희성\n"
				+ "율동 : 박희성\n\n"
				+ "end..");
	}
	
//============================================메인==================================================

	
	public static void main(String[] args) {
	
		Main main = new Main();
		
		// 게임 시작 안내
		System.out.println("ㅡ DW 아카데미 탈출하기 : 레저렉션 ㅡ\n\"start\"를 입력하면 게임이 시작됩니다.");
		
		// 전원
		main.power();
		String inputUserName = s.nextLine();
		// 유저 이름 설정
		main.userName();
		// start 입력 -> 반복문 시작
		while (power) {
			String inputStage = s.nextLine();
			if (inputStage.equals("stage_1")) {
				main.userStat();
				main.stage_1();
			} else if (inputStage.equals("stage_2")) {
					main.stage_2();
			} else if (inputStage.equals("stage_3")) {
				main.stage_3();
			} else if (inputStage.equals("stage_4")) {
				main.stage_4();
			} else if (inputStage.equals("boss_stage")) {
				main.userStat();
				main.boss_stage();
			}
		} // while 종료
		
	} // main 종료

} // class 종료

/* 에로사항
 * 1. start를 입력하여 게임을 시작한 후 바로 입력한 텍스트를 username으로 하고 싶은데 안되서 name을 입력받아 다음으로 넘어가야 username을 입력 받을 수 있게 하였다.
 * 2. 보스 스테이지 클리어 후 이어서 다시 시작할 경우 능력치+1을 적용하여 계속 진행되게끔 하였고 stage_4의 만든 tv대수는 초기화하여 0부터 다시 만들게끔 하였다.
 * 3. 체력의 경우 보스 스테이지에서 입은 데미지 만큼 깎여있는 상태로 이어서 플레이하게 되므로 보스 스테이지가 끝나면 다시 maxhp로 수치를 바꿔주었다.
 */




