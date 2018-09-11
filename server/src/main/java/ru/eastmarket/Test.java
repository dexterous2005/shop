package ru.eastmarket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@RestController
public class Test {

	public Test() {
		int i = 0;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public TestEntity getMyData() {
		return new TestEntityServiceImpl().get().get(0);
	}
}
