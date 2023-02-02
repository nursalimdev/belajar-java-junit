package unit.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import unit.test.resolver.RandomParameterResolver;

import java.util.List;
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

    @RepeatedTest(value = 10, name = "{displayName} ke {currentRepetition} dari total ${totalRepetitions}")
    void testRandomRepeated(Random random){

        Integer a = random.nextInt();
        Integer b = random.nextInt();

        Integer result = calculator.add(a, b);
        Integer expected = a + b;
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test random calculator")
    @RepeatedTest(value = 10, name = "{displayName}")
    void testRandomRepeatInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo){
        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());

        Integer a = random.nextInt();
        Integer b = random.nextInt();

        Integer result = calculator.add(a, b);
        Integer expected = a + b;
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test calculator ")
    @ParameterizedTest(name = "{displayName} dengan parameter {0} ")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testWithParameter(int value){
        int expected = value + value;
        int result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }

    private static List<Integer> parameterSource(){
        return List.of(1, 2, 3, 4, 5);
    }

    @DisplayName("Test calculator ")
    @ParameterizedTest(name = "{displayName} dengan parameter {0} ")
    @MethodSource({"parameterSource"})
    void testWithMethodSource(Integer value){
        Integer expected = value + value;
        Integer result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }
}
