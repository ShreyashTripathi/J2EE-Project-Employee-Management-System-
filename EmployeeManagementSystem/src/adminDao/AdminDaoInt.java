package adminDao;

import exception.BusinessException;

public interface AdminDaoInt {
	   public void sendMessage(String dept,String msg) throws BusinessException;

}
