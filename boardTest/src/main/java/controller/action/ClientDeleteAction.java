package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.client.ClientDAO;
import model.client.ClientVO;

public class ClientDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ClientDAO cDAO=new ClientDAO();
		ClientVO cVO= new ClientVO();
		
		cVO.setUserid(request.getParameter("userid"));
		
		if(!cDAO.delete(cVO)) { 
			throw new IOException("È¸¿ø Å»Åð¿¡¼­ ¹ß»ý");
		}
		HttpSession session=request.getSession();
		session.invalidate();
		
		forward.setRedirect(true);
		forward.setPath("main.do"); 
		return forward;
	}

}
