package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.client.ClientVO;
import model.message.MessageDAO;
import model.message.MessageVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ActionForward forward= new ActionForward();
		
		MessageDAO mDAO=new MessageDAO();
		ClientVO cVO = null;
		
		ArrayList<MessageVO> datas=new ArrayList<MessageVO>();
	
		datas = mDAO.getDBList(cVO);
		
		System.out.println("메인 액션 통과");
			
		request.setAttribute("mdatas", datas);
				
		forward.setRedirect(true);
		forward.setPath("main.jsp");
		System.out.println("메인통과직전");
		return forward;
	}

}
