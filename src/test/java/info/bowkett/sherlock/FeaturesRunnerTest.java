package info.bowkett.sherlock;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@Cucumber.Options(features = {"src/test/features"})
public class FeaturesRunnerTest {

}

