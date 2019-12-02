package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber","rerun:target/rerun.txt"},
        features = "src/test/resource/features",
        glue = "stepDefs",
        tags ="@login",
        dryRun = true
)
public class runnerClass {
}


