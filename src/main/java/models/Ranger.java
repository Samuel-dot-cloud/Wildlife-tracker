package models;

import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ranger{
   private int id;
   private String name;
   private String phone ;
   private Long badge_number;

    public Ranger(String name, String phone, Long badge_number ) {
        this.name = name;
        this.phone = phone;
        this.badge_number = badge_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return Objects.equals(name, ranger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Long getBadge_Number() {
        return badge_number;
    }
    public void save() {
        String sql = "INSERT INTO rangers (name, phone, badge_number) VALUES (:name, :phone, :badge_number) ";
        try (Connection con = DB.sql2o.open()) {
            this.id = (int)
                    con.createQuery(sql,true)
                            .addParameter("name" , this.name)
                            .addParameter("phone",this.phone)
                            .addParameter("email", this.badge_number)
                            .throwOnMappingFailure(false)
                            .executeUpdate()
                            .getKey();
        }
    }
    public static List<Ranger> all(){
        String sql = "SELECT * FROM rangers";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Ranger.class);
        }
    }
    public static Ranger find(int id){
        String sql = "SELECT * FROM rangers WHERE id = :id";
        try (Connection con = DB.sql2o.open()){
            Ranger ranger = con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Ranger.class);
            return ranger;
        }
    }
    public List<EndangeredAnimal> found() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangered where ranger=:name";
            return con.createQuery(sql)
                    .addParameter("name", this.name)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    public void delete(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM  rangers";
            con.createQuery(sql)
                    .addParameter("id",this.id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }
    public  List<Sighting> allSightings(){
        String sql = "SELECT * FROM sightings WHERE  rangerName = : name";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("name",this.name)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }
}