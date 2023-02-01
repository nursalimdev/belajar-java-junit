package unit.test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {
    private String temp;

    @Test
    void testA(){
        temp = "Nursalim";
    }

    @Test
    void testB(){
        System.out.println(temp);
    }
}
