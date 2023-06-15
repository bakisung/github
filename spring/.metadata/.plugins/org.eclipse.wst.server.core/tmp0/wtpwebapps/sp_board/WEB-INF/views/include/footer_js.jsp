<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<!-- subMenu에 대한 javascript 템플릿 --> 
<script type="text/x-handlebars-template" id="subMenu-list-template">
{{#each .}}
	<li class="nav-item">
		<a href="javascript:goPage('{{murl}}', '{{mcode}}');" class="nav-link">
			<i class="{{micon}}"></i>
			<p>{{mname}}</p>
		</a>
	</li>
{{/each}}
</script>
<script>
	function printData(subMenuList, target, templateObj){
		let template = Handlebars.compile(templateObj.html());
		
		let resultHtml = template(subMenuList);
		
		target.html(resultHtml);
	}

	function subMenu(mcode){
		if(mcode != 'M000000'){
			$.ajax({
				url : "<%=request.getContextPath()%>/common/subMenu.do?mcode="+mcode,
				dataType : "json",
				success : function(data){
					printData(data, $('.subMenuList'), $('#subMenu-list-template'));
				},
				error : function(res){
					alert(res.status);
				}
			});
		}else{
			$('.subMenuList').html('');
		}
	};
	
	function goPage(murl, mcode){
		// HTML5 부터 history API를 사용하기 시작함
		// 주소 내역은 하나의 목록이다. 뒤로가기, 앞으로가기는 목록 안에서 이동하는 것이다.
		// 따라서 목록에 새로운 주소를 추가하면 페이지를 이동한 셈이 된다.
		// 목록에 주소를 추가하기 위한 메서드가 HTML5에서 생겼다.
		if(typeof(history.pushState) == 'function'){
			let renewURL = location.href;
			renewURL = renewURL.substring(0, renewURL.indexOf(".do") + 3);
			
			if(mcode != 'M000000'){
				renewURL += "?mcode=" + mcode;
			};
			console.log(renewURL);
			
			// 기본 형태 - history.pushState(state, title, url);
			// state : 브라우저 이동 시 넘겨줄 데이터
			// title : 변경할 브라우저 제목(변경 원치 않으면 null)
			// url : 변경할 주소
			history.pushState(mcode, null, renewURL);
		};
		$('#if_list').attr('src', '<%=request.getContextPath()%>' + murl);		
		
	};
	
	
	
	
	
</script>