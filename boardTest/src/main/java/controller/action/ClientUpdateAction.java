package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.client.ClientDAO;
import model.client.ClientVO;

public class ClientUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ClientDAO cDAO=new ClientDAO();
		ClientVO cVO= new ClientVO();
		
		cVO.setUserid(request.getParameter("userid"));
		cVO.setPw(request.getParameter("pw"));
		cVO.setName(request.getParameter("name"));
		
		if(!cDAO.update(cVO)) { 
			throw new IOException("회원정보 수정 오류 발생");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", cVO);
		}
		
		forward.setRedirect(true);
		forward.setPath("list.do"); 
		return forward;
	}

}
