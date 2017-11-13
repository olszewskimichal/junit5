package suites;

import basics.BasicAnnotations;
import basics.ExceptionHandlingTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ExceptionHandlingTest.class, BasicAnnotations.class})
public class ClassSuite {

}
