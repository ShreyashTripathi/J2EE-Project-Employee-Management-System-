package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import exception.BusinessException;
import model.ConnectionDetails;

public class GetConnection {
	public static ConnectionDetails getConnection() throws BusinessException {
		/*
		 * Configuration configuration = new Configuration();
		 * 
		 * StandardServiceRegistryBuilder builder = new
		 * StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
		 * ; SessionFactory factory =
		 * configuration.buildSessionFactory(builder.build()); Session session =
		 * factory.openSession(); Transaction transaction = session.beginTransaction();
		 */

		Configuration configuration = new Configuration();
		configuration.configure("com/hibernate.cfg.xml");
		configuration.addAnnotatedClass(model.Development_emp.class);
		configuration.addAnnotatedClass(model.User.class);

		configuration.addAnnotatedClass(model.Dep_head.class);

		configuration.addAnnotatedClass(model.Development_head.class);
		configuration.addAnnotatedClass(model.Employee.class);
		configuration.addAnnotatedClass(model.Marketing_emp.class);
		configuration.addAnnotatedClass(model.Marketing_head.class);
		configuration.addAnnotatedClass(model.Recruitment_emp.class);
		configuration.addAnnotatedClass(model.Recruitment_head.class);
		configuration.addAnnotatedClass(model.Testing_emp.class);
		configuration.addAnnotatedClass(model.Testing_head.class);
		configuration.addAnnotatedClass(model.Reply_emp.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		ConnectionDetails connection = new ConnectionDetails();
		connection.setFactory(factory);
		connection.setSession(session);
		connection.setTransaction(transaction);

		return connection;

	}
}
