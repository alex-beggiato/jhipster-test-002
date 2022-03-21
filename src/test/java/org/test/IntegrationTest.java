package org.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.test.JhipsterTest002App;
import org.test.RedisTestContainerExtension;
import org.test.config.TestSecurityConfiguration;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { JhipsterTest002App.class, TestSecurityConfiguration.class })
@ExtendWith(RedisTestContainerExtension.class)
public @interface IntegrationTest {
}
