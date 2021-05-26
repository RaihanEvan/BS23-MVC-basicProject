package pkg.ecommerce.service;

public class Product {
    private int pid;
    private String name;
    private int quantity;
    private String manufacturer;
    private int warranty;
    private float price;

//    public Product(String name, int quantity, String manufacturer, int warranty, float price) {
//        this.name = name;
//        this.quantity = quantity;
//        this.manufacturer = manufacturer;
//        this.warranty = warranty;
//        this.price = price;
//    }
//
//    public Product(int pid, String name, int quantity, String manufacturer, int warranty, float price) {
//        this.pid = pid;
//        this.name = name;
//        this.quantity = quantity;
//        this.manufacturer = manufacturer;
//        this.warranty = warranty;
//        this.price = price;
//    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
