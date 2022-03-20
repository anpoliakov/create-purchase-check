package by.anpoliakov.utils;

import by.anpoliakov.constants.Constants;
import by.anpoliakov.dataBase.DataBase;
import by.anpoliakov.entity.Card;
import by.anpoliakov.entity.Item;

import java.util.ArrayList;

public class ArgsHendler {
    private String [] args;
    private ArrayList <Item> orderItems;
    private Card currentCard
    private DataBase db;

    public ArgsHendler(String [] args) {
        this.args = args;
        orderItems = new ArrayList<>();
        db = DataBase.getInstance();
        analyzeInputArgs();
    }

    private void analyzeInputArgs(){
        for (String str : args){
            if(isItem(str)){
                orderItems.add(creatorItem(str));
            }

            //TODO: ограничить ввод одной карты (может быть внесено 2+ карты)
            if(isCard(str)){
                creatorCard
            }
        }
    }

    private boolean isItem(String str){
        return str.matches(Constants.ID_AND_QUANTITY_REGEXP);
    }

    private boolean isCard(String str){
        return str.matches(Constants.CARD_REGEXP);
    }

    private Item creatorItem(String str){
        String [] splitStr = str.split("-");
        int id_item = Integer.parseInt(splitStr[0]);

        //TODO: обработать null - если товара с ID не существует (не создан)
        return db.getItemById(id_item);
    }

    private Card creatorCard(String str){
        String[] splitStr = str.split("-");
        int id_card = Integer.parseInt(splitStr[1]);

        //TODO: обработать null - если card такой не существует
        return db.getCardById(id_card);
    }
}
