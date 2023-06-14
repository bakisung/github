package kr.or.dw.basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		// 사용자로부터 데이터 입력 받기
		String str = JOptionPane.showInputDialog("아무노래나 일단 입력해~~");
		
		System.out.println("입력값 : " + str);
		
		for(int i = 10; i >= 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
