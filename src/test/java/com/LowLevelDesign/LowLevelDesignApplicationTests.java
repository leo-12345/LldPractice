package com.LowLevelDesign;

import com.LowLevelDesign.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LowLevelDesignApplicationTests {

	@InjectMocks
	private TestService testService;
	@Test
	public void contextLoads() {
		String[] args = new String[]{"Test","low","level","design"};
		testService.test();
	}

}
