package loginDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.GetConnection;
import exception.BusinessException;
import model.ConnectionDetails;
import model.Dep_head;
import model.Employee;
import model.MyTable;

import model.User;

public class LoginDaoImp implements LoginDaoInt {

	@Override
	public void loginUser(User user, HttpServletRequest request, HttpServletResponse response, MyTable myTable)
			throws BusinessException {

		ConnectionDetails connection = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		connection = GetConnection.getConnection();
		factory = connection.getFactory();
		session = connection.getSession();
		transaction = connection.getTransaction();

		String userId = user.getUserId();
		User loginUser = null;

		loginUser = session.get(model.User.class, userId);
		Query query = session.createQuery("from model.User where password=:pass");
		query.setString("pass", user.getPassWord());
		List lsPass = query.list();
		
		if (loginUser == null && !lsPass.isEmpty()) {
			closeConnection(transaction, session, factory);
			throw new BusinessException("User with that email id does not exist!!");
		}else if (loginUser != null && lsPass.isEmpty()) {
			closeConnection(transaction, session, factory);
			throw new BusinessException("User with that email id exists but Password in wrong!!.You might have forgotten the password..");
		}else if (loginUser == null && lsPass.isEmpty()) {
			closeConnection(transaction, session, factory);
			throw new BusinessException("User does not exist with that email id and password..");
		}

		user.setFatherName(loginUser.getFatherName());
		user.setGender(loginUser.getGender());
		user.setDateOfBirth(loginUser.getDateOfBirth());
		user.setCollegeName(loginUser.getCollegeName());
		user.setExperience(loginUser.getExperience());
		user.setPrevSalary(loginUser.getPrevSalary());
		user.setSpecialization(loginUser.getSpecialization());
		user.setDesignation(loginUser.getDesignation());
		user.setContactNo(loginUser.getContactNo());
		user.setEmail(loginUser.getEmail());
		user.setAddress1(loginUser.getAddress1());
		user.setAddress2(loginUser.getAddress2());
		user.setCity(loginUser.getCity());
		user.setPostalCode(loginUser.getPostalCode());
		user.setEmployeeName(loginUser.getEmployeeName());

		String table = null;

		if (user.getDesignation().equals("DepartmentHead")) {
			table = "Dep_head";
			Dep_head dep_head = session.get(model.Dep_head.class, userId);
			if (dep_head == null) {
				RequestDispatcher rd = request.getRequestDispatcher("DepartmentPage.jsp");
				myTable.setTableName(table);
				try {
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					throw new BusinessException(e.getMessage());
				} finally {
					closeConnection(transaction, session, factory);
				}
			} else {
				user.setDepartment(dep_head.getDepartment());
			}

		} else if (user.getDesignation().equals("Employee")) {
			table = "Employee";
			Employee employee = session.get(model.Employee.class, userId);

			if (employee == null) {
				RequestDispatcher rd = request.getRequestDispatcher("DepartmentPage.jsp");
				myTable.setTableName(table);
				try {
					// closeConnection(transaction, session, factory);
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					throw new BusinessException(e.getMessage());
				}
			} else {
				user.setDepartment(employee.getDepartment());
			}
		}

		closeConnection(transaction, session, factory);

		/*
		 * Connection connection = GetConnection.getConnection(); String userId =
		 * user.getUserId(); String passWord = user.getPassWord(); User currentUser =
		 * user; String query = "select * from usertb where userId=? and passWord=?";
		 * String query3 = null; try { PreparedStatement statement =
		 * connection.prepareStatement(query); statement.setString(1,userId);
		 * statement.setString(2,passWord); ResultSet result = statement.executeQuery();
		 * if(result.next()==false) { throw new
		 * BusinessException("No User registered with that userId and passWord"); }
		 * 
		 * currentUser.setFatherName(result.getString("fatherName"));
		 * currentUser.setGender(result.getString("gender"));
		 * currentUser.setDateOfBirth(result.getString("dateOfBirth"));
		 * currentUser.setCollegeName(result.getString("collegeName"));
		 * currentUser.setExperience(result.getString("experience"));
		 * currentUser.setPrevSalary(result.getString("prevSalary"));
		 * currentUser.setSpecialization(result.getString("specialization"));
		 * currentUser.setDesignation(result.getString("designation"));
		 * currentUser.setContactNo(result.getString("contactNo"));
		 * currentUser.setEmail(result.getString("email"));
		 * currentUser.setAddress1(result.getString("address1"));
		 * currentUser.setAddress2(result.getString("address2"));
		 * currentUser.setCity(result.getString("city"));
		 * currentUser.setPostalCode(result.getString("postalCode"));
		 * currentUser.setEmployeeName(result.getString("empName"));
		 * 
		 * //////////Some Complex Work
		 * 
		 * if(result.getString("designation").equals("DepartmentHead")) { query3 =
		 * "select * from dep_head where userId = ?"; PreparedStatement st =
		 * connection.prepareStatement(query3); st.setString(1,userId); ResultSet res =
		 * st.executeQuery(); if(res.next()==false){
		 * 
		 * insertDb.setConnection(connection); insertDb.setTable("dep_head");
		 * RequestDispatcher rd = request.getRequestDispatcher("DepartmentPage.jsp");
		 * rd.forward(request,response);
		 * 
		 * }else { currentUser.setDepartment(res.getString("dept")); }
		 * 
		 * }else if(result.getString("designation").equals("Employee")) { query3 =
		 * "select * from employee where userId = ?"; PreparedStatement st =
		 * connection.prepareStatement(query3); st.setString(1,userId); ResultSet res =
		 * st.executeQuery(); if(res.next()==false){
		 * 
		 * insertDb.setConnection(connection); insertDb.setTable("employee");
		 * RequestDispatcher rd = request.getRequestDispatcher("DepartmentPage.jsp");
		 * rd.forward(request,response);
		 * 
		 * }else { currentUser.setDepartment(res.getString("dept")); } }
		 * 
		 * } catch (SQLException |IOException | ServletException e) { throw new
		 * BusinessException(e.getMessage()); }finally { try { connection.close();
		 * 
		 * } catch (SQLException e) { throw new BusinessException(e.getMessage()); } }
		 */
	}

	private void closeConnection(Transaction transaction, Session session, SessionFactory factory) {
		transaction.commit();
		session.close();
		factory.close();
	}
	/*
	 * public User loginUser(User user,User.InsertDb insertDb,HttpServletRequest
	 * request,HttpServletResponse response) throws BusinessException {
	 * 
	 * 
	 * }
	 */

}
