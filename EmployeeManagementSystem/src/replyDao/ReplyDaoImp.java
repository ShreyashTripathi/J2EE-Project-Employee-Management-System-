package replyDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.GetConnection;
import exception.BusinessException;
import model.ConnectionDetails;
import model.Reply_emp;

public class ReplyDaoImp implements ReplyDaoInt {

	@Override
	public void insertReply(String dpt, String msg) throws BusinessException {
		ConnectionDetails connection = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		connection = GetConnection.getConnection();
		factory = connection.getFactory();
		session = connection.getSession();
		transaction = connection.getTransaction();

		Reply_emp reply = new Reply_emp();
		reply.setDepartment(dpt);
		reply.setMsg(msg);
		session.save(reply);
		// closing the connection
		closeConnection(transaction, session, factory);

		/*
		 * Connection connection = GetConnection.getConnection(); String sql =
		 * "insert into reply_emp(msg,department) values(?,?)"; try { PreparedStatement
		 * statement = connection.prepareStatement(sql); statement.setString(1,msg);
		 * statement.setString(2,dpt); statement.executeUpdate();
		 * 
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

	@Override
	public List<Reply_emp> viewReply() throws BusinessException {
		ConnectionDetails connection = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		connection = GetConnection.getConnection();
		factory = connection.getFactory();
		session = connection.getSession();
		transaction = connection.getTransaction();

		String hql = "from model.Reply_emp";
		Query query = session.createQuery(hql);
		List<Reply_emp> list = query.list();
		closeConnection(transaction, session, factory);
		return list;
		

		/*
		 * Map<String,String> mp = new HashMap<>(); Connection connection =
		 * GetConnection.getConnection(); String sql = "select * from reply_emp"; try {
		 * PreparedStatement statement = connection.prepareStatement(sql); ResultSet
		 * result = statement.executeQuery(); while(result.next()) { String currentMsg =
		 * result.getString("msg"); String currentDpt = result.getString("department");
		 * mp.put(currentMsg, currentDpt); } return mp;
		 * 
		 * } catch (SQLException e) { throw new BusinessException(e.getMessage());
		 * }finally { try { connection.close(); } catch (SQLException e) { throw new
		 * BusinessException(e.getMessage()); } }
		 */

	}

}
