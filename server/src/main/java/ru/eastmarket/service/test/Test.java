package ru.eastmarket.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.eastmarket.entity.test.TestEntity;
import ru.eastmarket.entity.test.TestEntityServiceImpl;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@RestController
public class Test {

	private final TestEntityServiceImpl entityService;

	@Autowired
	public Test(TestEntityServiceImpl entityService) {
		int i = 0;
		this.entityService = entityService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public TestEntity getMyData() {
		return entityService.get().get(0);
	}
}
