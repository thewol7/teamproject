package server.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.dao.ServerDao;

public class DoLoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String page_id = (String)request.getParameter("page_id");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		if (id != null && pwd != null) {
			int loginAc = ServerDao.getInst().loginAction(id, pwd);

			if (loginAc > 0) {
				request.getSession().setAttribute("id", loginAc);
				return new ActionForward("login.jsp?page_id=" + request.getSession().getAttribute("id"));
			} else {
				return new ActionForward("login.jsp?page_id=" + page_id);
			}
		}
		return null;
	}

}
