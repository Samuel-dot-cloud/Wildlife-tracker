package models;

import java.util.List;
import org.sql2o.*;


public class EndangeredAnimal implements DatabaseManagement {
    private int id;
    private String name;
    private String health;
    private String age;

    public static final String HEALTHY="healthy";
    public static final String ILL="ill";
    public static final String OKAY="okay";

    public static final String NEWBORN="newborn";
    public static final String YOUNG="young";
    public static final String ADULT="adult";

    public static final String DATABASE_TYPE = "endangered";

    public EndangeredAnimal(String name, String health, String age) {
        this.name = name ;
        this.health = health;
        this.age = age;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public void save() {
        String sql = "INSERT INTO endangered(name,age,health,ranger) VALUES (:name,:age,:health,:ranger)";
        try (Connection con = DB.sql2o.open()) {
            this.id = (int)
                    con.createQuery(sql, true)
                            .addParameter("name", this.name)
                            .addParameter("age", this.age)
                            .addParameter("health", this.health)
                            .executeUpdate()
                            .getKey();
        }
    }

    @Override
    public void delete() {
        String sql = "DELETE FROM endangered";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }

    }

    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM endangered";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int id) {
        String sql = "SELECT * FROM animal WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            EndangeredAnimal animals = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animals;
        }
    }
}