package by.anpoliakov.utils;

import by.anpoliakov.classesExeption.ArgsHandlerException;
import by.anpoliakov.classesExeption.DataBaseException;
import by.anpoliakov.constants.Constants;
import by.anpoliakov.entity.Card;
import by.anpoliakov.entity.PositionCheck;
import by.anpoliakov.utils.creators.CreatorCard;
import by.anpoliakov.utils.creators.CreatorPositionCheck;

import java.util.ArrayList;

public class ArgsHandler {
    private ArrayList <PositionCheck> positionsOfCheck = null;
    private Card card = null;

    public ArgsHandler(String [] args) {
        if(args.length > 0){
            createObjectsFromInputArgs(args);
        }else{
            try {
                throw new ArgsHandlerException("Your String[] from console is empty");
            } catch (ArgsHandlerException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        }
    }

    private void createObjectsFromInputArgs(String [] args){
        for (String argument : args){
            if(isItem(argument)){
                if(positionsOfCheck == null){
                    positionsOfCheck = new ArrayList<>();
                }

                try {
                    positionsOfCheck.add(CreatorPositionCheck.create(argument));
                } catch (DataBaseException e) {
                    System.err.println(e.getMessage());
                    System.exit(-1);
                }
            }

            if(isCard(argument)){
                try {
                    card = CreatorCard.create(argument);
                } catch (DataBaseException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public ArrayList <PositionCheck> getPositionsOfCheck(){
        return positionsOfCheck;
    }
    public Card getCard(){
        return card;
    }

    private boolean isItem(String argument){
        return argument.matches(Constants.ID_AND_QUANTITY_REGEXP);
    }
    private boolean isCard(String argument){
        return argument.matches(Constants.CARD_REGEXP);
    }
}
