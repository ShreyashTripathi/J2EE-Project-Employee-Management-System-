package adminBao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import adminDao.AdminDaoImp;
import adminDao.AdminDaoInt;
import connection.GetConnection;
import exception.BusinessException;

public class AdminBaoImp implements AdminBaoInt {

	@Override
	public void sendMessage(String dept, String msg) throws BusinessException {
		AdminDaoInt send = new AdminDaoImp();
		send.sendMessage(dept, msg);
		
				
	}
	
	

}
