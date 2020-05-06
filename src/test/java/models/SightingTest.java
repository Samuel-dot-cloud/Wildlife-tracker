//package models;
//
//import models.DatabaseRule;
//import org.junit.Rule;
//import org.junit.Test;
//
//
//import static org.junit.Assert.*;
//
//public class SightingTest {
//
//    @Rule
//    public DatabaseRule databaseRule=new DatabaseRule();
//
//    @Test
//    public void createInstanceOfSightingClass_true() {
//
//        Sighting sighting= setUpNewSighting();
//        assertEquals(true,sighting instanceof Sighting);
//    }
//
//    @Test
//    public void allInstancesAreSaved() {
//        Sighting sighting=setUpNewSighting();
//        Sighting otherSighting=new Sighting("sam","forest");
//        try {
//            sighting.save();
//            otherSighting.save();
//            assertTrue(Sighting.find(sighting.findAnimal();).equals(sighting));
//        }catch (IllegalArgumentException e){
//            System.out.println(e);
//        }
//    }
//
//    @Test
//    public void findSightingByID() {
//        Sighting sighting=setUpNewSighting();
//        sighting.save();
//        Sighting foundSighting=Sighting.find(sighting.findAnimal(););
//        assertTrue(foundSighting.equals(sighting));
//
//    }
//
//
//    private Sighting setUpNewSighting() {
//        return new Sighting("sam","forest");
//    }
//}