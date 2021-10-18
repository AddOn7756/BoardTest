package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message.MessageDAO;
import model.message.MessageVO;

public class MessageInsertAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();

		MessageDAO mDAO=new MessageDAO();
		MessageVO mVO=new MessageVO();
		
		mVO.setTitle(request.getParameter("title"));
		mVO.setContent(request.getParameter("content"));
		mVO.setUserid(request.getParameter("userid"));
		
		if(!mDAO.m_insert(mVO)) {
			throw new IOException("글등록에서 발생");
		}
		
		forward.setRedirect(true);
		forward.setPath("list.do");
		return forward;
	}

}
