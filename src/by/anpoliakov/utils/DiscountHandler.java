package by.anpoliakov.utils;

import by.anpoliakov.constants.Constants;
import by.anpoliakov.entity.Card;
import by.anpoliakov.entity.PositionCheck;

import java.util.ArrayList;

public class DiscountHandler {
    private ArrayList<PositionCheck> defaultPositionsOfCheck = null;
    private ArrayList<PositionCheck> positionOfCheckWithDefaultDiscount = null;
    private ArrayList<PositionCheck> discountPositions = null;
    private Card card = null;

    public DiscountHandler(ArrayList<PositionCheck> positionsOfCheck) {
        this.defaultPositionsOfCheck = positionsOfCheck;
        processForDiscount();
    }

    public DiscountHandler(ArrayList<PositionCheck> positionsOfCheck, Card card) {
        this.defaultPositionsOfCheck = positionsOfCheck;
        this.card = card;
        processForDiscount();
    }

    private void processForDiscount(){
        if(defaultPositionsOfCheck != null){
            positionOfCheckWithDefaultDiscount = new ArrayList<>();
            discountPositions = new ArrayList<>();
            cloneAllElements(defaultPositionsOfCheck, positionOfCheckWithDefaultDiscount);

            for(PositionCheck positionCheck : positionOfCheckWithDefaultDiscount){
                if(positionCheck.getQuantity() > Constants.QUANTITY_FOR_DISCOUNT && positionCheck.hasDiscountForPosition() == false){
                    discountPositions.add(setDiscountForPosition(positionCheck));
                }
            }
        }
    }

    public ArrayList<PositionCheck> getDefaultPositionOfCheck(){
        return defaultPositionsOfCheck;
    }

    public ArrayList<PositionCheck> getDiscountPositions() {
        return discountPositions;
    }

    public ArrayList<PositionCheck> getPositionOfCheckWithDefaultDiscount() {
        return positionOfCheckWithDefaultDiscount;
    }

    public Card getCard(){
        return card;
    }

    public double getTotalPriceOfCheckWithAllDiscount(){
        double totalPrice = 0;

        if(card != null){
            if(positionOfCheckWithDefaultDiscount != null){
                for(PositionCheck positionCheck : positionOfCheckWithDefaultDiscount){
                   totalPrice += positionCheck.getTotalPrice();
                }
                totalPrice -= totalPrice * card.getDiscountSize()/100;
            }
        }else{
            if(positionOfCheckWithDefaultDiscount != null){
                for(PositionCheck positionCheck : positionOfCheckWithDefaultDiscount){
                    totalPrice += positionCheck.getTotalPrice();
                }
            }
        }

        return totalPrice;
    }

    private PositionCheck setDiscountForPosition(PositionCheck possCheck){
        double totalPrice = possCheck.getTotalPrice();
        double sumDiscount = totalPrice * Constants.DEFAULT_DISCOUNT_SIZE/100;

        possCheck.setSumDiscount(sumDiscount);
        possCheck.setTotalPrice(totalPrice - sumDiscount);
        possCheck.setHasDiscountForPosition(true);

        return possCheck;
    }

    private void cloneAllElements(ArrayList<PositionCheck> original, ArrayList<PositionCheck> clone){
        for(PositionCheck positionCheck : original){
            try {
                clone.add((PositionCheck) positionCheck.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }
}
