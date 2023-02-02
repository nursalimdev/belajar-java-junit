package unit.test;

import org.junit.jupiter.api.*;

@DisplayName("information test")
public class InformationTest {

    @Test
    @DisplayName("test 1")
    @Tags({
            @Tag("one"),
            @Tag("two")
    })
    void test1(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestClass().orElse(null));
        System.out.println(testInfo.getTestMethod().orElse(null));
    }
}
