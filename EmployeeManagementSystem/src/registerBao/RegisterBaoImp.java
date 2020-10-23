package registerBao;

import exception.BusinessException;
import model.User;
import registerDao.RegisterDaoImp;
import registerDao.RegisterDaoInt;

public class RegisterBaoImp implements RegisterBaoInt {

	@Override
	public void registerUser(User user) throws BusinessException {
		RegisterDaoInt register = new RegisterDaoImp();
		register.registerUser(user);
		
	}

	
}
