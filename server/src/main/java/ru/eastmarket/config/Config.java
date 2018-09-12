package ru.eastmarket.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

import static ru.eastmarket.config.Constants.BASE_PACKAGE;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Configuration
@EnableJpaRepositories(basePackages = BASE_PACKAGE)
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(BASE_PACKAGE)
public class Config {

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("db.hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("db.hibernate.show_sql", true);
		return properties;
	}

	@Bean
	public HikariDataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://212.19.138.211:3306/shop");
		config.setUsername("root");
		config.setPassword("Kbtu2011!");
		return new HikariDataSource(config);
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(BASE_PACKAGE);
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		factory.setJpaProperties(getHibernateProperties());
		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
