package dpBao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import dpDao.DpDaoImp;
import dpDao.DpDaoInt;
import exception.BusinessException;

public class DpBaoImp implements DpBaoInt {

	@Override
	public List showMsg(String dpt) throws BusinessException {
		 
        DpDaoInt show = new DpDaoImp();
        return show.showMsg(dpt);
	}

	@Override
	public void passMsg(String dpt,List<Object> ls) throws BusinessException {
		DpDaoInt show = new DpDaoImp();
		show.passMsg(dpt, ls);
		
	}

	@Override
	public List showMsgEmp(String dpt) throws BusinessException {
		DpDaoInt show = new DpDaoImp();
		return show.showMsgEmp(dpt);
		
	}

}
