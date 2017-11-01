
package warehouse.ws;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;

/**
 *
 * @author siddharth
 */
@ApplicationScoped
public class WebSocketSessionHandler {
    private Set<Session> clientSession = new HashSet<Session>();
    
    public void addSession(Session session){
        clientSession.add(session);
    }
    
    public Set<Session> getAllSession(){
        return this.clientSession;
    }
    
    public void removeSession(Session session){
        this.clientSession.remove(session);
    }
}
