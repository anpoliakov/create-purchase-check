package by.anpoliakov.dataBase;

import by.anpoliakov.classesExeption.DataBaseException;
import by.anpoliakov.entity.Card;
import by.anpoliakov.entity.Item;

import java.util.List;

public final class DataBase {

    private static  DataBase INSTANCE = null;
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

    public void setItems(List<Item> items){
        this.items = items;
    }

    public void setCards(List<Card> cards){
        this.cards = cards;
    }

    public Item getItemById(int id) throws DataBaseException {
        Item itemById = null;

        if(items != null){
            for(Item item : items){
                if(item.getId() == id){
                    itemById = item;
                }
            }

            if(itemById == null){
                throw new DataBaseException("Item with + " + id + " doesn't exist!");
            }
        }else{
            throw new DataBaseException("Items not installed before use this method!");
        }

        return itemById;
    }

    public Card getCardById(int id) throws DataBaseException {
        Card cardById = null;
        if(cards != null){
            for(Card card : cards){
                if(card.getId() == id){
                    cardById = card;
                }
            }

            if(cardById == null){
                throw new DataBaseException("Card with + " + id + "doesn't exist!");
            }
        }else{
            throw new DataBaseException("Cards not installed before use this method!");
        }

        return cardById;
    }
}
