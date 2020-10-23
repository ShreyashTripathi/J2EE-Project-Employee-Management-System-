package adminBao;

import exception.BusinessException;

public interface AdminBaoInt {
   public void sendMessage(String dept,String msg) throws BusinessException;
}
