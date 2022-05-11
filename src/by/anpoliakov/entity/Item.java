package by.anpoliakov.entity;

/* Представляет из себя предмет/продукт из магазина,
*  не указываю кол-во товара в магазине, раз человек взял товар то он был на полке */

public class Item implements Cloneable{
    private int id; // id товара
    private String name; //имя товара
    private double cost; //стоимость товара
    private boolean isDiscount; //скидочный ли товар

    public Item(int id, String name, double cost, boolean isDiscount) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.isDiscount = isDiscount;
    }

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Item) super.clone();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", isDiscount=" + isDiscount +
                '}';
    }
}
