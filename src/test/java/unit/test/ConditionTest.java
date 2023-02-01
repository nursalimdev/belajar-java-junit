package unit.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionTest {
    @Test
    @EnabledOnOs({OS.WINDOWS})
    void testRunOnlyOnWindows(){

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    void disabledRunOnWindows(){

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    public void testEnableOnJava8(){

    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    public void testDisableOnJava8(){

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testEnableOnJava11To15(){
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testDisableOnJava11To15(){
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testEnableOnJavaVendorOracle(){
    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testDisableOnJavaVendorOracle(){
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void testEnabledOnDevEnvironment(){

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void testDisableOnDevEnvironment(){

    }
}
