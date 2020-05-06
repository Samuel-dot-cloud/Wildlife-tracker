//package models;
//
//import org.junit.Rule;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class LocationTest {
//    @Rule
//    public DatabaseRule databaseRule=new DatabaseRule();
//
//    @Test
//    public void createInstanceOfLocation_true() {
//        Location location = setUpNewLocation();
//        assertEquals(true,location instanceof Location);
//    }
//
//    @Test
//    public void allEntriesAreSaved_true() {
//        Location location=setUpNewLocation();
//        Location newLocation=new Location("");
//        try {
//            location.save();
//            assertTrue(Location.all().get(0).equals(location));
//            newLocation.save();
//
//        }catch (IllegalArgumentException e){
//            System.out.println(e);
//        }
//
//    }
//
//
//    private Location setUpNewLocation() {
//        return new Location("Zone A");
//    }
//}