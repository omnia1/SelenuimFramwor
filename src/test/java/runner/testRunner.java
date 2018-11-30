package runner;

import Tests.TestBase;
import cucumber.api.CucumberOptions;

@CucumberOptions(features="src/test/java/features"
,glue= {"stepDefinition"} 
,plugin = {"pretty","html:target/cucumber-html-report"})
public class testRunner extends TestBase {

}
