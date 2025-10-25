package Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private Base base;

    @Before
    public void setUp() {
        // Always start fresh for each scenario
        base = new Base();
    }

    @After
    public void tearDown() {
        if (base != null && Base.driver != null) {
            base.quitDriver();
        }
    }
}
