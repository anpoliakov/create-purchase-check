package by.anpoliakov.utils.creators;

import by.anpoliakov.classesExeption.DataBaseException;
import by.anpoliakov.dataBase.DataBase;
import by.anpoliakov.entity.Card;

public class CreatorCard {
    private static DataBase db = DataBase.getInstance();

    public static Card create(String cardData) throws DataBaseException {
        String[] splitStr = cardData.split("-");
        int id_card = Integer.parseInt(splitStr[1]);

        return db.getCardById(id_card);
    }
}
