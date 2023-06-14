package i_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Board_p {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<HashMap<String, Object>> boardList = new ArrayList<>();
		while (true) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			// boardList 가 올 부분
			for (int i = 0; i < boardList.size(); i++) {
				HashMap<String, Object> board = boardList.get(i);
				System.out.println(board.get("board_no") + "\t"
						+ board.get("title") + "\t"
						+ board.get("content") + "\t"
						+ board.get("reg_date"));
			}
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("1. 조회\t2. 등록\0. 종료");
			System.out.print("입력> ");
			int input = Integer.parseInt(sc.nextLine());

			switch (input) {
				case 1:
					read(boardList);
					break;
				case 2:
					insert(boardList);
					break;
				case 0:
					System.out.println("프로그램이 종료되었습니다.");
					System.exit(0);
					break;
				default:
					break;
			}
		}
	}

	private static void read(ArrayList<HashMap<String, Object>> boardList) {
		System.out.print("게시글 번호 입력> ");
		String bn = sc.nextLine();

		HashMap<String, Object> temp = new HashMap<>();
		for (int i = 0; i < boardList.size(); i++) {
			temp = boardList.get(i);
			if (temp.get("board_no").equals(bn)) {
				break;
			}else {
				temp = null;
			}
		}

		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		if(temp != null) {
			System.out.println("번호\t: " + temp.get("board_no"));
			System.out.println("제목\t: " + temp.get("title"));
			System.out.println("내용\t: " + temp.get("content"));
			System.out.println("작성자\t: " + temp.get("user"));
			System.out.println("작성일\t: " + temp.get("reg_date"));
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("1. 수정\t2. 삭제\t0. 목록");
			System.out.print("입력> ");
			int input = Integer.parseInt(sc.nextLine());
			
			switch (input) {
			case 1:
				update(temp);
				break;
			case 2:
				delete(boardList, temp);
				break;
			case 0:
//				temp = new HashMap<>();
				break;
			default:
				break;
			}
		}else {
			System.out.println("해당하는 글번호의 글이 없습니다!!");
		}

	}

	private static void delete(ArrayList<HashMap<String, Object>> boardList, HashMap<String, Object> temp) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).get("board_no").equals(temp.get("board_no"))) {
				boardList.remove(i);
				System.out.println("삭제가 완료되었습니다.");
				break;
			}
		}

	}

	private static void update(HashMap<String, Object> temp) {
		System.out.print("제목> ");
		String title = sc.nextLine();
		System.out.print("내용> ");
		String content = sc.nextLine();

		temp.put("title", title);
		temp.put("content", content);

		System.out.println("수정이 완료되었습니다.");
	}

	private static void insert(ArrayList<HashMap<String, Object>> boardList) {
		System.out.print("번호> ");
		String boardNo = sc.nextLine();
		System.out.print("제목> ");
		String title = sc.nextLine();
		System.out.print("내용> ");
		String content = sc.nextLine();
		System.out.print("이름> ");
		String user = sc.nextLine();

		HashMap<String, Object> temp = new HashMap<>();
		temp.put("board_no", boardNo);
		temp.put("title", title);
		temp.put("content", content);
		temp.put("user", user);
		temp.put("reg_date", new SimpleDateFormat("yy/MM/dd a hh:mm").format(new Date()));

		boardList.add(temp);
		System.out.println("게시물 등록이 완료되었습니다.");

	}

}
