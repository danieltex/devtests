package jbehave.configuration;


import java.util.Arrays;
import java.util.List;

import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ScanningStepsFactory;
import org.junit.runner.RunWith;

/**
 * generic binder for all JBehave tests. Binds all the story files to the
 * step files. works for both Eclipse and Maven command line build. *
 * @author funktapuss
 *
 * Copiado de <a href="https://stackoverflow.com/questions/20733703/very-simple-step-by-step-jbehave-setup-tutorial">JBehave Runner Genérico</a>
 *
 */

@RunWith(JUnitReportingRunner.class)
public class JBehaveRunnerTest extends JUnitStories {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
            .useStoryLoader(
                new LoadFromClasspath(this.getClass().getClassLoader()))
            .useStoryReporterBuilder(
                new StoryReporterBuilder()
                    .withDefaultFormats()
                    .withFormats(Format.HTML, Format.CONSOLE)
                    .withRelativeDirectory("jbehave-report")
            );
    }

    public InjectableStepsFactory stepsFactory() {
        return new ScanningStepsFactory(configuration(), "jbehave.steps")
            .matchingNames(".*Steps")
            .notMatchingNames(".*SkipSteps");
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().
            findPaths(CodeLocations.codeLocationFromClass(
                this.getClass()),
                Arrays.asList("**/*.story"),
                Arrays.asList(""));
    }

}