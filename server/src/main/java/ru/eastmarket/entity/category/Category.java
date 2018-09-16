package ru.eastmarket.entity.category;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.eastmarket.core.AbstractEntity;
import ru.eastmarket.core.TranslatedEntity;
import ru.eastmarket.entity.Translator255;

import javax.persistence.*;
import java.util.Locale;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Entity
@Table(name = "category")
public class Category extends AbstractEntity implements TranslatedEntity {

	@ManyToOne
	@JoinColumn(name = "parent_id", referencedColumnName = "id",
			foreignKey = @ForeignKey(name = "parent_fk"))
	private Category parent;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "name", referencedColumnName = "id", nullable = false,
			foreignKey = @ForeignKey(name = "name_fk"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Translator255 name;

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Translator255 getName() {
		return name;
	}

	public void setName(Translator255 name) {
		this.name = name;
	}

	@Override
	public String toString(Locale locale) {
		return name.toString(locale);
	}
}
