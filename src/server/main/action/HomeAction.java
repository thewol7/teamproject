package server.main.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;

public class HomeAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*ServerMainDto mainDto=ServerMainDao.getInst().getInfo((Integer)request.getSession().getAttribute("id"));
		request.setAttribute("session", mainDto);*/
		
		return new ActionForward("/views/home.jsp");
	}

}
