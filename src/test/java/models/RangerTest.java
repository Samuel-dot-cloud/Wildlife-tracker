//package models;
//
//import org.junit.Rule;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class RangerTest {
//
//    @Rule
//    public DatabaseRule databaseRule=new DatabaseRule();
//
//    @Test
//    public void createInstanceOfRangersClass_true(){
//        Ranger ranger= setUpNewRanger();
//        assertEquals(true,ranger instanceof Ranger);
//    }
//
//    @Test
//    public void allEntriesAreSaved() {
//        Ranger ranger= setUpNewRanger();
//        ranger.save();
//        assertTrue(Ranger.all().get(0).equals(ranger));
//
//    }
//
//    @Test
//    public void emptyFieldsAreNotSaved() {
//        Ranger ranger=new Ranger("sam","45678","5670");
//        try{
//            ranger.save();
//            assertTrue(Ranger.all().get(0).equals(ranger));
//        }catch (IllegalArgumentException e){
//            System.out.println(e);
//        }
//    }
//
//    @Test
//    public void findById() {
//        Ranger ranger= setUpNewRanger();
//        Ranger otherRanger=new Ranger("Sylvia","2","6577");
//        ranger.save();
//        otherRanger.save();
//        Ranger foundRanger=Ranger.find(ranger.find());
//        assertTrue(foundRanger.equals(ranger));
//
//    }
//
//
//    @Test
//    public void entriesAreDeleted() {
//        Ranger ranger= setUpNewRanger();
//        Ranger otherRanger=new Ranger("Sylvia","","0726108898");
//        ranger.save();
//        otherRanger.save();
//        ranger.delete();
//        assertEquals(null,Ranger.find(ranger.find()));
//
//    }
//
//    @Test
//    public void allSightingsAreReturned_true() {
//        Ranger ranger=setUpNewRanger();
//        try {
//            Location location=new Location("Zone A");
//            ranger.save();
//            location.save();
//            Sighting sighting=new Sighting(location.find(),ranger.find(),1);
//            Sighting otherSighting=new Sighting(1,ranger.find(),1);
//            sighting.save();
//            otherSighting.save();
//            assertEquals(ranger.allSightings().get(0),sighting);
//            assertEquals(ranger.allSightings().get(1),otherSighting);
//        }catch (IllegalArgumentException e){
//            System.out.println(e);
//        }
//
//    }
//
//    //helper class
//    private Ranger setUpNewRanger() {
//        return new Ranger("sam","9867","5476");
//    }
//
//}