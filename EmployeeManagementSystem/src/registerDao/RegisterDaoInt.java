package registerDao;

import exception.BusinessException;
import model.User;

public interface RegisterDaoInt {
   public void registerUser(User user) throws BusinessException;
}
