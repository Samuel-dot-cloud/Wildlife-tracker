import models.*;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import org.sql2o.Sql2o;
import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App{
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());


        staticFileLocation("/public");

        get("/",(request, response) ->{
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());


        get( "/animal/form", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());


        post("/animals/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String animalName = request.queryParams("Name");
            String health = request.queryParams("health");
            String Age = request.queryParams("age");
            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            int sightId = Integer.parseInt(request.queryParams("sightingId"));


            try {
                Animal animal = new Animal(animalName, sightId);
                animal.save();
                Sighting sight = new Sighting(rangerName, location);
                sight.saveSighting();
            }catch(IllegalArgumentException exception){
                System.out.println("Enter the right data");
            }
            return new ModelAndView(model,"animal-detail.hbs");
        },new HandlebarsTemplateEngine());


        get("/animals/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            model.put("animals",Animal.allAnimals());
            return new ModelAndView(model,"animal-detail.hbs");
        }, new HandlebarsTemplateEngine());


        get("/Endangered/form",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            model.put("animals",Animal.allAnimals());
            model.put("rangers",Ranger.all());
            return new ModelAndView(model,"endangeredAnimal-form.hbs");
        },new HandlebarsTemplateEngine());


        post("/Endangered/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name = request.queryParams("Name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String rangerName = request.queryParams("ranger");
            String location = request.queryParams("location");
            EndangeredAnimal endangered = new EndangeredAnimal(name,health,age);
            endangered.save();
            return new ModelAndView(model,"endangeredAnimal-detail.hbs");
        },new HandlebarsTemplateEngine());


        get("/Endangered/new",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            model.put("animals",EndangeredAnimal.all());
            return new ModelAndView(model,"endangeredAnimal-detail.hbs");
        }, new HandlebarsTemplateEngine());


        get("/ranger/form",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"ranger-form.hbs");
        }, new HandlebarsTemplateEngine());


        get("/ranger/new",(request, response) -> {
            Map<String, Object>model = new HashMap<>();
            model.put("rangers",Ranger.all());
            return new ModelAndView(model,"ranger-detail.hbs");
        }, new HandlebarsTemplateEngine());


        post("/ranger/new",(request, response) -> {
            Map<String, Object>model = new HashMap<>();
            String name = request.queryParams("Name");
            String phone = request.queryParams("Phone");
            String badge_number = request.queryParams("badge_number");
            try {
                Ranger ranger = new Ranger(name, phone, badge_number);
                ranger.save();
            }catch(IllegalArgumentException exception){
                System.out.println("Please input the correct information");
            }
            return new ModelAndView(model,"ranger-detail.hbs");
        },new HandlebarsTemplateEngine());

    }
}