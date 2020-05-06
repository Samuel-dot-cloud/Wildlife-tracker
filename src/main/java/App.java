import models.Animal;
import models.Endangered;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());

        get("/animal-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animal-form.hbs");
        },new HandlebarsTemplateEngine());

        get("/sighting-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sighting-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/animal-detail", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            String animalAge = request.queryParams("animalAge");
            String animalHealth = request.queryParams("animalHealth");
            String animalType = request.queryParams("animalType");
            if(animalType.equals("safe")){
                Animal regularAnimal = new Animal(animalName, animalAge, animalHealth, animalType);
                regularAnimal.save();
            }
            else if(animalType.equals("endangered")){
                Endangered endangeredAnimal = new Endangered(animalName, animalAge, animalHealth, animalType);
                endangeredAnimal.save();
            }
            List<Animal> allAnimal= Animal.all();
            model.put("animals", allAnimal);
            return new ModelAndView(model, "animal-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animal-detail", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> allAnimal= Animal.all();
            model.put("animals", allAnimal);
            return new ModelAndView(model, "animal-detail.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sighting-detail", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String rangerName = request.queryParams("rangerName");
            String sightingLocation = request.queryParams("sightingLocation");

            Sighting newSighting1 = new Sighting(rangerName, sightingLocation);
            newSighting1.save();
            List<Sighting> allSightings = Sighting.all();
            model.put("sightings", allSightings);
            return new ModelAndView(model, "sighting-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sighting-detail", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> allSightings = Sighting.all();
            model.put("sightings", allSightings);
            return new ModelAndView(model, "sighting-detail.hbs");
        }, new HandlebarsTemplateEngine());
    }
}