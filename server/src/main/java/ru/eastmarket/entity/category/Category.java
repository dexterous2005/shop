package ru.eastmarket.entity.category;

import ru.eastmarket.core.AbstractEntity;

import javax.persistence.*;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Entity
@Table(name = "category",
		indexes = @Index(name = "category_index", columnList = "parent_id, name", unique = true))
public class Category extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "parent_id", referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "parent_fk"))
	private Category parent;

	@Column(name = "name", nullable = false)
	private String name;

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
