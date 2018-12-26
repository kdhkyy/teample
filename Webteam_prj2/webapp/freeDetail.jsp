<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/include/header.jsp" %> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
$(document).ready(function(){
	console.log("Ang!");
	//댓글추가 
	
	$("#regBtn").click(function(){
        var freeComText = $("#freeComText").val();
        var freeSeq = $(RES_VO.fSeq).val();
        console.log(freeSeq);
        if(freeComText == ""){
           alert("내용을 입력하세요");
           $("#freeComText").focus();
           return false;
        }
        $("#insertForm").submit();
    });

	
	
}); 



</script>
</head>
  <body>
    <div id="all">
    <%@ include file="/include/topbar.jsp" %>
    <%@ include file="/include/loginmadal.jsp" %>
    <%@ include file="/include/navbar.jsp" %> 
      
      <div id="heading-breadcrumbs" class="brder-top-0 border-bottom-0">
        <div class="container">
          <div class="row d-flex align-items-center flex-wrap">
            <div class="col-md-7">
              <h1 class="h2">자유게시판</h1>
            </div>
            <div class="col-md-5">
              <ul class="breadcrumb d-flex justify-content-end">
                <li class="breadcrumb-item"><a href="index.jsp">게시판</a></li>
          		<li class="breadcrumb-item"><a href="freelist.jsp">의뢰 상세보기</a></li>
                <li class="breadcrumb-item active">자유게시판</li>

                
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div id="content">
        
        <div id="contact" class="container">
          <div class="row">
            <div class="col-lg-12">
              <section class="bar">
                
                <div class="heading">
                  <h1>${RES_VO.fTitle}</h1>
                </div>
                <div class="col-md-12">
                
                    <div class="d-flex flex-wrap justify-content-between text-xs">
                     <p class="date-comments">${RES_VO.mNickName}${RES_VO.fRegdate}</p>
                     <p id="fseq" class="date-comments">${RES_VO.fSeq}번글</p>
                    </div>
                  </div> 
                <p class="lead">${RES_VO.fText}</p>
               <div class="col-md-3">
               <p class="text-center">
                <button type="submit" onclick="location.href='/freeUpdate?fSeq=${RES_VO.fSeq}'" class="btn btn-sm btn-info">수정하기</button>
                <button type="submit" onclick="location.href='/freeDelete?fSeq=${RES_VO.fSeq}'" class="btn btn-sm btn-warning">삭제하기</button>
                </p>
                </div>
                <div class="heading">
                  <h3>댓글</h3>
                </div>
                
                <form method="POST" action="/freeComInsert" id="insertForm" class="insertForm" name="insertForm">
                  <div class="row">
                  
                    <div class="col-md-12">
                      <div class="form-group">
                        <label for="message">작성란</label>
                        <textarea name="freeComText" id="message" class="form-control"></textarea>
                      </div>
                    </div>
                    <div class="col-md-12 text-center">
                      <button name="regBtn" class="btn btn-template-outlined"><i class="fa fa-envelope-o"></i> 댓글 달기</button>
                    </div>
                  </div>
                  <input type="hidden" name="freeSeq" value="${RES_VO.fSeq}">
                </form>
                           
                <div class="row">
                  <div class="col-md-12">
              <div class="box mt-0 mb-lg-0">
                <div class="table-responsive">
                 <table class="table table-hover">
			     <thead>
			         <tr>
						<th>닉네임</th>
			            <th>내용</th>			            
			            <th><label><input type="hidden"></label></th> 
			            <th>날짜</th>
			            <th>삭제</th>
			         </tr>
			      </thead>
			      <tbody id="freeComList">
			      <c:forEach var="vv" items="${RES_LIST}">
			            <tr>
			            <td>${vv.mNickName}</td>
			            <td>${vv.rText}</td>
						<td><label><input type="hidden" name="fSeq" value="${vv.fSeq}"></label></td>
			            <td>${vv.rRegdate}</td>
			            <td><button type="submit" onclick="location.href='/freeComDelete?fSeq=${vv.fSeq}&rSeq=${vv.rSeq}'" class="btn btn-sm btn-warning">삭제하기</button></td>
			            </tr>
			       </c:forEach>
			      </tbody> 
			      </table>
                </div>
             </div>
             </div>
             </div>
             </section>
            </div>
<!-- 수정하기버튼 -->
<!-- <button name="comupdate"onclick="comupdate();" class="btn btn-sm btn-info">수정하기</button> -->
          </div>
        </div>
      </div>
  
 
 
      <!-- FOOTER -->
      <%@ include file="/include/footer.jsp" %> 
    </div>
    <!-- Javascript files-->
    <%@ include file="/include/script.jsp" %>
  </body>
</html>