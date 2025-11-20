package testDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import testDemo.application.Application;


@SpringBootTest(classes = Application.class)
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
