package condition;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.JRE;

@Target({TYPE, METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DisabledOnJre(JRE.JAVA_8)
public @interface DisabledOnJRE8 {

}