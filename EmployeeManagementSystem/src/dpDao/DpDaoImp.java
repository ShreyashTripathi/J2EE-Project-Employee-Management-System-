package dpDao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import model.Development_emp;
import model.Development_head;
import model.Marketing_emp;
import model.Marketing_head;
import model.Recruitment_emp;
import model.Recruitment_head;
import model.Testing_emp;
import model.Testing_head;

public class DpDaoImp implements DpDaoInt {

	@Override
	public List showMsg(String dpt) throws BusinessException {

		ConnectionDetails connection = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		connection = GetConnection.getConnection();
		factory = connection.getFactory();
		session = connection.getSession();
		transaction = connection.getTransaction();

		String hql = null;
		if (dpt.equals("development")) {

			hql = "from model.Development_head";

		} else if (dpt.equals("marketing")) {

			hql = "from model.Marketing_head";

		} else if (dpt.equals("testing")) {

			hql = "from model.Testing_head";

		} else if (dpt.equals("recruitment")) {

			hql = "from model.Recruitment_head";

		}
		List ls;
		try {
			Query query = session.createQuery(hql);
			ls = query.list();
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		} finally {
			closeConnection(transaction, session, factory);
		}
		return ls;
		/*
		 * List<Map<Integer,String>> ls = new ArrayList<>(); String table = null;
		 * if(dpt.equals("development")) { table = "development_head"; }else
		 * if(dpt.equals("marketing")) { table = "marketing_head"; }else
		 * if(dpt.equals("testing")) { table = "testing_head"; }else
		 * if(dpt.equals("recruitment")) { table = "recruitment_head"; } Connection
		 * connection = null; try { connection = GetConnection.getConnection(); String
		 * query = "select * from "+table; PreparedStatement st =
		 * connection.prepareStatement(query); ResultSet result = st.executeQuery();
		 * 
		 * while(result.next()) { Map<Integer,String> mp = new HashMap<>(); int id =
		 * result.getInt("id"); String msg = result.getString("msg"); mp.put(new
		 * Integer(id),msg); ls.add(mp); } return ls; } catch (SQLException e) { throw
		 * new BusinessException(e.getMessage()); }finally { try { connection.close(); }
		 * catch (SQLException e) { throw new BusinessException(e.getMessage()); } }
		 */

	}

	private void closeConnection(Transaction transaction, Session session, SessionFactory factory) {
		transaction.commit();
		session.close();
		factory.close();
	}

	private void myCast(String dpt,Object obj,Session session) {

		if (dpt.equals("development")) {

			Development_head object = (Development_head) obj;
			Development_emp empObject = new Development_emp();
			empObject.setMsg(object.getMsg());
			session.save(empObject);
			

		} else if (dpt.equals("marketing")) {

			Marketing_head object = (Marketing_head) obj;
			Marketing_emp empObject = new Marketing_emp();
			empObject.setMsg(object.getMsg());
			session.save(empObject);
		} else if (dpt.equals("testing")) {

			Testing_head object = (Testing_head) obj;
			Testing_emp empObject = new Testing_emp();
			empObject.setMsg(object.getMsg());
			session.save(empObject);

		} else if (dpt.equals("recruitment")) {

			Recruitment_head object = (Recruitment_head) obj;
			Recruitment_emp empObject = new Recruitment_emp();
			empObject.setMsg(object.getMsg());
			session.save(empObject);

		}

	}
	@Override
	public void passMsg(String dpt, List<Object> ls) throws BusinessException {

		ConnectionDetails connection = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		connection = GetConnection.getConnection();
		factory = connection.getFactory();
		session = connection.getSession();
		transaction = connection.getTransaction();
       
		String s1 = dpt;
		String s2 = s1.substring(0,1);
		String s3 = s2.toUpperCase();
		String res = s3+s1.substring(1)+"_head";
		
		String hql = "delete from model."+res;
		int temp = 0;
		try {
			for (Object obj : ls) {
				temp = 1;
				myCast(dpt,obj,session);
			}
			if(temp==1) {
				Query query = session.createQuery(hql);
				query.executeUpdate();
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		} finally {
			closeConnection(transaction, session, factory);
		}

		/*
		 * String table = null; String table2 = null; if (dpt.equals("development")) {
		 * table = "development_emp"; table2 = "development_head"; } else if
		 * (dpt.equals("marketing")) { table = "marketing_emp"; table2 =
		 * "marketing_head"; } else if (dpt.equals("testing")) { table = "testing_emp";
		 * table2 = "testing_head"; } else if (dpt.equals("recruitment")) { table =
		 * "recruitment_emp"; table2 = "recruitment_head"; } Connection connection =
		 * null; try { connection = GetConnection.getConnection(); for (int i = 0; i <
		 * ls.size(); i++) { Map<Integer, String> mp = (Map<Integer, String>) ls.get(i);
		 * String query = "insert into " + table + "(msg) values(?)"; PreparedStatement
		 * st = connection.prepareStatement(query); for (String msg : mp.values()) {
		 * st.setString(1, msg); } st.executeUpdate(); } Statement statement =
		 * connection.createStatement(); String query = "truncate table " + table2;
		 * statement.execute(query); } catch (SQLException e) { throw new
		 * BusinessException(e.getMessage()); } finally { try { connection.close(); }
		 * catch (SQLException e) { throw new BusinessException(e.getMessage()); } }
		 */

	}

	@Override
	public List showMsgEmp(String dpt) throws BusinessException {

		
		ConnectionDetails connection = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		connection = GetConnection.getConnection();
		factory = connection.getFactory();
		session = connection.getSession();
		transaction = connection.getTransaction();

		String hql = null;
		if (dpt.equals("development")) {

			hql = "from model.Development_emp";

		} else if (dpt.equals("marketing")) {

			hql = "from model.Marketing_emp";

		} else if (dpt.equals("testing")) {

			hql = "from model.Testing_emp";

		} else if (dpt.equals("recruitment")) {

			hql = "from model.Recruitment_emp";

		}
		List ls;
		try {
			Query query = session.createQuery(hql);
			ls = query.list();
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		} finally {
			closeConnection(transaction, session, factory);
		}
		return ls;
		/*List<Map<Integer, String>> ls = new ArrayList<>();
		String table = null;
		if (dpt.equals("development")) {
			table = "development_emp";
		} else if (dpt.equals("marketing")) {
			table = "marketing_emp";
		} else if (dpt.equals("testing")) {
			table = "testing_emp";
		} else if (dpt.equals("recruitment")) {
			table = "recruitment_emp";
		}
		Connection connection = null;
		try {
			connection = GetConnection.getConnection();
			String query = "select * from " + table;
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();

			while (result.next()) {
				Map<Integer, String> mp = new HashMap<>();
				int id = result.getInt("id");
				String msg = result.getString("msg");
				mp.put(new Integer(id), msg);
				ls.add(mp);
			}
			return ls;
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new BusinessException(e.getMessage());
			}
		}*/
	}

}
