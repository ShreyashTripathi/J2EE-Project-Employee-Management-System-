package loginBao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BusinessException;
import model.MyTable;
import model.User;

public interface LoginBaoInt {
	public void loginUser(User user,HttpServletRequest request,HttpServletResponse response,MyTable myTable) throws BusinessException;
}
