package replyBao;

import java.util.List;
import java.util.Map;

import exception.BusinessException;
import model.Reply_emp;
import replyDao.ReplyDaoImp;
import replyDao.ReplyDaoInt;

public class ReplyBaoImp implements ReplyBaoInt {

	@Override
	public void insertReply(String dpt, String msg) throws BusinessException {
		ReplyDaoInt reply = new ReplyDaoImp();
		reply.insertReply(dpt, msg);
	}

	@Override
	public List<Reply_emp> viewReply() throws BusinessException {
		ReplyDaoInt reply = new ReplyDaoImp();
		return reply.viewReply();
	}

	

}
