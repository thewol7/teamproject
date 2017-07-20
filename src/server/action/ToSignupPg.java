package server.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;

public class ToSignupPg extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String page_id = request.getParameter("page_id");
		request.setAttribute("page_id", page_id);
		
		return new ActionForward("/signupform.jsp?page_id="+page_id);
	}

}
