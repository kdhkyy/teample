package com.jang.point;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jang.common.RequestUtil;

/**
 * Servlet implementation class KakaoPayPage
 */
@WebServlet("/kakao_pay")
public class KakaoPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String access_token = request.getParameter("access_token");
		String total_amount = request.getParameter("total_amount");
		
		
		System.out.println(access_token);
//		//Authorization: KakaoAK xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		RequestUtil requestUtil = new RequestUtil();
		HashMap<String, Object> paramMap = new HashMap<String, Object>(); 
		//'Authorization: KakaoAK f29dbfecade2d6bf4d754cdcbb535a19' \
		
		paramMap.put("cid", "TC0ONETIME");
		paramMap.put("partner_order_id", "partner_order_id");
		paramMap.put("partner_user_id", "partner_user_id");
		paramMap.put("item_name", "포인트충전");	//
		paramMap.put("quantity", "1");
		paramMap.put("total_amount", total_amount);						////***포인트금액
		paramMap.put("vat_amount", "200");		//금액*10%
		paramMap.put("tax_free_amount", "0");	
		paramMap.put("approval_url", "http://127.0.0.1/recharge2");			////***성공시 보여질 페이지
		paramMap.put("fail_url", "http://127.0.0.1/kakaopay_fail");		////***실패시 보여질 페이지
		paramMap.put("cancel_url", "http://127.0.0.1/kakaopay_fail");	
		HashMap<String, Object> repAccessTokenMap =  requestUtil.sendPostReturnMap("https://kapi.kakao.com/v1/payment/ready", paramMap, access_token);
		System.out.println(repAccessTokenMap);

		Gson gson = new Gson();
		String jsonStr = gson.toJson(repAccessTokenMap);		
		response.setContentType("application/json; encoding=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonStr);
	}


}
