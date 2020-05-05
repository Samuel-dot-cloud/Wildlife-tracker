package models;

import org.sql2o.*;
import java.util.List;
import java.util.Objects;

public  class Animal implements DatabaseManagement{
    private int id;
    private String name;
    private int sightingId;

    public Animal(String name, int sightingId) {
        this.name = name;
        this.sightingId =sightingId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void save() {
        if( this.sightingId ==-1) {
            throw new IllegalArgumentException("Enter the right sighting Id");
        }
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animal (name) VALUES (:name)";
            this.id = (int)
                    con.createQuery(sql,true)
                            .addParameter("name" ,this.name)
                            .addParameter("sightingId",this.sightingId)
                            .executeUpdate()
                            .getKey();
        }
    }

    @Override
    public void delete() {
        String sql = "DELETE FROM animal";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }

    }

    public static List<Animal>allAnimals(){
        String sql = "SELECT  * FROM animal";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }
    public static Animal findAnimal(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animal WHERE id = :id";
            Animal animal = con.createQuery(sql)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }
}