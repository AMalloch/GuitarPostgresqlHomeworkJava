import db.DBHelper;
import models.Guitar;
import models.Guitarist;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Guitarist guitarist1 = new Guitarist("Navem");
        DBHelper.save(guitarist1);

        Guitarist guitarist2 = new Guitarist("Angus");
        DBHelper.save(guitarist2);

        Guitar guitar1 = new Guitar("Les Paul", "Gibson", 6, guitarist1);
        DBHelper.save(guitar1);

        Guitar guitar2 = new Guitar("Corvette Hotrod", "Warwick", 5, guitarist1);
        DBHelper.save(guitar2);

        guitar1.setManufacturer("Ibanez");
        DBHelper.update(guitar1);

        List<Guitar> guitars = DBHelper.getAll("Guitar");

        List<Guitarist> guitarist = DBHelper.getAll("Guitarist");
    }
}
