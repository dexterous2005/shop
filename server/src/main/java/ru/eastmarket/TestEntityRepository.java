package ru.eastmarket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {

	List<TestEntity> findAll();

	//TestEntity findByName(String name);
}