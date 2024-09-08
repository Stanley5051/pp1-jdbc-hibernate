package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String PASSWORD = "5051";
    private static final String USERNAME = "stanley_g";
    private static final String URL = "jdbc:postgresql://localhost:5432/JDBCdataBase";
    private static final String DRIVER = "org.postgresql.Driver";

    private static SessionFactory sessionFactory;

    //настройка соеденения с БД
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.url", URL);
            properties.setProperty("hibernate.connection.username", USERNAME);
            properties.setProperty("hibernate.connection.password", PASSWORD);
            properties.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");

            sessionFactory = new Configuration().addProperties(properties).addAnnotatedClass(User.class).buildSessionFactory();

        }
        return sessionFactory;

    }
}
