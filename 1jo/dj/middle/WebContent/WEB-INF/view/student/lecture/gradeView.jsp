<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@page import="kr.or.dw.util.LectureAbout"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="kr.or.dw.vo.LectureVO"%>
<%@page import="java.util.List"%>
<title>성적조회</title>
<script>
	$(function() {
		$('select[name=yearTerm]').change(
				function() { //년도와 학기 선택하면 해당 년도와 학기의 성적만 보이는 함수
					for (let i = 0; i < $('tr[type=var]').length; i++) {
						if ($(this).val() == 'select') {
							$('tr[type=var]').css('display', 'none');
							$('#none').css('display', '');
						} else if ($(this).val() == $($('tr[type=var]')[i])
								.attr('name')) {
							$($('tr[type=var]')[i]).css('display', '');
							$('#none').css('display', 'none');
						} else {
							$($('tr[type=var]')[i]).css('display', 'none');
							$('#none').css('display', 'none');
						}
					}
				});
	})
</script>
<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div style="height: 2em;">
				<h3 class="card-title">성적조회</h3>
				<select id="yearTerm" name="yearTerm">
					<option name="year" value="select">학기선택</option>
					<%
								List<LectureVO> lecList = (List) request.getAttribute("lecList"); //학생이 수강한 년도만 보이게
	
								Set<String> yearTermList = new HashSet<>();
								for (LectureVO vo : lecList) {
									String yearTerm = vo.getLec_year() + "년 " + vo.getLec_term() + "학기";
									yearTermList.add(yearTerm);
								}
								;
								for (String yearTerm : yearTermList) {
								%>
					<option name="year" value="<%=yearTerm%>"><%=yearTerm%></option>
					<%
								}
								%>
	
					<%
								double numGrade = 0;
								LectureAbout la = new LectureAbout();
	
								Set<List> yearTermDiv = new HashSet<>();
								for (String yearterm : yearTermList) {
									int creditSum = 0;
									double gradeSum = 0;
									int excPCredit = 0;
									for (LectureVO vo : lecList) {
	
										if (yearterm.equals(vo.getLec_year() + "년 " + vo.getLec_term() + "학기")) {
	
											numGrade = la.numGrade(vo.getStu_grade(), vo.getLec_credit());
											creditSum += vo.getLec_credit();
											gradeSum += numGrade;
											if(!vo.getStu_grade().equals("P") && !vo.getStu_grade().equals("NP")){
												excPCredit += vo.getLec_credit();
											}
										}
									}
									List list = new ArrayList();
									list.add(0, yearterm);
									list.add(1, creditSum);
									list.add(2, gradeSum);
									list.add(3, Math.round((gradeSum / excPCredit)*100)/100.0);
									yearTermDiv.add(list);
								}
								%>
				</select> <br> <br>
			</div>
			<div class="table-responsive" style="margin: 3em;">
		        <table class="table table-striped table-sm" style="text-align: center;">
		          <thead>
		            <tr>
		              <th scope="col">강의명</th>
		              <th scope="col">교수명</th>
		              <th scope="col">구분</th>
		              <th scope="col">학점</th>
		              <th scope="col">등급</th>
		              <th scope="col">평점</th>
		              <th scope="col">평균</th>
		            </tr>
		          </thead>
		          <tbody>
						<tr>
							<td style="text-align: center" colspan="7" id="none">
								데이터가 없습니다.
							</td>
						</tr>
						<%
						for (LectureVO vo : lecList) {
							numGrade = la.numGrade(vo.getStu_grade(), vo.getLec_credit());
						%>
							<tr type="var" name="<%=vo.getLec_year()%>년 <%=vo.getLec_term()%>학기" style="white-space:nowrap; text-align: center; height: 30px; display: none;">
								<td><%=vo.getLec_name()%></td>
								<td><%=vo.getStaff_name()%></td>
								<td><%=vo.getLec_div()%></td>
								<td><%=vo.getLec_credit()%></td>
								<td><%=vo.getStu_grade().equals("null") ? "" : vo.getStu_grade()%></td>
								<td><%=vo.getStu_score() * vo.getLec_credit() == 0 ? "아직 데이터가 없습니다." : numGrade%></td>
								<td></td>
							</tr>
						<% } %>
						<%
						for (List l : yearTermDiv) {
						%>
							<tr type="var" name="<%=l.get(0)%>" style="white-space:nowrap; text-align: center; height: 30px; display: none;">
								<td scope="col"><strong><%=l.get(0)%> 성적 소계</strong></td>
								<td style="width: 15%"></td>
								<td style="width: 15%"></td>
								<td style="width: 10%"><%=l.get(1)%></td>
								<td style="width: 10%"></td>
								<td style="width: 10%"><%=l.get(2)%></td>
								<td style="width: 20%"><%=l.get(3)%></td>
							</tr>
						<%	} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</section>
<%@ include file="../footer.jsp"%>