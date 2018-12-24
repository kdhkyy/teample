<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
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
        var aText = $("#aText").val();
        var qSeq = $(RES_VO.qSeq).val();
        console.log(qSeq);
        if(aText == ""){
           alert("내용을 입력하세요");
           $("#aText").focus();
           return false;
        }
        $("#answerForm").submit();
       
    });
});     
</script> 
  </head>
  <body>
    <div id="all">
      <%@ include file="/include/topbar.jsp" %>
      <%@ include file="/include/loginmadal.jsp" %>
      <%@ include file="/include/navbar.jsp" %>
      
      <div id="heading-breadcrumbs">
        <div class="container">
          <div class="row d-flex align-items-center flex-wrap">
            <div class="col-md-7">
              <h1 class="h2">문의 상세보기</h1>
            </div>
            <div class="col-md-5">
              <ul class="breadcrumb d-flex justify-content-end">
                <li class="breadcrumb-item"><a href="index3.jsp">Home</a></li>
                <li class="breadcrumb-item active"><a href="question.jsp">고객센터</a></li>
                <li class="breadcrumb-item">문의 상세보기</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div id="content">
        <div class="container">
          <div class="row bar">
            <div class="col-md-9">
          
          
              <section>
                <div id="accordion" role="tablist">
                  <div class="card card-primary">
                    <div id="headingOne" role="tab" class="card-header">
                      <h5 class="mb-0 mt-0"><a data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">문의 합니다.</a></h5>
                    </div>
                    <div id="collapseOne" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion" class="collapse show">
                      <div class="qText" name="qText"><p><td><p> <b><span style ="font-family: 굴림; font-size:1em;  color: black;">${RES_VO.qText}</span></b></td><br></p></div>
                    </div>
                  </div>                
                </div>
              </section>
              
               <div class="row">
                  
                    <div class="col-md-12">
                      <div class="form-group">
                      <form method="POST" action="answerUpdateServlet" id="answerForm"class="answerForm" name="answerForm" >
                        <label for="message">작성란</label>
                        
                        <textarea name="aText" id="aText" class="form-control"></textarea>
                        
                        <br><div class="col-md-12 text-center">
                     <button name="regBtn" class="btn btn-template-outlined">댓글 달기</button>
                    </div>
                    <td><label><input type="hidden" name="qSeq" id="qSeq" value="${RES_VO.qSeq}"></label></td>
                  	<td><label><input type="hidden" name="anText" id="anText" value="${RES_VO.aText}"></label></td>
                    </form>
                        <div class="card-body" name="card-body"><p><c:forEach var="vv" items="${RES_LIST}">
                     <td><p> <b><span style ="font-family: 굴림; font-size:1em;  color: black;">* ${vv.aText}</span></b></td><br>
                </c:forEach>
                </p>
                </div>
                      </div>
                    </div>
                  </div>
              		
                    <div class="col-sm-12 text-right">
                    <button type="submit" onclick="location.href='/questionUpdateServlet?qSeq=${RES_VO.qSeq}'" class="btn btn-template-outlined">수정하기</button><br><br>
                    </div>
				
            </div>
            
            
           <div class="col-md-3">
              <!-- PAGES MENU -->
              <div class="panel panel-default sidebar-menu">
                <div class="panel-heading">
                  <h3 class="h4 panel-title">고객센터</h3>
                </div>
                <div class="panel-body">
                  <ul class="nav nav-pills flex-column text-sm">
                    <li class="nav-item"><a href="text.html" class="nav-link">자주 들어오는 질문</a></li>
                    <li class="nav-item"><a href="contact.html" class="nav-link">FAQ</a></li>
                    <li class="nav-item"><a href="faq.html" class="nav-link">신고</a></li>
                  </ul>
                </div>
              </div>
              
            </div>
          </div>
        </div>
      </div>
      
      <%@ include file="/include/footer.jsp" %>
    </div>
    <%@ include file="/include/script.jsp" %>
  </body>
</html>