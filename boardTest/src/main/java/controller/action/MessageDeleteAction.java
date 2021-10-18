package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message.MessageDAO;
import model.message.MessageVO;

public class MessageDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		MessageDAO mDAO=new MessageDAO();
		MessageVO mVO=new MessageVO();
		
		mVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		
		System.out.println("�Խñ� ����");
		if(!mDAO.m_delete(mVO)) { 
			throw new IOException("�� �������� �߻�");
		}
		
		forward.setRedirect(true);
		forward.setPath("list.do");
		return forward;
	}

}
