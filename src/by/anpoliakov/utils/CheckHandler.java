package by.anpoliakov.utils;

import by.anpoliakov.constants.Constants;
import by.anpoliakov.entity.PositionCheck;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//форитрование и вывод чека(можно было делать как отедльную сущность)
public class CheckHandler {
    private DiscountHandler discountHandler = null;

    public CheckHandler(DiscountHandler discountHandler) {
        this.discountHandler = discountHandler;

        printTopPart();
        printMiddlePart();
        printBottomPart();
    }

    private void printTopPart(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy k:mm:ss");
        System.out.println("CASH RECEIPT \n" +
                "SUPERMARKET " + Constants.NAME_SUPERMARKET + "\n" +
                "Tel: " + Constants.TEL_SUPERMARKET + "\n" +
                "DATE & TIME: " + sdf.format(date)  );
        System.out.println("------------------------------------------------------");
    }

    public void printMiddlePart(){
        System.out.printf("%-5s%-20s%-10s%-10s%n","QTY","DESCRIPTION","PRICE","TOTAL");

        for(PositionCheck positionCheck : discountHandler.getDefaultPositionOfCheck()){
            printInfoPosition(positionCheck);
        }
    }

    private void printBottomPart(){
        System.out.println("------------------------------------------------------");

        ArrayList<PositionCheck> discountPositions = discountHandler.getDiscountPositions();
        if(discountPositions != null){
            System.out.println("DISCOUNT WAS APPLY FOR POSITION:");
            for (PositionCheck possCheck : discountPositions){
                printInfoPosition(possCheck);
            }
        }

        System.out.println("------------------------------------------------------");
        System.out.println("FINAL CHECK:");
        System.out.printf("%-5s%-20s%-10s%-10s%n","QTY","DESCRIPTION","PRICE","TOTAL");
        for(PositionCheck positionCheck : discountHandler.getPositionOfCheckWithDefaultDiscount()){
            printInfoPosition(positionCheck);
        }
        System.out.println("------------------------------------------------------");

        if(discountHandler.getCard() != null){
            System.out.println("PERSONAL DISCOUNT FOR CARD: " + discountHandler.getCard().getDiscountSize() + " %");
        }
        System.out.println("TOTAL PRICE: " + String.format("%.2f", discountHandler.getTotalPriceOfCheckWithAllDiscount()));

    }

    private void printInfoPosition(PositionCheck positionCheck){
        int quantity = positionCheck.getQuantity();
        String name = positionCheck.getItem().getName();
        double price = positionCheck.getItem().getCost();
        double totalPrice = positionCheck.getTotalPrice();
        System.out.printf("%-5s%-20s%-10.2f%-10.2f%n", quantity, name, price, totalPrice);
    }
}
