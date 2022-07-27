/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import Class.*;
import Model.*;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author pablo
 */
public class TestAvionModel {
    
    public TestAvionModel() {
    }
 
    @Test
    public void testCreate(){
        AvionModel avion_model = new AvionModel();
        Avion avi = new Avion(10, "Boeing 747" , 550, 3, 448);
        int resultado = avion_model.Create(avi);
        assertNotEquals(1, resultado);
    }

    @Test
    public void testUpdate(){
        AvionModel avion_model = new AvionModel();
        Avion avi = new Avion(4, "Airbus A320", 200, 1, 200);
        int resultado = avion_model.Update(avi, 4);
        assertNotEquals(0, resultado);
    }
//    
    @Test
    public void testDelete(){
        AvionModel avion_model = new AvionModel();
        int resultado = avion_model.Delete(9);
        assertNotEquals(0, resultado);
    }
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
