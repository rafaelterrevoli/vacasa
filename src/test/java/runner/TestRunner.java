package runner;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        glue = {"steps"},
        features = "src/test/java/features/busqueda.feature",
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-report/report.html"},
        tags={"@test"}
)
public class TestRunner {
        @AfterClass
        public static void writeExtentReport() {
                Reporter.loadXMLConfig("src/extent-config.xml");
        }
}

