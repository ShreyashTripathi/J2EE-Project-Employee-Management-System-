package loginBao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BusinessException;
import loginDao.LoginDaoImp;
import loginDao.LoginDaoInt;
import model.MyTable;
import model.User;

public class LoginBaoImp implements LoginBaoInt {
	@Override
	public void loginUser(User user,HttpServletRequest request,HttpServletResponse response,MyTable myTable) throws BusinessException {
		LoginDaoInt login = new LoginDaoImp();
		login.loginUser(user,request,response,myTable);
		
	}
}
