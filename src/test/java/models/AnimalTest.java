package models;

import models.Animal;
import models.DatabaseRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {



    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();

    @Test
    public void testInstanceOfAnimalsClass_true(){
        Animal testAnimal= setUpNewAnimal();
        assertEquals(true,testAnimal instanceof Animal);
    }

    @Test
    public void allInstancesAreSaved() {
        Animal testAnimal=setUpNewAnimal();
        testAnimal.save();
        assertTrue(Animal.allAnimals().get(0).equals(testAnimal));
    }

    @Test
    public void findByIdReturnsCorrectInfo() {
        Animal testAnimal=setUpNewAnimal();
        testAnimal.save();
        Animal foundAnimal= Animal.findAnimal(testAnimal.getId());
        assertTrue(foundAnimal.equals(testAnimal));
    }

    @Test
    public void deleteById() {
        Animal testAnimal=setUpNewAnimal();
        testAnimal.save();
        testAnimal.delete();
        assertNull(Animal.findAnimal(testAnimal.getId()));
    }

    @Test
    public void deleteAllEntries() {
        Animal testAnimal=setUpNewAnimal();
        Animal otherAnimal=setUpNewAnimal();
        testAnimal.save();
        otherAnimal.save();
        Animal.delete();
        List<Animal> animals=Animal.allAnimals();
        assertEquals(0,animals.size());
    }



    @Test
    public void ensureNameFieldCannotBeEmpty(){
        Animal testAnimal=new Animal("lion",1);
        try {
            testAnimal.save();
        }catch (IllegalArgumentException e){

        }
    }

    private Animal setUpNewAnimal() {
        return new Animal("Antelope",1);
    }
}