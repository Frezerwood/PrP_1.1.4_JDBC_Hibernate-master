package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;
    private static SessionFactory sessionFactory1;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/kata");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "8RCDNjQUwpGg");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.SHOW_SQL, "false");

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Connection getConnection() {
        // реализуйте настройку соеденения с БД
        String PASS = "8RCDNjQUwpGg";
        String USER = "root";
        String URL = "jdbc:mysql://localhost:3306/kata";

        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static SessionFactory getSessionFactory2() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/kata");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "8RCDNjQUwpGg");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.SHOW_SQL, "false");

//        SessionFactory sessionFactory1 = new Configuration()
//                .addAnnotatedClass(User.class)
//                .setProperties(properties)
//                .buildSessionFactory();

//        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
//        settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
//        settings.put("hibernate.connection.url",
//                "jdbc:mysql://localhost/hibernate_examples");
//        settings.put("hibernate.connection.username", "root");
//        settings.put("hibernate.connection.password", "password");
//        settings.put("hibernate.current_session_context_class", "thread");
//        settings.put("hibernate.show_sql", "true");
//        settings.put("hibernate.format_sql", "true");

                Map<String, String> settings = new HashMap<>();
                settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
                settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
                settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/kata");
                settings.put("hibernate.connection.username", "root");
                settings.put("hibernate.connection.password", "8RCDNjQUwpGg");
                settings.put("hibernate.current_session_context_class", "thread");
                settings.put("hibernate.show_sql", "true");
                settings.put("hibernate.format_sql", "true");

                // Map<String, String> stringObjectMap = settings;
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(properties).build();

                MetadataSources metadataSources = new MetadataSources(serviceRegistry);
                // metadataSources.addAnnotatedClass(Player.class);
                Metadata metadata = metadataSources.buildMetadata();

                // here we build the SessionFactory (Hibernate 5.4)
                SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .loadProperties(String.valueOf(config)).build();
//        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//        SessionFactory sessionFactory1 = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return sessionFactory1;
    }
}

//    Configuration con = new Configuration()
//            .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
//            .setProperty("hibernate.connection.datasource", "jdbc:mysql://localhost:3306/kata")
//            .setProperty("hibernate.order_updates", "true");