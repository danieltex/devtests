package jbehave.configuration;


import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import jbehave.steps.BuscadorSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * generic binder for all JBehave tests. Binds all the story files to the
 * step files. works for both Eclipse and Maven command line build.
 *
 * (Copiado de <a href="https://stackoverflow.com/questions/20733703/very-simple-step-by-step-jbehave-setup-tutorial">JBehave Runner Genérico</a>)
 *
 * @author funktapuss
 */
@RunWith(JUnitReportingRunner.class)
public class JBehaveRunnerTest extends JUnitStories {

    private Configuration configuration;

    public JBehaveRunnerTest() {
        configuration = new MostUsefulConfiguration();
    }

    @Override
    public Configuration configuration() {
        return configuration;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new BuscadorSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
            .findPaths(CodeLocations.codeLocationFromClass(this.getClass()),"**/*.story","");
    }

}