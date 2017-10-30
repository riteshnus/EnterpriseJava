package onlinestore.web;

import java.io.Serializable;

/**
 *
 * @author Ritesh
 */
public class Cart implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String name;
    private int quantity;
    private String img;

    public Cart(){
        
    }
    
    public Cart(String name, int quantity, String img){
        this.name = name;
        this.quantity = quantity;
        this.img = img;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
