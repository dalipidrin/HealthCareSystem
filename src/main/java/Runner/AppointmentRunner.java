package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        //provo nashta me slasha tjere bon
        features = "C:\\Users\\ShkollaDigjitale\\Desktop\\HealthCareSystemFolder\\src\\main\\java\\AppointmentFeature", //the path of the feature files
        glue={"AppointmentStepDefinitions"}
)

public class AppointmentRunner {


}
