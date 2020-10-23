package replyDao;

import java.util.List;
import java.util.Map;

import exception.BusinessException;
import model.Reply_emp;

public interface ReplyDaoInt {
	public void insertReply(String dpt,String msg) throws BusinessException;
	public List<Reply_emp> viewReply() throws BusinessException;
}
