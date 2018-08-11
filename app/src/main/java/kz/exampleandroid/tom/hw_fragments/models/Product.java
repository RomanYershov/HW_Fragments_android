package kz.exampleandroid.tom.hw_fragments.models;

public class Product {
    private int id;
    private String name;
    private String description;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(String name, String description, int price, int id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }


}
