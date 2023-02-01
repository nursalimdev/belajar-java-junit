package unit.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    @Test
    public void testAddSuccess(){
        var result = calculator.add(10, 10);

//        manual without assertion
//        if(result != 20){
//            throw new RuntimeException("Test gagal");
//        }

        assertEquals(20, result);
    }

    @Test
    public void testDivideSuccess(){
        var result = calculator.divide(100, 2);
        assertEquals(50, result);
    }

    @Test
    public void testDivideFailed(){
        assertThrows(IllegalArgumentException.class, () -> {
           calculator.divide(10, 10);
        });
    }
}
