package kr.or.dw.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/JsonTestServlet.do")
public class JsonTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");	// json 형태로 내보내겠다는 의미
		
		// 문자열
		String str = "안녕! 문자열만 있는 JSON이다!";
		
		// 배열
		int[] intArr = {111, 222, 333, 444, 555};
		
		// 객체
		Sample sample = new Sample(100, "홍길동");
		
		// List 컬렉션
		List<Sample> sampleList = new ArrayList<>();
		sampleList.add(new Sample(101, "사쿠라"));
		sampleList.add(new Sample(102, "김채원"));
		sampleList.add(new Sample(103, "카즈하"));
		sampleList.add(new Sample(104, "허윤진"));
		sampleList.add(new Sample(105, "홍은채"));
		
		
		// Gson
		// toJson / fromJson 의 단순성
		// DeSerialized, 역직렬화의 경우 Java Entity에 접근할 필요가 없다.
		
		// Jackson
		// Spring Framework 에 내장
		// Annotation 지원
		
		// Gson 객체 생성(Json 타입으로 변환해주는 객체)
		Gson gson = new Gson();
		
		// JSON 형태의 문자열로 변환하기
		String jsonStr = gson.toJson(str);	// 문자열
		System.out.println("jsonStr ==> " + jsonStr);
		
		String jsonArr = gson.toJson(intArr);	// 배열
		System.out.println("jsonArr ==> " + jsonArr);
		
		String jsonObj = gson.toJson(sample);	// 객체
		System.out.println("jsonObj ==> " + jsonObj);
		
		String jsonList = gson.toJson(sampleList);	// List 컬렉션
		System.out.println("jsonList ==> " + jsonList);

		PrintWriter out = resp.getWriter();
//		out.println(jsonStr);	// 응답 데이터가 문자열인 경우
//		out.println(jsonArr);	// 응답 데이터가 배열인 경우
//		out.println(jsonObj);	// 응답 데이터가 객체인 경우
		out.println(jsonList);	// 응답 데이터가 List인 경우
		
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
