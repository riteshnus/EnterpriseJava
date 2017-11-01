/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.mdb;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import warehouse.ws.WareHouseSocket;

/**
 *
 * @author siddharth
 */
@MessageDriven(mappedName = "jms/warehouseQueue",
        activationConfig = {
		@ActivationConfigProperty(
		propertyName = "destinationType",
		propertyValue = "javax.jms.Queue"
		)
	}
)
public class WareHouseMessageBean implements MessageListener {

    
    @Inject WareHouseSocket socket;
    @Override
    public void onMessage(Message message) {


    TextMessage jsonObj = (TextMessage)message;
        System.out.println("... received");
        try {
            JsonReader jsonReader = Json.createReader(new StringReader(jsonObj.getText()));
            JsonObject object = jsonReader.readObject();
            jsonReader.close();
            System.out.println("\t" + object.toString());
            socket.handleMessage(object.toString());
        } catch (JMSException ex) {
            ex.printStackTrace();
            
        }
    
    }
    
}
