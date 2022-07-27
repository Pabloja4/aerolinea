
import Class.*;
import Model.*;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author pablo
 */
public class TestAeropuertoModel {
    
    public TestAeropuertoModel() {
    }
    
    private int suma(int num1, int num2){
        return num1+num2;
    }
   
    @Test
    public void testCreate(){
        AeropuertoModel aeropuerto_model = new AeropuertoModel();
        Aeropuerto a = new Aeropuerto(2, "Internacional de Mexico", "Mexico DF", "Mexico", 47878, 454545);
        int resultado = aeropuerto_model.Create(a);
        assertNotEquals(1, resultado);
    }

    @Test
    public void testUpdate(){
        AeropuertoModel aeropuerto_model = new AeropuertoModel();
        Aeropuerto a = new Aeropuerto(10, "Miguel Hidalgo y Costilla", "Guadalajara", "Mexico", 47878, 454545);
        int resultado = aeropuerto_model.Update(a, 14);
        assertNotEquals(0, resultado);
    }
    
    @Test
    public void testDelete(){
        AeropuertoModel aeropuerto_model = new AeropuertoModel();
        int resultado = aeropuerto_model.Delete(9);
        assertNotEquals(0, resultado);
    }



    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
