//package models;
//
//import org.junit.Rule;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class EndangeredTest {
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//    @Test
//    public void Endangered_instanciates_true(){
//        EndangeredAnimal testAnimal = new EndangeredAnimal("Sabertooth","okay","young");
//        assertEquals(true,testAnimal instanceof EndangeredAnimal);
//    }
//    @Test
//    public void Endangered_name(){
//        EndangeredAnimal testAnimal = new EndangeredAnimal("Sabertooth","okay","young");
//        assertEquals("Sabertooth",testAnimal.getName());
//    }
//    @Test
//    public void Endangered_Age(){
//        EndangeredAnimal testAnimal = new EndangeredAnimal("Sabertooth","okay","young","steve");
//        assertEquals("young",testAnimal.getAge());
//    }
//    @Test
//    public void Endangered_equals(){
//        EndangeredAnimal testAnimal = new EndangeredAnimal("Sabertooth","okay","young","steve");
//        EndangeredAnimal testAnimal2 = new EndangeredAnimal("Sabertooth","okay","young","steve");
//        assertEquals(false,testAnimal.equals(testAnimal2));
//    }
//
//    @Test
//    public void all_returnsAllInstancesOfEndangeredAnimal_false() {
//        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Fox", "Healthy", "Young","Barry");
//        firstEndangeredAnimal.save();
//        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("wolf", "Okay", "Adult","Joseph");
//        secondEndangeredAnimal.save();
//        assertEquals(false, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
//        assertEquals(false, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
//    }
//
//}