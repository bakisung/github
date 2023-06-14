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
	String que9 = "";
	if(request.getAttribute("evalVo") != null){
		EvaluationVO evalVo = (EvaluationVO) request.getAttribute("evalVo");
		que9 = evalVo.getQue9();
%>
		<script type="text/javascript">
			$(function(){
				$('input[name=que1][value=<%=evalVo.getQue1()%>]').prop('checked',true);
				$('input[name=que2][value=<%=evalVo.getQue2()%>]').prop('checked',true);
				$('input[name=que3][value=<%=evalVo.getQue3()%>]').prop('checked',true);
				$('input[name=que4][value=<%=evalVo.getQue4()%>]').prop('checked',true);
				$('input[name=que5][value=<%=evalVo.getQue5()%>]').prop('checked',true);
				$('input[name=que6][value=<%=evalVo.getQue6()%>]').prop('checked',true);
				$('input[name=que7][value=<%=evalVo.getQue7()%>]').prop('checked',true);
				$('input[name=que8][value=<%=evalVo.getQue8()%>]').prop('checked',true);

			})
		</script>		
		
		
<%
	}
%>

<script>
// 이벤트 추가
	$(function(){
		$('#evaluationLecture').on('submit', function(e){
			if (! $('input[name=que1]:checked').val()) {
				alert('답변이 완료되지 않았습니다.');
				e.preventDefault();
				return false;
			}
			if (! $('input[name=que2]:checked').val()) {
				alert('답변이 완료되지 않았습니다.');
				e.preventDefault();
				return false;
			}
			if (! $('input[name=que3]:checked').val()) {
				alert('답변이 완료되지 않았습니다.');
				e.preventDefault();
				return false;
			}
			if (! $('input[name=que4]:checked').val()) {
				alert('답변이 완료되지 않았습니다.');
				e.preventDefault();
				return false;
			}
			if (! $('input[name=que5]:checked').val()) {
				alert('답변이 완료되지 않았습니다.');
				e.preventDefault();
				return false;
			}
			if (! $('input[name=que6]:checked').val()) {
				alert('답변이 완료되지 않았습니다.');
				e.preventDefault();
				return false;
			}
			if (! $('input[name=que7]:checked').val()) {
				alert('답변이 완료되지 않았습니다.');
				e.preventDefault();
				return false;
			}
			if (! $('input[name=que8]:checked').val()) {
				alert('답변이 완료되지 않았습니다.');
				e.preventDefault();
				return false;
			}
			
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
				<form id="evaluationLecture" method="post" action="<%=request.getContextPath()%>/lecture/evaluationInsert.do">
					<input type="hidden" name="lec_code" value="<%=(String)request.getAttribute("lec_code")%>">
			        <table class="table table-striped table-sm" style="text-align: center;">
			          	<thead>
			          		<tr>
			          			<span style="text-align: left; display:inline;"><%=(String)request.getAttribute("lec_name") %></span><td colspan="6" style="text-align: right;">(1)전혀 그렇지  않다. (2)그렇지 않다. (3)보통이다. (4)그렇다. (5)매우 그렇다.</td>
			          		</tr>
							<tr>
					              <th scope="col">문항</th>
					              <th scope="col">(1)</th>
					              <th scope="col">(2)</th>
					              <th scope="col">(3)</th>
					              <th scope="col">(4)</th>
					              <th scope="col">(5)</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="text-align: left;">1. 강의계획서는 강의 목표, 내용, 방법, 평가 등에 대한 사항을 충분히 안내하였는가?</td>
								<td><input type="radio" name="que1" id="que1" value="1"></td>
								<td><input type="radio" name="que1" id="que1" value="2"></td>
								<td><input type="radio" name="que1" id="que1" value="3"></td>
								<td><input type="radio" name="que1" id="que1" value="4"></td>
								<td><input type="radio" name="que1" id="que1" value="5"></td>
							</tr>
							<tr>
								<td style="text-align: left;">2. 강의 내용은 자신에게 학습 욕구를 불러일으킬만큼 적절한 수준이었는가?</td>
								<td><input type="radio" name="que2" id="que2" value="1"></td>
								<td><input type="radio" name="que2" id="que2" value="2"></td>
								<td><input type="radio" name="que2" id="que2" value="3"></td>
								<td><input type="radio" name="que2" id="que2" value="4"></td>
								<td><input type="radio" name="que2" id="que2" value="5"></td>
							</tr>
							<tr>
								<td style="text-align: left;">3. 이 강의를 통하여 다른 강의에서는 접할 수 없는 새로운 내용을 배울 수 있었는가?</td>
								<td><input type="radio" name="que3" id="que3" value="1"></td>
								<td><input type="radio" name="que3" id="que3" value="2"></td>
								<td><input type="radio" name="que3" id="que3" value="3"></td>
								<td><input type="radio" name="que3" id="que3" value="4"></td>
								<td><input type="radio" name="que3" id="que3" value="5"></td>
							</tr>
							<tr>
								<td style="text-align: left;">4. 강의를 통하여 해당 교과목에 대한 이해(실기능력과 기능)가 개선되었는가?</td>
								<td><input type="radio" name="que4" id="que4" value="1"></td>
								<td><input type="radio" name="que4" id="que4" value="2"></td>
								<td><input type="radio" name="que4" id="que4" value="3"></td>
								<td><input type="radio" name="que4" id="que4" value="4"></td>
								<td><input type="radio" name="que4" id="que4" value="5"></td>
							</tr>
							<tr>
								<td style="text-align: left;">5. 교수는 주요 주제들간의 관계가 드러나도록 내용을 구조화하여 전달하였는가?</td>
								<td><input type="radio" name="que5" id="que5" value="1"></td>
								<td><input type="radio" name="que5" id="que5" value="2"></td>
								<td><input type="radio" name="que5" id="que5" value="3"></td>
								<td><input type="radio" name="que5" id="que5" value="4"></td>
								<td><input type="radio" name="que5" id="que5" value="5"></td>
							</tr>
							<tr>
								<td style="text-align: left;">6. 교수는 열정을 갖고 수업을 진행하였는가?</td>
								<td><input type="radio" name="que6" id="que6" value="1"></td>
								<td><input type="radio" name="que6" id="que6" value="2"></td>
								<td><input type="radio" name="que6" id="que6" value="3"></td>
								<td><input type="radio" name="que6" id="que6" value="4"></td>
								<td><input type="radio" name="que6" id="que6" value="5"></td>
							</tr>
							<tr>
								<td style="text-align: left;">7. 수업시간은 제대로 이루어졌는가?</td>
								<td><input type="radio" name="que7" id="que7" value="1"></td>
								<td><input type="radio" name="que7" id="que7" value="2"></td>
								<td><input type="radio" name="que7" id="que7" value="3"></td>
								<td><input type="radio" name="que7" id="que7" value="4"></td>
								<td><input type="radio" name="que7" id="que7" value="5"></td>
							</tr>
							<tr>
								<td style="text-align: left;">8. 강의 내용이 과목명이랑 부합하는가?</td>
								<td><input type="radio" name="que8" id="que8" value="1"></td>
								<td><input type="radio" name="que8" id="que8" value="2"></td>
								<td><input type="radio" name="que8" id="que8" value="3"></td>
								<td><input type="radio" name="que8" id="que8" value="4"></td>
								<td><input type="radio" name="que8" id="que8" value="5"></td>
							</tr>
							<tr>
								<td colspan="6"  style="text-align: left;">9. 이 강의가 계속 살려 나가야 할 장점과 개선이 필요한 점(또는 다루어 주었으면 하는 주제나 내용, 강의의 진행방식 등)을 구체적으로 기술하시오.</td>
								
							</tr>
							<tr>
								<td colspan="6" style="width: 100%;">
									<textarea style="height: 150px; width: 100%;" name="que9" id="que9" required><%=que9 %></textarea>
								
								</td>
							</tr>
						</tbody>
					</table>
					<div style="float: right;"> 
						<input type="submit" class="btn btn-primary col-md-2" style="width:4em; "value="제출">
					</div>
				</form>
				<br>
			
				
			</div>
		</div>
	</div>
</section>


<%@ include file="../footer.jsp"%>