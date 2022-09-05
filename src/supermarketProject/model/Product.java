package supermarketProject.model;

import java.util.Date;

public class Product {
    private String name;
    private int quantity;
    private float price;
    private String type;
    private String provider;
    private Date register;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getProvider() {
        return provider;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public Date getRegister() {
        return register;
    }
}
