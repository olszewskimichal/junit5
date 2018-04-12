package newest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.support.AnnotationSupport;
import org.junit.platform.commons.support.ReflectionSupport;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ClassFilter;
import org.junit.platform.commons.util.ModuleUtils;

public class Features511 {

  @Test
  void shouldGetAllClassesInModule() {
    ModuleUtils.findAllNonSystemBootModuleNames();
    ModuleUtils.findAllClassesInModule("moduleName", ClassFilter.of(Predicate.isEqual(this.getClass())));
    ReflectionSupport.findAllClassesInPackage("", Class::isEnum, s -> !s.isEmpty());
  }

  @Test
  void isAnnotated() {
    System.out.println(AnnotationUtils.isAnnotated(this.getClass(), Tag.class));
    System.out.println(AnnotationSupport.isAnnotated(this.getClass(), Tag.class));
  }

  @Test
  void findAnnotation() {
    Optional<Tag> annotation = AnnotationUtils.findAnnotation(this.getClass(), Tag.class);
    assertThat(annotation).isNotPresent();
  }

  @Test
  void findRepeatableAnnotations() {
    List<Tag> repeatableAnnotations = AnnotationUtils.findRepeatableAnnotations(this.getClass(), Tag.class);
    assertThat(repeatableAnnotations).isEmpty();
  }

}
