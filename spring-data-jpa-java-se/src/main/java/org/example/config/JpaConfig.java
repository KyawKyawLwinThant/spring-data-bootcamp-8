package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"org.example.dao"})
public class JpaConfig {
    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean
        entityManagerFactory(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean em=
                new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("org.example.entity");
        JpaVendorAdapter vendorAdapter=
                new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }
    @Bean
    public PlatformTransactionManager
        transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager=
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return  transactionManager;
    }


}
