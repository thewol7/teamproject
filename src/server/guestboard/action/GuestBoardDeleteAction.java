package server.guestboard.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.guestboard.dao.GuestBoardDao;

public class GuestBoardDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//대상의 글번호를 받아서
		int cont_id= Integer.parseInt(request.getParameter("cont_id"));
		//db에서 삭제
		GuestBoardDao.getInstance().delete(cont_id);
		
		request.setAttribute("msg", "해당 글을 삭제하였습니다.");
		request.setAttribute("url", request.getContextPath()+"/guestboard/list.do");
		return new ActionForward("/views/users/alert.jsp");
	}

}
