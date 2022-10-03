<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>  
	<%@include file="/resources/includes/link.jsp" %>
	<script type="text/javascript" src="/resources/js/reply.js"> </script>
</head>
<body>
	
	<script>
		console.log(replyService);
		
		var bnoValue = ${board.bno};
		
		
		//단일 댓글 조회	
		
		//replyService.get(6,function(data){console.log(data);})
		
		//댓글 수정 Test
		/*
		replyService.update(
			{rno : 5, bno:bnoValue, reply : "Modified Reply!!!!"},
			function(result){alert("수정완료!");}
		)
		*/
		
		//댓글 삭제 Test	
		/*
		replyService.remove
		(
				4,
				function(count){
					console.log(count);
					if(count==="success"){
						alert("REMOVED");	
					}
				},
				function (err){
					alert('ERROR...');
				} 
		);//remove 함수 끝
		*/
		
		
		//댓글 조회 Test
		/*		
 		replyService.getList(
			{bno:bnoValue,page:1},
			function(list){
				for(i=0,len=list.length||0;i<len;i++){
					console.log(list[i]);
				}
			}
		);	 
		*/
		
		//댓글 추가 Test	
		/* 		
  
  			replyService.add(
			{reply:"JS TEST",replyer:"tester", bno:bnoValue}
			,
			function(result){
				alert("RESULT : " + result);
			}
		); 
		*/
	</script>

	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		$(document).ready(function(){
			
			
			var bnoValue = ${board.bno};
			var replyUL = $(".chat");
			
			 
			showlist(1);	
			function showlist(page){		
				replyService.getList
				(
						{bno:bnoValue,page: page||1},
						function(replyPageDTO){
							str="";
							 
							var replyCnt = replyPageDTO.replyCnt;
							var list = replyPageDTO.list;
							console.log(replyCnt);
							$("#rcnt").html(replyCnt);
							
							
							if(list==null || list.length==0)
							{
								replyUL.html("");
								return ;
							}
							for(i=0,len=list.length||0;i<len;i++){
								str+="<div class='unit form-control' data-rno="+list[i].rno+" >";
								str+="<div class='r-header' >";
								str+="<strong class='primary-font'>"+list[i].replyer+"</strong>";
								str+="<small class='rdate text-muted'>"
								str+="<a  class='rupdatebtn' href='javascript:openupdateform("+list[i].rno+",\""+list[i].reply+"\",\""+list[i].replyer+"\")'>수정</a>&nbsp";
								str+="<a href='javascript:deletereply("+list[i].rno+")'>삭제</a>&nbsp;"
								str+=replyService.displayTime(list[i].replyDate)
								str+="</small>";
								str+="</div>";
								str+="<div class='r-body'>"+list[i].reply+"</div>";
								str+="</div>";
							} 
							replyUL.html(str);
						} //익명 함수 끝
				);	//getList 끝	
			}//showlist 끝	
				
			
			/* 댓글 등록 이벤트 처리  */
			$("#replybtn").on("click",function(e){
				var comment = $("#cmt").val();
				alert(comment);
				var reply=
				{
						reply :comment,
						replyer : 'anonymous',		//임의 계정으로 - 로그인 처리 후 변경할 것 
						bno:bnoValue
				};
				replyService.add(reply,function(result){
					//alert(result);
					$("#cmt").val("");
					showlist(1);	
				})
			})
			
			
		 
			/* 수정 처리  */
			$("#submitbtn").on('click',function(e){
				alert("TEST");		
				e.preventDefault();
				form = document.replyform;
				
				var reply=
				{
					rno : form[0].value,
					reply : form[1].value
				}
				replyService.update(reply,function(result){
					$('#staticBackdrop').modal('hide');
					showlist(1);	
					
				})	
			})	
			/* 수정 처리  */
			
			
			
			
			
		}) //document.ready 끝
		
		
		
		/* 수정 모달 띄우기  */
		function openupdateform(rno,reply,replyer){
			form = document.replyform;	
			form[0].value=rno;
			form[1].value=reply;
			form[2].value=replyer;			
			$('#staticBackdrop').modal('show');
		}
		

		/* 삭제  */
		function deletereply(rno){
			replyService.remove(rno, function(result){} )
			location.reload();
		}
	</script>





