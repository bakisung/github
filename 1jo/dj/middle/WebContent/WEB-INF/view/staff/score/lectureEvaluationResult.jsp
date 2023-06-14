<%@page import="kr.or.dw.vo.EvaluationVO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="kr.or.dw.vo.BoardVO"%>
<%@page import="kr.or.dw.util.PaginationUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%
	double que1 = 0;
	double que2 = 0;
	double que3 = 0;
	double que4 = 0;
	double que5 = 0;
	double que6 = 0;
	double que7 = 0;
	double que8 = 0;
	if(request.getAttribute("evalAvg") != null){
		EvaluationVO evalAvg = (EvaluationVO)request.getAttribute("evalAvg");
		que1 = Math.round(evalAvg.getAvg_que1()*10)/10.0;
		que2 = Math.round(evalAvg.getAvg_que2()*10)/10.0;
		que3 = Math.round(evalAvg.getAvg_que3()*10)/10.0;
		que4 = Math.round(evalAvg.getAvg_que4()*10)/10.0;
		que5 = Math.round(evalAvg.getAvg_que5()*10)/10.0;
		que6 = Math.round(evalAvg.getAvg_que6()*10)/10.0;
		que7 = Math.round(evalAvg.getAvg_que7()*10)/10.0;
		que8 = Math.round(evalAvg.getAvg_que8()*10)/10.0;
	}
	List<String> que9List = null;
	if(request.getAttribute("que9List") != null){
		que9List = (List)request.getAttribute("que9List");
		
	}
%>

<script>
// 이벤트 추가
	$(function(){
		$('#backBtn').on('click', function(){
			location.href="<%=request.getContextPath()%>/lecture/lectureScoreList.do";
		})
		
	})
</script>


<section class="content">
	<div class="card card-solid">
		<div class="card-body">
<!-- 			<div style="height: 1em; margin: 1em;"> -->
<!-- 				<h2 class="card-title" style="margin: 1em 0em 0em 1.5em; display:inline">강의평가</h2> -->
<!-- 				<div style="float: right; margin-right: 3em;"> -->
					
<!-- 				</div> -->
<!-- 				<hr> -->
<!-- 			</div> -->
<!-- 			<br> -->
			<div class="table-responsive" style="margin: 1em;">
			        <table class="table table-striped table-sm" style="text-align: center;">
			          	<thead>
			          		<tr>
			          			<span style="text-align: left; display:inline;"><%=(String)request.getAttribute("lec_name") %></span><td colspan="6" style="text-align: right;">(1)전혀 그렇지  않다. (2)그렇지 않다. (3)보통이다. (4)그렇다. (5)매우 그렇다.</td>
			          		</tr>
							<tr>
					              <th scope="col">문항</th>
					              <th scope="col">점수평균</th>
					             
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="text-align: left;">1. 강의계획서는 강의 목표, 내용, 방법, 평가 등에 대한 사항을 충분히 안내하였는가?</td>
								<td><%=que1 %></td>
								
							</tr>
							<tr>
								<td style="text-align: left;">2. 강의 내용은 자신에게 학습 욕구를 불러일으킬만큼 적절한 수준이었는가?</td>
								<td><%=que2 %></td>
							</tr>
							<tr>
								<td style="text-align: left;">3. 이 강의를 통하여 다른 강의에서는 접할 수 없는 새로운 내용을 배울 수 있었는가?</td>
								<td><%=que3 %></td>
							</tr>
							<tr>
								<td style="text-align: left;">4. 강의를 통하여 해당 교과목에 대한 이해(실기능력과 기능)가 개선되었는가?</td>
								<td><%=que4 %></td>
							</tr>
							<tr>
								<td style="text-align: left;">5. 교수는 주요 주제들간의 관계가 드러나도록 내용을 구조화하여 전달하였는가?</td>
								<td><%=que5 %></td>
							</tr>
							<tr>
								<td style="text-align: left;">6. 교수는 열정을 갖고 수업을 진행하였는가?</td>
								<td><%=que6 %></td>
							</tr>
							<tr>
								<td style="text-align: left;">7. 수업시간은 제대로 이루어졌는가?</td>
								<td><%=que7 %></td>
							</tr>
							<tr>
								<td style="text-align: left;">8. 강의 내용이 과목명이랑 부합하는가?</td>
								<td><%=que8 %></td>
							</tr>
							<tr>
								<td colspan="2"  style="text-align: left;">9. 이 강의가 계속 살려 나가야 할 장점과 개선이 필요한 점(또는 다루어 주었으면 하는 주제나 내용, 강의의 진행방식 등)을 구체적으로 기술하시오.</td>
							</tr>
							<tr>
								<td colspan="2">문항9 답변</td>
							</tr>
								<%
									if(que9List != null){
									for(int i = 0; i < que9List.size(); i++){
								%>
								<tr>
									<td colspan="2" style="text-align: left;">
										- <%=que9List.get(i) %>
									</td>
								</tr>
								<%
								}}
								%>
						</tbody>
					</table>
					<div style="float: right;"> 
						<input type="button" class="btn btn-primary col-md-2" style="width:6em;" id="backBtn" value="뒤로가기">
					</div>
				<br>
			
				
			</div>
		</div>
	</div>
</section>


<%@ include file="../footer.jsp"%>