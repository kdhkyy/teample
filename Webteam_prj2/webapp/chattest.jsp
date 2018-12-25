<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Testing websockets</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
<%
String seq = (String)request.getParameter("o_seq");
%>
</script>
</head>
<body>
    <fieldset>
        <textarea id="messageWindow" rows="20" cols="50" readonly="true"></textarea>
        <br/>
        <input type="hidden" id="o_seq" name="o_seq" value="<%=seq%>"/>
        <input id="inputMessage" size="50" type="text"/>
        <input type="submit" value="send" onclick="send()" />
    </fieldset> 
</body>

<script type="text/javascript">

		var oSeq=$("#o_seq").val();
		console.log(oSeq);
        var textarea = document.getElementById("messageWindow");
        var webSocket = new WebSocket('ws://localhost/websocket');
        var inputMessage = document.getElementById('inputMessage');
    webSocket.onerror = function(event) {
      onError(event)
    };
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    
    webSocket.onmessage = function(event) {
      onMessage(event) 
    };
    
    function onMessage(event) {
    	var str=event.data;
    	var resStr = str.split("::", 3);
    	console.log(resStr);
    	if(resStr[1]==oSeq)
    	{
    		 textarea.value += resStr[0]+"  : " +resStr[1]+"\n";	
    	}

    }
    function onOpen(event) {
    	$.ajax({                         //의뢰 리스트 ajax로 불러오는부분
				url:"/ChatOpen",
				type:"post",
				data:"oseq="+oSeq,
				success:function(res){
					/* class='badge badge-info' */
					console.log(res);
					 $.each(res, function(index, vv){
						 textarea.value +=vv.mNickname+"  :  "+vv.cText+"\n";
				  });
				  }
			})
        textarea.value += "연결 성공\n";
    }
    function onError(event) {
      alert(event.data);
    }
    function send() {
        textarea.value += "세션 닉네임: " + inputMessage.value + "\n";
        webSocket.send("1::"+oSeq+"::"+inputMessage.value);
        inputMessage.value = "";
    }
  </script>
</html>


