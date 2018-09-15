package ru.eastmarket.entity.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findAll();
}
