package ru.eastmarket;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@Configuration
@EnableJpaRepositories(basePackages = "ru.eastmarket")
//@EnableTransactionManagement
@EnableWebMvc
@ComponentScan("ru.eastmarket")
@PropertySource("classpath:database.properties")
public class Config {

	@Resource
	private Environment env;

	/*@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
		return dataSource;
	}*/
	/*@Bean
	public HikariDataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://212.19.138.211:3306/shop");
		config.setUsername("root");
		config.setPassword("Kbtu2011!");
		return new HikariDataSource(config);
	}*/

	/*@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("ru.eastmarket");
		entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
		return entityManagerFactoryBean;
	}*/

	/*@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}*/

	/*private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("db.hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("db.hibernate.show_sql", true);
		return properties;
	}*/

	/*private final Environment env;

	@Autowired
	public Config(Environment env) {
		this.env = env;
	}*/

	@Primary
	@Bean(name="dataSource")
	public HikariDataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://212.19.138.211:3306/shop");
		config.setUsername("root");
		config.setPassword("Kbtu2011!");
		return new HikariDataSource(config);
	}

	/*@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("ru.eastmarket");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		factory.setJpaProperties(getHibernateProperties());
		return factory.getObject();
	}*/

	/*@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}*/

	/*@Primary
	@Bean(name="dataSource")
	public DataSource dataSource() throws SQLException {
		DataSource dataSource = DataSourceBuilder.create()
				.username("user")
				.password("kaznitu123")
		jdbc:h2:mem:testdb;DB_CLOSE_ON_EXIT=FALSE")
				.build();
		return dataSource;
	}*/

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
		LocalContainerEntityManagerFactoryBean em
				= new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("ru.eastmarket");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return em;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory
					entityManagerFactory
	) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
