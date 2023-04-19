package runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(tags = "", features = "src/test/resource/Feature/Nationality.feature", 
glue = "GlueCode")
 

//https://stackoverflow.com/questions/41034116/how-to-execute-cucumber-feature-file-parallel
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
 
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
 
}

