<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<!-- subMenu에 대한 javascript 템플릿 --> 
<script type="text/x-handlebars-template" id="reply-list-template">
{{#each .}}
<div class="replyLi">
	<img data-target="{{replyer}}" src="{{getPicture replyer}}" class="fas"/>
	<div class="timeline-item">
		<span class="time">
			<i class="fa fa-clock"></i>{{prettifyDate regdate}}
			<a class="btn btn-primary btn-xs" id="modifyReplyBtn" data-rno={{rno}}
				style="display: {{loginUserCheck replyer}}"; data-replyer={{replyer}} data-toggle="modal" data-target="#modifyModal">수 정</a>
		</span>

		<h3 class="timeline-header"><strong style="display:none;">{{rno}}</strong>{{replyer}}</h3>
		<div class="timeline-body" id="{{rno}}-replytext">{{replytext}}</div>
	</div>
</div>
{{/each}}
</script>

<script>


function ShowReply(){
	
	let replyPage = 1;
	
	getPage("<%=request.getContextPath()%>/replies/${board.bno}/" + replyPage);
	
	function getPage(pageInfo){
		$.getJSON(pageInfo, function(data){
			printData(data.replyList, $('#repliesDiv'), $('#reply-list-template'));
			printPaging(data.pageMaker, $('.pagination'));
		});
	};
	
	$('.pagination').on('click', 'li a', function(e){
		e.preventDefault();
		replyPage = $(this).attr("href");
		getPage("<%=request.getContextPath()%>/replies/${board.bno}/" + replyPage);
	});
	
	$('#replyAddBtn').on('click', function(){
		let replyer = $('#newReplyWriter').val();
		let replytext = $('#newReplyText').val();
		
		if(replytext == ""){
			alert("댓글 내용은 필수입니다.");
			$('#newReplyText').focus().css("border-color", "red").attr("placeholder", "내용은 필수입니다.");
			return;
		};
		
		let data = {
				"bno" : "${board.bno}",
				"replyer" : replyer,
				"replytext" : replytext
		};
		
		$.ajax({
			url : "<%=request.getContextPath()%>/replies",
			type : "post",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(data){
				alert("댓글이 등록되었습니다.");
				getPage("<%=request.getContextPath()%>/replies/${board.bno}/" + data);
				$('#newReplyText').val("");
			},
			error : function(error){
				alert("댓글 등록을 실패했습니다.\n관리자에게 문의하세요.");
			}
		});
	});
	
	$('div.timeline').on('click', '#modifyReplyBtn', function() {
		let rno = $(this).attr("data-rno");
		let replyer = $(this).attr("data-replyer");
		let replytext = $('#' + rno + '-replytext').text();
		
		$('#replytext').val(replytext);
		$('.modal-title').text(rno);
	});
	
	/* 디테일 모달에서 수정 버튼 눌렀을때 */
	$('#replyModBtn').on('click', function(){
		let rno = $('.modal-title').text();
		let replytext = $('#replytext').val();
		
		$.ajax({
			url : "<%=request.getContextPath()%>/replies/" + rno,
			type : "PUT",
			data : JSON.stringify({replytext : replytext, rno : rno}),
			contentType : "application/json",
			success : function(result) {
				alert("수정되었습니다.2");
				let curPage = $('#pagination').find('li.active').find('a').text();
				getPage("<%=request.getContextPath()%>/replies/${board.bno}/" + replyPage)
			},
			error : function() {
				alert("수정을 실패했습니다.");
			},
			complete : function() {
				$('#modifyModal').modal('hide');
			}
		})
	});

	$('#replyDelBtn').on('click', function(){
		let rno = $('.modal-title').text();
		let curPage = $('#pagination').find('li.active').find('a').text();
		
		$.ajax({
			url : "<%=request.getContextPath()%>/replies/${board.bno}/" + rno + "/" + curPage,
			type : "DELETE",
			dataType : "text",
			success : function(page){
				alert("삭제되었습니다.");
				getPage("<%=request.getContextPath()%>/replies/${board.bno}/" + page);
			},
			error : function(){
				alert("삭제를 실패했습니다.");
			},
			complete : function(){
				$('#modifyModal').modal('hide');
			}
		});
	});
	
};

Handlebars.registerHelper({
	"getPicture" : function(replyer){
		let data = {id : replyer};
		let src = "<%=request.getContextPath()%>/member/getPicture.do?picture=";
		$.getJSON("<%=request.getContextPath()%>/member/getMemberToJson.do", data, function(result){
			if(result){
				if(result.picture == "" || result.picture == null){
					src	+= "noImage.jpg";	
				}else{
					src += result.picture;
				}
			}else{
				src += "noImage.jpg";
			};
			$('img[data-target="' + replyer + '"]').attr("src", src);
		})
	},
	"loginUserCheck" : function(replyer){
		let result = "none";
		if(replyer == "${loginUser.id}"){
			result = "visible";
		}
		return result;
	},
	"prettifyDate" : function(timeValue){
		let dateObj = new Date(timeValue);
		let year = dateObj.getFullYear();
		let month = dateObj.getMonth() + 1;
		let date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	}
});

function printData(replyList, target, templateObj){
	let template = Handlebars.compile(templateObj.html());
	
	let resultHtml = template(replyList);
	
	$('.replyLi').remove();
	
	target.after(resultHtml);
};

function printPaging(pageMaker, target){
	let str = "";
	
	if(pageMaker.prev){
		str += "<li class='page-item'><a class='page-link' href='" + (pageMaker.cri.page-1)
				+"'> <i class='fas fa-angle-left'></i> </a></li>";
	};
	
	for(let i = pageMaker.startPage; i <= pageMaker.endPage; i++){
		let strClass = pageMaker.cri.page == i ? 'active' : '';
		str += "<li class='page-item " + strClass + "'><a class='page-link' href='" + i + "'>" + i + "</a></li>"; 
	};
	
	if(pageMaker.next){
		str += "<li class='page-item'><a class='page-link' href='" + (pageMaker.cri.page+1)
				+"'> <i class='fas fa-angle-right'></i> </a></li>";
	};
	
	target.html(str);
};


</script>



