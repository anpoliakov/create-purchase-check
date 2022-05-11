package by.anpoliakov.entity;

public class PositionCheck implements Cloneable{
    private Item item;
    private int quantity;
    private double totalPricePosition;
    private boolean hasDiscountForPosition  = false;
    private double sumDiscount;

    public PositionCheck(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.totalPricePosition = item.getCost() * quantity;
    }

    public boolean isDiscountPosition(){
        return item.isDiscount();
    }

    public int getIdPosition(){
        return item.getId();
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }

    public double getTotalPrice(){
        return totalPricePosition;
    }

    public void setTotalPrice(double newTotalPricePosition){
        totalPricePosition = newTotalPricePosition;
    }

    public boolean hasDiscountForPosition() {
        return hasDiscountForPosition;
    }

    public void setHasDiscountForPosition(boolean hasDiscountForPosition) {
        this.hasDiscountForPosition = hasDiscountForPosition;
    }

    public Item getItem(){
        return item;
    }

    public double getSumDiscount() {
        return sumDiscount;
    }

    public void setSumDiscount(double sumDiscount) {
        this.sumDiscount = sumDiscount;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (PositionCheck) super.clone();
    }

    @Override
    public String toString() {
        return "PositionCheck[ID = " +
                item.getId() +
                ", quantity = " + quantity +
                ", cost =" + totalPricePosition + "]";
    }
}
