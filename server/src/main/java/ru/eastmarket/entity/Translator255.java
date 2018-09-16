package ru.eastmarket.entity;

import ru.eastmarket.core.AbstractEntity;
import ru.eastmarket.core.AppLocale;
import ru.eastmarket.core.TranslatorEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Locale;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Entity
@Table(name = "translator255")
public class Translator255 extends AbstractEntity implements TranslatorEntity {

	@Column(name = "ru", nullable = false)
	private String ru;

	@Column(name = "kk")
	private String kk;

	@Column(name = "en")
	private String en;

	@Override
	public String getRu() {
		return ru;
	}

	public void setRu(String ru) {
		this.ru = ru;
	}

	@Override
	public String getKk() {
		return kk;
	}

	public void setKk(String kk) {
		this.kk = kk;
	}

	@Override
	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	@Override
	public String toString(Locale locale) {
		AppLocale appLocale = AppLocale.valueOf(locale);
		switch (appLocale) {

			case RU:
				return getRu();
			case KK:
				return getKk();
			case EN:
				return getEn();
		}
		return getRu();
	}
}
