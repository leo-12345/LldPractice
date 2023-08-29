package com.LowLevelDesign;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LowLevelDesignApplicationTests {

	LowLevelDesignApplication lowLevelDesignApplication;
	@Test
	void contextLoads() {
		String[] args = new String[]{"Test","low","level","design"};
		LowLevelDesignApplication.main(args);
	}

}
