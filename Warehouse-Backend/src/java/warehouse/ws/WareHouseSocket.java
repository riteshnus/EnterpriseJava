/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.ws;

import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author siddharth
 */
@RequestScoped
@ServerEndpoint("/orders")
public class WareHouseSocket {
    
//    @Resource(lookup = "concurrent/myThreadPool")
//	private ManagedScheduledExecutorService service;

	private Session session;
        @Inject WebSocketSessionHandler sessionHandler;
    @OnOpen
	public void open(Session sess) {
		session = sess;
		
                sessionHandler.addSession(session);
	}

	@OnClose
	public void close(CloseReason reason) {
		
                sessionHandler.removeSession(session);
	}

	@OnMessage
	public void message(String message) {
            
        }
        
        public void handleMessage(String message){
            Set<Session> allClientSession = sessionHandler.getAllSession();
            allClientSession.forEach((clientSession) -> {
                try {
                    clientSession.getBasicRemote().sendText(message);
                } catch (IOException ex) {
                    Logger.getLogger(WareHouseSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
        }
}
