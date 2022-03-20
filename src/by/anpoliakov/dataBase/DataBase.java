package by.anpoliakov.dataBase;

import by.anpoliakov.entity.Card;
import by.anpoliakov.entity.Item;

import java.util.List;

public final class DataBase {
    private static  DataBase INSTANCE = null;

    //As a repository of items will be better use a HashMap
    private List <Item> items;
    private List <Card> cards;

    private DataBase(){}

    public static DataBase getInstance (){
        if(INSTANCE == null){
            synchronized (DataBase.class){
                INSTANCE = new DataBase();
            }
        }
        return INSTANCE;
    }

    public void setData(List<Item> items, List<Card> cards){
        this.cards = cards;
        this.items = items;
    }

    //TODO: обработать вариант когда этот код могут вызвать а data ещё не установили в данный класс
    public Item getItemById(int id){
        Item itemById = null;
        if(items != null){
            for(Item item : items){
                if(item.getId() == id){
                    itemById = item;
                }
            }
        }

        return itemById;
    }

    public Card getCardById(int id){
        Card cardById = null;
        if(cards != null){
            for(Card card : cards){
                if(card.getId() == id){
                    cardById = card;
                }
            }
        }

        return cardById;
    }
}
