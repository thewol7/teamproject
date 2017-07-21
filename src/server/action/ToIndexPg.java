package server.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;

public class ToIndexPg extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String page_id = request.getParameter("page_id");
		request.setAttribute("page_id", page_id);
		return new ActionForward("/index.jsp");
	}

}
