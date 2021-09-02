package fr.formation.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("fr.formation.dao")
public class JpaConfig {
	// ici, on configure 3 beans DataSource, EntityManagerFactory et TransactionManager
	
		@Bean // donner le resultat de cette methode au context de spring
		public DataSource datasource(){
			BasicDataSource datasource = new BasicDataSource();
			
			//driver et autre copié-collé de persistence.xml
			datasource.setDriverClassName("org.postgresql.Driver");
			datasource.setUrl("jdbc:postgresql://127.0.0.1:5432/RPG");
			datasource.setUsername("postgres");
			datasource.setPassword("postgres");
			datasource.setMaxTotal(10);
			
			return datasource;
		}
		// configuration de EntityManagerFactory
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
			// container entityManagerFactory
			LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
			
			// fournisseur JPA = Hibernate
			JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
			
			// configurer emf
			emf.setDataSource(dataSource);
			emf.setPackagesToScan("fr.formation.model");
			emf.setJpaVendorAdapter(vendorAdapter);
			
			// configurer les properties liés au vendor, ici hibernate
			Properties hibernateProperties = new Properties();
			
			//hibernateProperties.setProperty("propertyName", "propertyValue");
			hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
			hibernateProperties.setProperty("hibernate.show_sql", "true");
			hibernateProperties.setProperty("hibernate.format_sql", "false");
			
			// associer ces properties à l'emf
			emf.setJpaProperties(hibernateProperties);
			
			return emf;
		}
		
		//configuration TransactionManager
		@Bean
		public JpaTransactionManager transactionManager (EntityManagerFactory emf){
			JpaTransactionManager transactionManager = new JpaTransactionManager();
			
			//associer emf au gestionnaire de transactions
			transactionManager.setEntityManagerFactory(emf);
			
			return transactionManager;
		}
		
}
