package dpBao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import exception.BusinessException;

public interface DpBaoInt {
   public List showMsg(String dpt) throws BusinessException;
   public void passMsg(String dpt,List<Object> ls) throws BusinessException;
   public List showMsgEmp(String dpt) throws BusinessException;

}
