package configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan({"daos", "entities", "services", "views", "components", "configuration", "types", "reportVO"})
@EnableTransactionManagement
public class SpringConfig {

    public static StandardServiceRegistry registry;
    public static SessionFactory sessionFactory;
    public static ApplicationContext context;

    static {
        try {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

            Map<String, String> settings;
            settings = new HashMap<String, String>();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/relogio");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "postgres");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            settings.put(Environment.AUTO_CLOSE_SESSION, "true");
            settings.put(Environment.AUTOCOMMIT, "true");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.FORMAT_SQL, "true");

            registryBuilder.applySettings(settings);

            registry = registryBuilder.build();
            MetadataSources sources = new MetadataSources(registry);
            Metadata metadata = sources.getMetadataBuilder().build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
            context = new AnnotationConfigApplicationContext(SpringConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
            if (registry != null) {
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factory = null;
        try {
            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            vendorAdapter.setGenerateDdl(true);
            vendorAdapter.setShowSql(true);
            vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL94Dialect");

            HibernateJpaDialect jpd = new HibernateJpaDialect();

            factory = new LocalContainerEntityManagerFactoryBean();
            factory.setJpaDialect(jpd);
            factory.setJpaVendorAdapter(vendorAdapter);
            factory.setPackagesToScan(new String[]{"entities", "services", "daos", "views", "components", "configuration", "types", "reportVO"});
            factory.setDataSource(dataSource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return factory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/relogio");
        ds.setUsername("postgres");
        ds.setPassword("postgres");
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
