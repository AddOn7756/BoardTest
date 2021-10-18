package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.client.ClientVO;
import model.message.MessageDAO;
import model.message.MessageVO;

public class ListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ActionForward forward= new ActionForward();
		
		MessageDAO mDAO=new MessageDAO();
		
		String isMine = request.getParameter("isMine");
		ArrayList<MessageVO> datas=new ArrayList<MessageVO>();
		
		if(isMine == null) {
			datas = mDAO.getDBList(null);
			System.out.println("mdatas null :" + datas);
		}
		else {
			datas = mDAO.getDBList((ClientVO)session.getAttribute("seUser"));
			System.out.println("mdatas true :" + datas);
		}
		
		request.setAttribute("mdatas", datas);
				
		forward.setRedirect(false);
		forward.setPath("list.jsp");
		return forward;
	}

}
