package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.GetConnection;
import exception.BusinessException;
import model.ConnectionDetails;
import model.Development_head;
import model.Marketing_head;
import model.Recruitment_head;
import model.Testing_head;

public class AdminDaoImp implements AdminDaoInt {

	@Override
	public void sendMessage(String dept, String msg) throws BusinessException {

		ConnectionDetails connection = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		connection = GetConnection.getConnection();
		factory = connection.getFactory();
		session = connection.getSession();
		transaction = connection.getTransaction();

		if (dept.equals("development")) {

			Development_head obj = new Development_head();
			obj.setMsg(msg);
			session.save(obj);

		} else if (dept.equals("marketing")) {

			Marketing_head obj = new Marketing_head();
			obj.setMsg(msg);
			session.save(obj);

		} else if (dept.equals("testing")) {

			Testing_head obj = new Testing_head();
			obj.setMsg(msg);
			session.save(obj);

		} else if (dept.equals("recruitment")) {

			Recruitment_head obj = new Recruitment_head();
			obj.setMsg(msg);
			session.save(obj);

		}

		closeConnection(transaction, session, factory);

		/*
		 * String table = null; if(dept.equals("development")) { table =
		 * "development_head"; }else if(dept.equals("marketing")) { table =
		 * "marketing_head"; }else if(dept.equals("testing")) { table = "testing_head";
		 * }else if(dept.equals("recruitment")) { table = "recruitment_head"; }
		 * Connection connection = null; try { connection =
		 * GetConnection.getConnection(); String query =
		 * "insert into "+table+"(msg) values(?)"; PreparedStatement st =
		 * connection.prepareStatement(query); st.setString(1,msg); st.executeUpdate();
		 * } catch (SQLException e) { throw new BusinessException(e.getMessage());
		 * }finally { try { connection.close(); } catch (SQLException e) { throw new
		 * BusinessException(e.getMessage()); } }
		 */
	}

	private void closeConnection(Transaction transaction, Session session, SessionFactory factory) {
		transaction.commit();
		session.close();
		factory.close();
	}

}
