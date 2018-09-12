package ru.eastmarket.entity.test;

import ru.eastmarket.core.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Entity
@Table(name = "test_entity")
public class TestEntity extends AbstractEntity {

	@Column(name = "name", length = 256)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
