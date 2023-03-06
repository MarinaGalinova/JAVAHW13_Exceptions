public class Smartphone extends Product {
    //protected String name; //название, должно быть в родителе
    protected String brand; //производитель

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
