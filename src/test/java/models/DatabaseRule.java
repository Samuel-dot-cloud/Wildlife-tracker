package models;

import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {

    @Override
    public void before() {
    }

    @Override
    public void after(){
        try (Connection con = DB.sql2o.open()){

            String deleteAnimalQuery="DELETE FROM animal ";
            String deleteSightingsQuery="DELETE FROM sighting *";
            String deleteRangerQuery="DELETE FROM ranger";
            String deleteLocationQuery="DELETE FROM locations *";

            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
            con.createQuery(deleteRangerQuery).executeUpdate();
            con.createQuery(deleteLocationQuery).executeUpdate();
        }
    }

}