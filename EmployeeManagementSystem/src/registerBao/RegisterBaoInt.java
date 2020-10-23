package registerBao;

import exception.BusinessException;
import model.User;

public interface RegisterBaoInt {
	public void registerUser(User user) throws BusinessException;
}
