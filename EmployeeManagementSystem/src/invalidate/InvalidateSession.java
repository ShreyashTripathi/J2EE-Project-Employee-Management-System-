package invalidate;

import javax.servlet.http.HttpSession;

import exception.BusinessException;

public class InvalidateSession {
      public static void invalidateSession(HttpSession session) throws BusinessException {
    	  session.invalidate();
      }
}
