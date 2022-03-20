package by.anpoliakov;

import by.anpoliakov.entity.Card;
import by.anpoliakov.entity.Item;
import by.anpoliakov.entity.User;
import by.anpoliakov.dataBase.DataBase;
import by.anpoliakov.utils.ArgsHendler;

import java.util.ArrayList;
import java.util.List;

public class CheckRunner {
    public static void main(String[] args) {
        List <Item> items = new ArrayList<>();
        items.add(new Item(1, "Milk", 22.4, false));
        items.add(new Item(2, "Bread", 15, false));
        items.add(new Item(3, "Salt", 8.8, false));

        List <Card> cards = new ArrayList<>();
        cards.add(new Card(1111, 0, new User("Andrew", "Poliakov")));
        cards.add(new Card(2222, 2, new User("Sergik", "Plets")));
        cards.add(new Card(1234, 5, new User("Lyk", "Grodov")));

        DataBase db = DataBase.getInstance();
        db.setData(items, cards);

        ArgsHendler hendler = new ArgsHendler(args);
    }
}

/*
*
* 1) В магазине нет ограничения по кол-ву товаров, если покупатель нашёл товар на полке и принёс на кассу - продаём
*
* */
