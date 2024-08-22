package cl.previred.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"cl.previred.stepDefinitions.base"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/tests/reporte-prueba.html"},
        tags = ""


)
public class MainRunner extends AbstractTestNGCucumberTests {

}