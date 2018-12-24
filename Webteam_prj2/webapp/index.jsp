<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/include/header.jsp" %>
 </head>
  <body>
    <div id="all">
        <%@ include file="/include/topbarlog.jsp" %>
    <%@ include file="/include/loginmadal.jsp" %>
    <%@ include file="/include/navbar.jsp" %> 
      
      <section style="background: url('img/marketgrid.jpg') center center repeat; background-size: cover;" class="bar background-white relative-positioned">
        <div class="container">
          <!-- Carousel Start-->
          <div class="home-carousel">
            <div class="dark-mask mask-primary"></div>
            <div class="container">
              <div class="homepage owl-carousel">
                <div class="item">
                  <div class="row">
                    <div class="col-md-5 text-right">
                      <h1>간단한 장보기부터<br> 귀찮은 심부름까지</h1>
                      <p>장보기,심부름,집주변 커뮤티니<br>모든걸 한번에 해결하는 동네기반 서비스</p>
                    </div>
                    <div class="col-md-7"><img src="img/2.jpg" alt="" class="img-fluid"></div>
                  </div>
                </div>
                <div class="item">
                  <div class="row">
                    <div class="col-md-7 text-center"><img src="img/7.jpg" alt="" class="img-fluid"></div>
                    <div class="col-md-5">
                      <h2>혼자사는 1인가구를 위한<br>해결책</h2>
                      <ul class="list-unstyled">
                        <li>장보러가기 귀찮은 당신</li>
                        <li>장보러가는길에 겸사겸사 돈도 벌고싶은 당신</li>
                        <li>전날 주문해야되는 인터넷쇼핑보다 빠른 JangBoGO!가 있습니다.</li>
                        <li>내 주변에 어떤 사람이<br>날 필요로 하는지 알아보세요.</li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div class="item">
                  <div class="row">
                    <div class="col-md-5 text-right">
                      <h1>1인가구세대</h1>
                      <ul class="list-unstyled">
                        <li>혼밥 혼술 혼영 까지는 포기했다!</li>
                        <li>하지만 홀로 장보러 가는건 너무 힘들다.</li>
                        <li>나대신 장보러 갔다올 사람이 없을까?</li>
                        <li>내주변 심부름꾼을 찾아보자.</li>
                      </ul>
                    </div>
                    <div class="col-md-7"><img src="img/solohome.png" alt="" class="img-fluid"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Carousel End-->
        </div>
      </section>
      <section class="bar background-white">
        <div class="container text-center">
          <div class="row">
            <div class="col-lg-4 col-md-6">
              <div class="box-simple">
                <div class="icon-outlined"><i class="fa fa-envelope-o"></i></div>
                <h3 class="h4">사용자간의 채팅</h3>
                <p>의뢰자와 피의뢰인간의 실시간 채팅을 통한 의뢰조율</p>
              </div>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="box-simple">
                <div class="icon-outlined"><i class="fa fa-user"></i></div>
                <h3 class="h4">사람과의 만남</h3>
                <p>일적으로의 만남이 아닌 이웃간의 만남을 통해 지역사회의 화목함을 추구합니다.</p>
              </div>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="box-simple">
                <div class="icon-outlined"><i class="fa fa-globe"></i></div>
                <h3 class="h4">지역기반 서비스</h3>
                <p>내 주변에 누가 도움을 필요로 하는지 누가 도움을 줄 수 있는지를 알 수 있습니다</p>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section class="bar background-pentagon no-mb text-md-center">
        <div class="container">
          <div class="heading text-center">
            <h2>의뢰 목록</h2>
          </div>
          <p class="lead">저희 장보GO!를 이용하고계 회원님들의 의뢰입니다. 도움이 필요한 회원들을 도와주세요!</p>
          <!-- Carousel Start-->
          <ul class="owl-carousel testimonials list-unstyled equal-height">
            <li class="item">
              <div class="testimonial d-flex flex-wrap">
                <div class="text">
                  <p>안녕하세요! 종로에서 양식집을 하고있습니다. 일손이바빠 장보러 갈 시간이 부족합니다. 양파30구짜리 2망 파스타 5봉지만 사다주실분 있나요?</p>
                 </div>
                <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                  <div class="icon"><i class="fa fa-quote-left"></i></div>
                  <div class="testimonial-info d-flex">
                    <div class="title">
                      <h5>Ellen Daviri</h5>
                      <p>종로, Blizzard Cop.</p>
                    </div>
                    <div class="avatar"><img alt="" src="img/chef.png" class="img-fluid"></div>
                  </div>
                </div>
              </div>
            </li>
            <li class="item">
              <div class="testimonial d-flex flex-wrap">
                <div class="text">
                <p>홈플러스에서 과자 골라담아1박스 이벤트 하던데 많이 담아서 사다주실분 있나요?</p>
                </div>
                <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                  <div class="icon"><i class="fa fa-quote-left"></i></div>
                  <div class="testimonial-info d-flex">
                    	<div class="title">
                      <h5>이문경</h5>
                      <p>안산, AsiaInformationSys</p>
                    </div>
                    <div class="avatar"><img alt="" src="img/nayeon.jpg" class="img-fluid"></div>
                  </div>
                </div>
              </div>
            </li>
            <li class="item">
              <div class="testimonial d-flex flex-wrap">
                <div class="text">
                  <p>롯데마트에서 소갈비 한짝,버섯 종류별로 한팩씩 사다주실분 있나요?.</p>
                </div>
                <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                  <div class="icon"><i class="fa fa-quote-left"></i></div>
                  <div class="testimonial-info d-flex">
                    <div class="title">
                      <h5>김철희</h5>
                      <p>대구, TechnoBrave.Cop.</p>
                    </div>
                    <div class="avatar"><img alt="" src="img/cheol.jpg" class="img-fluid"></div>
                  </div>
                </div>
              </div>
            </li>
            <li class="item">
              <div class="testimonial d-flex flex-wrap">
                <div class="text">
                  <p>돼지고기 앞다리살 600g,두부 한 모,만두피,쪽파 한 단 사다주실분?</p>
                </div>
                <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                  <div class="icon"><i class="fa fa-quote-left"></i></div>
                  <div class="testimonial-info d-flex">
                    <div class="title">
                      <h5>김대형</h5>
                      <p>노원구, 회사원</p>
                    </div>
                    <div class="avatar"><img alt="" src="img/kimdae.jpg" class="img-fluid"></div>
                  </div>
                </div>
              </div>
            </li>
          </ul>
          <!-- Carousel End-->
        </div>
      </section>
      
     
      <section class="bar bg-gray">
        <div class="container">
          <div class="heading text-center">
            <h2>Our Clients</h2>
          </div>
          <ul class="list-unstyled owl-carousel customers no-mb">
            <li class="item"><img src="img/kosmo.jpg" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/naver.jpg" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/kakao.jpg" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/softbank.jpg" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/amazon.jpg" alt="" class="img-fluid"></li>
            <li class="item"><img src="img/asia.JPG" alt="" class="img-fluid"></li>
            </ul>
        </div>
      </section>
      <!-- GET IT-->
      
      <!-- FOOTER -->
    <%@ include file="/include/footer.jsp" %>
    </div>
    <!-- Javascript files-->
   <%@ include file="/include/script.jsp" %>
  </body>
</html>