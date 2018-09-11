package ru.eastmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Service
public class TestEntityServiceImpl implements TestEntityService {

	@Autowired
	private TestEntityRepository repository;

	@Override
	public List<TestEntity> get() {
		return repository.findAll();
	}
}
