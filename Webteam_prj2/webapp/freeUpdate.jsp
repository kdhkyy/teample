<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html> 
  <head>
<%@ include file="/include/header.jsp" %>
<script>
$(document).ready(function(){
	console.log("Ang!");
	//jQuery 지원 : 첨부파일 미리보기 ---------------------
	
	$("#regBtn").click(function(){
        var title = $("#freeTitle").val();
        var context = $("#freeText").val();
        if(title == "freeTitle"){
           alert("수정된 내용이 없습니다.");
           $("#freeTitle").focus();
           return false;
        }
        if(context == ""){
           alert("내용을 입력해주세요");
           $("#freeText").focus();
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
      <div id="heading-breadcrumbs" class="border-top-0 border-bottom-0">
        <div class="container">
          <div class="row d-flex align-items-center flex-wrap">
            <div class="col-md-7">
              <h1 class="h2">Web Design Now</h1>
            </div>
            <div class="col-md-5">
              <ul class="breadcrumb d-flex justify-content-end">
                <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                <li class="breadcrumb-item"><a href="freelsit.jsp">자유게시판</a></li>
                <li class="breadcrumb-item"><a href="/freeDetail?seq=${RES_VO.fSeq}">게시글 상세보기</a></li>
                <li class="breadcrumb-item active">수정</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div id="content">
        <div class="container">
          <div class="row bar">
            <!-- LEFT COLUMN _________________________________________________________-->
            <div id="blog-post" class="col-md-12">
                <div id="comment-form">
                <h4 class="text-uppercase">글 수정하기</h4>
                <form method="POST" action="/freeUpdate" id="insertForm" class="insertForm" name="insertForm">
                  <div class="row">
                    <div class="col-sm-6">
                      <div class="form-group">
                        <label for="name">제목<span class="required text-primary">*</span></label>
                        <input id="name" type="text" class="form-control" name="freeTitle" value="${RES_VO.fTitle}">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="form-group">
                        <label for="comment">글내용<span class="required text-primary">*</span></label>
                        <textarea name="freeText" id="comment" rows="16" class="form-control"  >${RES_VO.fText}</textarea>
                      </div>
                    </div>
                    <input type="hidden" id="fSeq" name="fSeq" value="${RES_VO.fSeq}">
                  </div>
                  <div class="row">
                    <div class="col-sm-12 text-right">
                      <button name="regBtn" class="btn btn-template-outlined"><i class="fa fa-comment-o"></i>수정확인</button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          
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