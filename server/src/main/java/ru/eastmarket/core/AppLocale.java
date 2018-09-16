package ru.eastmarket.core;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
public enum AppLocale {

	RU(new Locale("ru")),

	KK(new Locale("kk")),

	EN(new Locale("en"));

	private final Locale locale;

	AppLocale(Locale locale) {
		this.locale = locale;
	}

	public Locale getLocale() {
		return locale;
	}

	public static AppLocale valueOf(Locale locale) {
		return Arrays.stream(values()).filter(appLocale -> appLocale.getLocale().equals(locale))
				.findFirst().orElse(null);
	}
}
