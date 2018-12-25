<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({ //현재 포인트
				url:"/pointOneServlet",
				type:"POST",
				success:function(res){
					console.log(res);
				 	$("#now_point").html("POINT : "+"<font color=\'black\'>"+res+"</font>");
				}
			})
		/* $.ajax({ //이름 가져오는 부분
				url:"/pointOneServlet",
				type:"GET",
				success:function(res){
					console.log(res);
				 	
				}
		}) */
	});
</script>
      <div class="top-bar">
        <div class="container">
          <div class="row d-flex align-items-center">
            <div class="col-md-6 d-md-block d-none">
              <p>Call us +82 5127 3776 or sunil890@naver.com</p>
            </div>
            <div class="col-md-6" >
              <div class="d-flex justify-content-md-end justify-content-between">
                <ul class="list-inline contact-info d-block d-md-none">
                  <li class="list-inline-item"><a href="#"><i class="fa fa-phone"></i></a></li>
                  <li class="list-inline-item"><a href="#"><i class="fa fa-envelope"></i></a></li>
                </ul>
                <div class="col-md-6 text-right">
              <ul class="owl-carousel testimonials list-unstyled equal-height">
                  <li class="item">
              <div>   
               <div class="bottom d-flex align-items-center justify-content-between align-self-end">
                  <div class="testimonial-info d-flex">
                    <div class="title">
                      <h5>John McIntyre</h5>
                       <span id = "now_point" class="h6 counter"></span>
                    </div>
                    <div class="avatar"><img alt="" src="img/person-1.jpg" class="img-fluid"></div>
                  </div>
                </div>
                </div>
                </li>
                </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
 