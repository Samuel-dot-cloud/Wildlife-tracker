package models;

import org.sql2o.Connection;

public  class Abstract {
    public String name;
    public String age;
    public String health;
    public String type;
    public int id;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof Object)) {
            return false;
        }
        Abstract myAnimal = (Abstract) otherAnimal;
        return this.getName().equals(myAnimal.getName()) &&
                this.getType().equals(myAnimal.getType()) &&
                this.getId() == myAnimal.getId() &&
                this.getAge() == myAnimal.getAge() &&
                this.getHealth().equals(myAnimal.getHealth());
    }

    public void save() {
        try (org.sql2o.Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animal (name, age, health, type) VALUES (:name, :age, :health, :type);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .addParameter("type", this.type)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }

    }

    public static Abstract find(int id) {
        String sql = "SELECT * FROM animal WHERE id = :id;";
        try (Connection con = DB.sql2o.open()) {
            Abstract myAnimal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Abstract.class);
            return myAnimal;

        }
    }
}