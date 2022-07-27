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
public class TestRutaModel {
    
    public TestRutaModel() {
    }
    
    @Test
    public void testCreate(){
        RutaModel ruta_model = new RutaModel();
        Ruta r = new Ruta(7, 1, 2, 40, "La Nubia", "El Dorado", 0);
        int resultado = ruta_model.Create(r);
        assertNotEquals(1, resultado);
    }
    
    
    @Test
    public void testUpdate(){
        RutaModel ruta_model = new RutaModel();
        Ruta r = new Ruta(7, 1, 2, 40, "La Nubia", "El Dorado", 0);
        int resultado = ruta_model.Update(r, 5);
        assertNotEquals(0, resultado);
    }
    
    
     @Test
    public void testDelete(){
        RutaModel ruta_model = new RutaModel();
        int resultado = ruta_model.Delete(5);
        assertNotEquals(0, resultado);
    }  

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
