package by.anpoliakov.utils.creators;

import by.anpoliakov.classesExeption.DataBaseException;
import by.anpoliakov.dataBase.DataBase;
import by.anpoliakov.entity.PositionCheck;

public class CreatorPositionCheck {
    private static DataBase db = DataBase.getInstance();

    public static PositionCheck create(String positionData) throws DataBaseException {
        String [] splitStr = positionData.split("-");
        int id_item = Integer.parseInt(splitStr[0]);
        int quantity = Integer.parseInt(splitStr[1]);

        return new PositionCheck(db.getItemById(id_item), quantity);
    }
}
