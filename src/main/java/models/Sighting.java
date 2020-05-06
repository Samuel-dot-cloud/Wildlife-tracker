package models;

import models.DatabaseManagement;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Sighting implements DatabaseManagement {

    private String name;
    private String location;
    private int animalId;
    private Timestamp timestamp;
    private int id;


    public Sighting(String name, String location) {
        this.name = name;
        this.location = location;

    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Abstract getAnimal() {
        String sql = "SELECT * FROM animal WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            Abstract myAnimal = con.createQuery(sql)
                    .addParameter("id", this.animalId)
                    .executeAndFetchFirst(Abstract.class);
            return myAnimal;
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sighting (name, location, timestamp) VALUES (:name, :location, now());";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("location", this.location)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public void delete() {
    }

    @Override
    public boolean equals(Object otherSighting) {
        if (!(otherSighting instanceof Object)) {
            return false;
        }
        Sighting myAnimal = (Sighting) otherSighting;
        return this.getName().equals(myAnimal.getName()) &&
                this.getLocation().equals(myAnimal.getLocation()) &&
                this.getId() == myAnimal.getId();
    }

    public static List<Sighting> all() {
        String sql = "SELECT * FROM sighting;";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }

    public static Sighting find(int id) {
        String sql = "SELECT * FROM sighting WHERE id = :id";
        try (Connection con = DB.sql2o.open()) {
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }
}