<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">댓글 수정	</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form name=replyform>
	      <div class="modal-body">
	       	<input name=rno id=rno class="form-control m-2" placeholder="rno" disabled>
	       	<input name=reply id=reply class="form-control m-2" >
	    	<input name=replyer id=replyer class="form-control m-2" disabled>   	
	     
	      </div>
	      <div class="modal-footer">
	        <button type=submit id=submitbtn class="btn btn-primary" >수정</button>
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	      </div>
       </form>
    </div>
  </div>
</div>
<!-- Modal -->		
			
			


    <div id="wrapper" class="container-md">
        <div id="top-header">
        </div>
        <div id="nav">
      		<%@include file="/resources/includes/nav.jsp" %>
        </div>
      
        
        <style>     
	        .chat::-webkit-scrollbar
			{
				display: none;
			}
			.r-header > .rdate
			{
				display:inline-block;
				 
				text-align:right;
				
			}
			.r-header{
				display:flex;
				justify-content:space-between;
			}
        </style>
        
        <div style="display:flex;justify-content:space-between;">
	       	<!-- 글보기 화면 처리  -->
	        <div id="contents" class='w-50'>
			
				<h1>Board Read Page</h1>		 
					<input class="form-control mt-2" name="title" placeholder="title" value=${board.title} readonly>			 
					<textarea name="content" class="form-control mt-2"  readonly>${board.content} </textarea>
					<input class="form-control mt-2" name="writer"  placeholder="writer" value=${board.writer} readonly>
					<input type=button value="글수정" class="btn btn-primary mt-2" 
					onclick="javascript:location.href='/board/modify?bno=${board.bno}'">
					 
					<input type=button value="리스트" class="btn btn-primary mt-2 move">			 
	        </div>
	         <!-- 댓글처리  -->
			<div  style=width:600px;> 	
	        	<br><br>
	        	<!-- COMMENT -->
	        	<div id=comment>
	        		<textarea class="form-control"  id=cmt placeholder="댓글입력 하세요" style=height:100px;></textarea>
	        	</div>
	        	<div>
	        		<a id=replybtn class="btn btn-primary mt-3">댓글달기</a>
	        	</div>
	        	<!-- INFO -->
	        	<div class="mt-3">
	        	댓글수 : <span id=rcnt></span>
	        	</div>
	        	<!-- REPLYList -->
	        	<div class="chat mt-3"  style='height:310px;overflow:auto;'>
	        		<div class='unit form-control' data-rno="1">    		
		        		<!-- unit -->
			        	<!-- 	
			        			<div class='r-header' >
			        			<strong class='primary-font'>USER00</strong>
			        			<small class='rdate text-muted'>2022-01-01 13:13</small>	
			        		</div>
			        		<div class='r-body'>
			        				REPLY TEST		
			        		</div> 
			        	-->
	        		</div>
	        	</div>
	        </div>
        </div>    
    </div>	
    
 
    
     	<form name="operform" action="/board/list" method="get">
     		<input type="hidden" name="bno" value=${board.bno} >
     		<input type="hidden" name='pageNum' value=${cri.pageNum} >
     		<input type="hidden" name='amount' value=${cri.amount} >
     		<input type="hidden" name='type' value=${cri.type} >
     		<input type="hidden" name='keyword' value=${cri.keyword} >
     	</form>
			
		<script>
			$(document).ready(function(){
				form = document.operform;
				
				$(".move").on("click",function(){
					form.action="/board/list";
					form.submit();
				})			
			})
		</script>	
		
		
		
		<!-- 댓글 form  -->
		
		
		
		
		
</body>
</html>