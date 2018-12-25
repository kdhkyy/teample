package com.jang.order;


import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ServerEndpoint("/websocket")
public class WebSocketServlet {

	private static Set<Session> clients = Collections
			.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println(message);
		String resMsg[]=message.split("::");
		OrderDAO odao = new OrderDAO();
		ChatVO cvo= new ChatVO();
		cvo.setmSeq(Integer.parseInt(resMsg[0]));
		cvo.setoSeq(Integer.parseInt(resMsg[1]));
		cvo.setcText(resMsg[2]);
		odao.chatLogInsert(cvo);
		
		//메세지로 변경
		resMsg[0]=odao.chatSeqToNick(cvo.getmSeq()).getmNickname();
		
		String resmessage=resMsg[0]+"::"+resMsg[1]+"::"+resMsg[2];
		synchronized (clients) {
			for (Session client : clients) {
				if (!client.equals(session)) {

					System.out.println(client);
					client.getBasicRemote().sendText(resmessage);
				}
			}
		}
	}
	@OnOpen
	public void onOpen(Session session) {
		// Add session to the connected sessions set
		clients.add(session);
	}
	@OnClose
	public void onClose(Session session) {
		// Remove session from the connected sessions set
		clients.remove(session);
	}
}


/*@ServerEndpoint 부분이 클라이언트에서 접속할 서버 주소이다

@OnMessage는 클라이언트로부터 메시지가 도착했을 경우 처리 방법이며

@OnOpen과 @onClose는 클라이언트가 접속을 할 때와 접속이 끊어졌을떄의 처리이다
*/
