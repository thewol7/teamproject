package server.main.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.main.dao.ServerMainDao;

public class RandomAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return new ActionForward("/views/home.jsp?page_id="+ServerMainDao.getInst().getRandomPage().getUser_id(), true);
	}

}
