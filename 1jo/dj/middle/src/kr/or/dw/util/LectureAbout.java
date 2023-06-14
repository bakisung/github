package kr.or.dw.util;

import java.util.List;

import kr.or.dw.vo.LectureVO;

public class LectureAbout {
	
	public List<LectureVO> listOrderDesc(){
		return null;
		
	}
	
	public double numGrade(String stu_grade, int lec_credit) {
		double numGrade = 0;
		if(stu_grade.equals("A+")){
			numGrade = 4.5 * lec_credit;
		}else if(stu_grade.equals("A")){
			numGrade = 4.0 * lec_credit;
		}else if(stu_grade.equals("B+")){
			numGrade = 3.5 * lec_credit;
		}else if(stu_grade.equals("B")){
			numGrade = 3.0 * lec_credit;
		}else if(stu_grade.equals("C+")){
			numGrade = 2.5 * lec_credit;
		}else if(stu_grade.equals("C")){
			numGrade = 2.0 * lec_credit;
		}else if(stu_grade.equals("D+")){
			numGrade = 1.5 * lec_credit;
		}else if(stu_grade.equals("D")){
			numGrade = 1.0 * lec_credit;
		}else if(stu_grade.equals("P")){
			numGrade = 4.5 * lec_credit;
		}else{
			numGrade = 0.0;
		}
		return numGrade;
		
	}
}
