package registerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.GetConnection;
import exception.BusinessException;
import model.ConnectionDetails;
import model.Development_emp;
import model.User;

public class RegisterDaoImp implements RegisterDaoInt {

	@Override
	public void registerUser(User user) throws BusinessException {

		ConnectionDetails connection = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		connection = GetConnection.getConnection();
		// try{connection = GetConnection.getConnection();}catch(Exception e) {
		// throw new BusinessException(e.getMessage());
		// }
		factory = connection.getFactory();
		session = connection.getSession();
		transaction = connection.getTransaction();

		
          String userId = user.getUserId();
		
		  User inomingUser = session.get(model.User.class,userId);
		  if(inomingUser!=null){ closeConnection(transaction,session,factory); throw
		  new BusinessException("User with than userId is already registered"); }
		  
		  closeConnection(transaction,session,factory);
		  
		  
		  connection = GetConnection.getConnection(); factory =
		  connection.getFactory(); session = connection.getSession(); transaction =
		  connection.getTransaction();
		 

		session.save(user);

		closeConnection(transaction, session, factory);

		/*
		 * Connection connection = GetConnection.getConnection();
		 * 
		 * String tempQuery = "select * from usertb where userId=? and passWord=?";
		 * 
		 * PreparedStatement statement;
		 * 
		 * 
		 * String query =
		 * "insert into usertb(fatherName,gender,dateOfBirth,collegeName,experience,prevSalary,specialization,designation,contactNo,email,address1,address2,city,postalCode,empName,userId,passWord)"
		 * + "      values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; try {
		 * 
		 * ////Checkin if user already exists.. statement =
		 * connection.prepareStatement(tempQuery); statement.setString(1,
		 * user.getUserId()); statement.setString(2, user.getPassWord()); ResultSet
		 * result = statement.executeQuery(); if (result.next() == true) { throw new
		 * BusinessException("User already registered with that userId and passWord"); }
		 * 
		 * 
		 * 
		 * PreparedStatement preparedStatement = connection.prepareStatement(query);
		 * 
		 * preparedStatement.setString(1, user.getFatherName());
		 * preparedStatement.setString(2, user.getGender());
		 * preparedStatement.setString(3, user.getDateOfBirth());
		 * preparedStatement.setString(4, user.getCollegeName());
		 * preparedStatement.setString(5, user.getExperience());
		 * preparedStatement.setString(6, user.getPrevSalary());
		 * preparedStatement.setString(7, user.getSpecialization());
		 * preparedStatement.setString(8, user.getDesignation());
		 * preparedStatement.setString(9, user.getContactNo());
		 * preparedStatement.setString(10, user.getEmail());
		 * preparedStatement.setString(11, user.getAddress1());
		 * preparedStatement.setString(12, user.getAddress2());
		 * preparedStatement.setString(13, user.getCity());
		 * preparedStatement.setString(14, user.getPostalCode());
		 * 
		 * preparedStatement.setString(15, user.getEmployeeName());
		 * preparedStatement.setString(16, user.getUserId());
		 * preparedStatement.setString(17, user.getPassWord());
		 * 
		 * preparedStatement.executeUpdate();
		 * 
		 * } catch (SQLException e) { throw new BusinessException(e.getMessage()); }
		 * finally { try { connection.close(); } catch (SQLException e) { throw new
		 * BusinessException(e.getMessage()); } }
		 */

	}

	private void closeConnection(Transaction transaction, Session session, SessionFactory factory) {
		transaction.commit();
		session.close();
		factory.close();
	}

}
