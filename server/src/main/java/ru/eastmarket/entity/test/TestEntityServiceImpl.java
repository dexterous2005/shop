package ru.eastmarket.entity.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Service
public class TestEntityServiceImpl implements TestEntityService {

	private final TestEntityRepository repository;

	@Autowired
	public TestEntityServiceImpl(TestEntityRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<TestEntity> get() {
		return repository.findAll();
	}
}
