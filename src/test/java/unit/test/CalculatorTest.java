package unit.test;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import unit.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayName("Test untuk Calculator")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Sebelum unit test dijalankan");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Setelah unit test dijalankan");
    }

    @Test
//    @DisplayName("Test skenario sukses untuk method add(integer, integer)")
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
           calculator.divide(10, 0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon(){
        //TODO
    }

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        System.out.println(profile);

        if(!"DEV".equals(profile)){
            throw new TestAbortedException("Test dibatalkan karena bukan dev");
        }

        // unit test untuk dev
    }
}
