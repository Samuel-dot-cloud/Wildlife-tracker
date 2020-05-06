package models;

import org.sql2o.*;

public class DB{
//    public static Sql2o sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "samuel", "12345");
private static String connectionString ="jdbc:postgresql://ec2-34-195-169-25.compute-1.amazonaws.com:5432/dngj4kbi7pruk";
public static Sql2o sql2o = new Sql2o(connectionString, "dawhdqlbgkkdds", "cb430e2e862b06b1c081b59e59ce9a358ac71e782e07770ec08bfba006f04470");
}