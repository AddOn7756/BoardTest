package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.client.ClientVO;
import model.message.MessageDAO;
import model.message.MessageVO;

public class EditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ActionForward forward= new ActionForward();
		
		MessageDAO mDAO=new MessageDAO();
		MessageVO mVO=new MessageVO();
		mVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		
		mVO = mDAO.getDBData(mVO);
		
		request.setAttribute("mdata", mVO);
				
		forward.setRedirect(false);
		forward.setPath("edit.jsp");
		return forward;
	}

}
