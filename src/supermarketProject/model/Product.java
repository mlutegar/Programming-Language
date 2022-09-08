package supermarketProject.model;

/**
 * @Author: Michel Lutegar D'Orsi Pereira
 * @Since: 07/09/2002
 * @Version: 1.0
 * @Description: Class responsible for modeling supermarket products
 * */

public class Product {
    private int id;
    private String name;
    private int quantity;
    private float price;
    private String type;
    private String provider;
    private String register;

    public void setId(int id) {
        this.id = id;
    }

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

    public void setRegister(String register) {
        this.register = register;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
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

    public String getRegister() {
        return register;
    }
}
