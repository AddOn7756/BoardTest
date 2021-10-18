package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.client.ClientDAO;
import model.client.ClientVO;


public class ClientInsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = new ActionForward();
		
		ClientDAO cDAO=new ClientDAO();
		ClientVO cVO= new ClientVO();
		
		cVO.setUserid(request.getParameter("userid"));
		cVO.setPw(request.getParameter("pw"));
		cVO.setName(request.getParameter("name"));
		
		if(cDAO.checkID(cVO)==false) { 
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out=response.getWriter();
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}
		else {
			cDAO.insert(cVO);
		}
		
		forward.setRedirect(true);
		forward.setPath("main.do"); 
		return forward;
	}

}
