package server.main.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;

public class ManagementAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return new ActionForward("/views/users/private/management.jsp");
	}

}
