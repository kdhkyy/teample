<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <%@ include file="/include/header.jsp" %>
  <script>
  $(document).ready(function(){
	  $("#chatBtn").click(function(){
		  sessionStorage.setItem('SESS_OSEQ', $("#RES_VO.oSeq").val());
window.open("chattest.jsp?o_seq=${RES_VO.oSeq}", '_blank', 'toolbar=no, location=no, status=no, menubar=no, scrollbars=auto, resizqable=no,directories=no, width=400,height=400,top=100,left=100')
	  })
})
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
              <h1 class="h2">의뢰 상세보기</h1>
            </div>
         <div class="col-md-5">
              <ul class="breadcrumb d-flex justify-content-end">
              <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="orderBoarder.jsp">의뢰 전체보기</a></li>
                <li class="breadcrumb-item">의뢰 상세보기</li>
              </ul>
            </div>
          </div> 
        </div> 
      </div>
      <div id="content">
        <div class="container">
          <div class="row bar">
            <!-- LEFT COLUMN _________________________________________________________-->
            <div class="col-lg-12">
              <p class="lead">${RES_VO.oTitle}</p>
              <p class="goToDescription"><a href="#details" class="scroll-to text-uppercase">Scroll to product details, material & care and sizing</a></p>
              <div id="productMain" class="row">
                <div class="col-sm-6">
                  <div data-slider-id="1" class="owl-carousel shop-detail-carousel">
                  <c:forEach var="vo" items="${RES_VO.plist}" varStatus="status">
                            <div> <img src="/cdir/${vo.picSysname}"  alt="" class="img-fluid"></div>
                      </c:forEach>
                    <input type="hidden" value="${RES_VO.oSeq}"/>
                  </div>
                </div>
                <div class="col-sm-6">
                  <div class="box">
                    <form>
                      <div class="sizes">
                        <h3>의뢰 포인트</h3>
                      </div>
                      <p class="price">${RES_VO.oPoint}  포인트</p>
                      
                    </form>
                  </div>
                  <div data-slider-id="1" class="owl-thumbs">
                  <c:forEach var="vo" items="${RES_VO.plist}" varStatus="status">
                            <button class="owl-thumb-item"><img src="/cdir/${vo.picSysname}" alt="" class="img-fluid"></button>
                      </c:forEach>
                  </div>
                  <p class="text-center">
                        <button type="submit" class="col-lg-12 btn btn-template-outlined"><i class="fa fa-shopping-cart"></i>수주하기</button><br><br>
                        <button type="submit" onclick="location.href='/orderUpdateServlet?oSeq=${RES_VO.oSeq}'" class="col-md-12 btn btn-template-outlined"><i class="fa fa-shopping-cart"></i>수정하기</button><br><br>
                        <button type="submit" onclick="location.href='/OrderDelete?oSeq=${RES_VO.oSeq}'" class="col-md-12 btn btn-template-outlined"><i class="fa fa-shopping-cart"></i>삭제하기</button><br><br>
                        <button type="submit" class="col-md-12 btn btn-template-outlined"><i class="fa fa-shopping-cart"></i>신고하기</button>
                        <button  class="col-md-12 btn btn-template-outlined" id="chatBtn"><i class="fa fa-shopping-cart"></i>채팅하기</button>
                      </p>
                </div>
                
              </div>
              <div id="details" class="box mb-4 mt-4">
                <p>상세 내용</p>
                <p>${RES_VO.oText}</p>
                <blockquote class="blockquote">
                  <p class="mb-0"><em>의뢰자 위치</em></p>
                </blockquote>
                <div id="simple-map" class="simple-map" style="height:450px;"></div>
                </div>
              </div>
             
           
              
            </div>
        
          </div>
        </div>
      </div>
      <!-- GET IT-->
      <div class="get-it">
        <div class="container">
          <div class="row">
            <div class="col-lg-8 text-center p-3">
              <h3>Do you want cool website like this one?</h3>
            </div>
            <div class="col-lg-4 text-center p-3">   <a href="#" class="btn btn-template-outlined-white">Buy this template now</a></div>
          </div>
        </div>
      </div>
      <!-- FOOTER -->
     <%@ include file="/include/footer.jsp" %> 
    </div>
    <%@ include file="/include/script.jsp" %>
   <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDmubPngLb1Im7cyNyDdDMyGRJkDyXBxYA&callback=initMap">
    </script>
     <script>
       // init map
       function initMap() {
  // The location of Uluru
  var center = {lat: ${RES_VO.oLat}, lng: ${RES_VO.oLng}};

  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('simple-map'), {zoom: 15, center: center});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: center, map: map});

}
     </script>
  </body>
</html>