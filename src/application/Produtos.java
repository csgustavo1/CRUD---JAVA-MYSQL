package application;

public class Produtos {
    private double price;
    private String name;
    private int id;
    private int quantidade;



    public Produtos(double price, String name, int quantidade){
        this.price = price;
        this.name = name;
        this.quantidade = quantidade;


    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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




