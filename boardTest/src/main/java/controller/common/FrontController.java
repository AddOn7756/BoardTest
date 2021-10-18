package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.ClientDeleteAction;
import controller.action.ClientInsertAction;
import controller.action.ClientUpdateAction;
import controller.action.EditAction;
import controller.action.ListAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MessageDeleteAction;
import controller.action.MessageInsertAction;
import controller.action.MessageUpdateAction;
import controller.action.MainAction;

/**
 * Servlet implementation class DispatcherServlet
 */

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri= request.getRequestURI();
		String cp=request.getContextPath();
		String action = uri.substring(cp.length());

		ActionForward forward=null;

		if(action.equals("/main.do")) {
			System.out.println("메인확인");
			forward=new MainAction().execute(request, response);
		} 
		else if(action.equals("/login.do")) {
			forward=new LoginAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) {
			forward=new LogoutAction().execute(request, response);
		}
		else if(action.equals("/list.do")) {
			forward=new ListAction().execute(request, response); 
		}
		else if(action.equals("/edit.do")) {
			forward=new EditAction().execute(request, response); 
		}
		else if(action.equals("/minsert.do")) { 
			forward=new MessageInsertAction().execute(request, response); 
		}
		else if(action.equals("/mdelete.do")) { 
			forward=new MessageDeleteAction().execute(request, response);
		}
		else if(action.equals("/mupdate.do")) { 
			forward=new MessageUpdateAction().execute(request, response);
		}
		else if(action.equals("/signup.do")) { 
			forward=new ClientInsertAction().execute(request, response);
		}
		else if(action.equals("/cdelete.do")) {
			forward=new ClientDeleteAction().execute(request, response);
		}
		else if(action.equals("/cupdate.do")) { 
			forward=new ClientUpdateAction().execute(request, response);
		}
		else {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
		/*if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());*/
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
		/*	}
		}*/
	}
}
