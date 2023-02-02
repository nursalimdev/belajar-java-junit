package unit.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import unit.test.resolver.RandomParameterResolver;

import java.util.Random;


public class RandomCalculatorTest extends AbstractCalculatorTest{

    @Test
    void testRandom(Random random){

        Integer a = random.nextInt();
        Integer b = random.nextInt();

        Integer result = calculator.add(a, b);
        Integer expected = a + b;
        Assertions.assertEquals(expected, result);
    }
}
