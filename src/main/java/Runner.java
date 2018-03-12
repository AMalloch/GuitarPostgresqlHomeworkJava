import db.DBHelper;
import models.Guitar;
import models.Guitarist;

public class Runner {

    public static void main(String[] args) {

        Guitarist guitarist1 = new Guitarist("Navem");
        DBHelper.save(guitarist1);

        Guitar guitar1 = new Guitar("Les Paul", "Gibson", 6, guitarist1);
        DBHelper.save(guitar1);
    }
}
