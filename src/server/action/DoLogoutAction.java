package server.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;

public class DoLogoutAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String page_id = request.getParameter("page_id");
		request.setAttribute("page_id", page_id);
		//로그 아웃 처리하는 비즈니스 로직 수행 
		request.getSession().invalidate();
		
		//redirect 이동할수 있도록 ActionForward 객체 생성 
		ActionForward af=new ActionForward("/logout.jsp?page_id="+page_id);
		return af;
	}
	
}












