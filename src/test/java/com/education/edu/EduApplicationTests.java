package com.education.edu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DisplayName("Test EduApplication")
@SpringBootTest(classes = { EduApplication.class, MockServletContext.class })
public class EduApplicationTests {

	@Test
	public void contextLoads() {
	}

}
