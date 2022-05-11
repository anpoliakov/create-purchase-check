package by.anpoliakov;

import by.anpoliakov.entity.Card;
import by.anpoliakov.entity.Item;
import by.anpoliakov.entity.PositionCheck;
import by.anpoliakov.entity.User;
import by.anpoliakov.dataBase.DataBase;
import by.anpoliakov.utils.ArgsHandler;
import by.anpoliakov.utils.CheckHandler;
import by.anpoliakov.utils.DiscountHandler;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    List <Item> items = new ArrayList<>();
    List <Card> cards = new ArrayList<>();
    DataBase db = DataBase.getInstance();

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.setItems();
        runner.setCards();
        runner.setDataDataBase();

        try{
            if(args == null){
                throw new NullPointerException("Console parameters are not set!");
            }

            ArgsHandler argsHandler =  new ArgsHandler(args);
            ArrayList<PositionCheck> positionsOfCheck = argsHandler.getPositionsOfCheck();
            Card card = argsHandler.getCard();

            DiscountHandler discountHandler = runner.process(positionsOfCheck, card);
            CheckHandler checkHandler = new CheckHandler(discountHandler);

        }catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
    }

    public DiscountHandler process(ArrayList<PositionCheck> positionsOfCheck, Card card){
        DiscountHandler discountHandler = null;

        if(card != null){
            discountHandler = new DiscountHandler(positionsOfCheck, card);
        }else {
            discountHandler = new DiscountHandler(positionsOfCheck);
        }

        return discountHandler;
    }

    public void setItems(){
        items.add(new Item(1, "Milk", 22.4, true));
        items.add(new Item(2, "Bread", 15, false));
        items.add(new Item(3, "Salt", 8.8, false));
        items.add(new Item(4, "Salt1", 13.5, true));
        items.add(new Item(5, "Salt2", 8.8, true));
        items.add(new Item(6, "Salt3", 10, true));
        items.add(new Item(7, "Salt4", 8.8, true));
        items.add(new Item(8, "Salt5", 100.5, true));
    }

    public void setCards(){
        cards.add(new Card(1111, 0, new User("Andrew", "Poliakov")));
        cards.add(new Card(2222, 2, new User("Sergik", "Plets")));
        cards.add(new Card(1234, 5, new User("Lyk", "Grodov")));
    }

    public void setDataDataBase(){
        db.setItems(items);
        db.setCards(cards);
    }
}




/*
*
* 1) В магазине нет ограничения по кол-ву товаров, если покупатель нашёл товар на полке и принёс на кассу - продаём
*
* */
