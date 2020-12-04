package application;

public class Produtos {
    private double price;
    private String name;
    private int id;



    public Produtos(double price, String name){
        this.price = price;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName(){
        return name;
    }


    public void setName(String name){
        this.name = name;
    }


    }




