package server.img.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.img.dao.ImgDao;

public class ImgBoardDeleteAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cont_id=Integer.parseInt(request.getParameter("cont_id"));
		ImgDao.getInst().deletePics(cont_id);
		request.setAttribute("msg", "삭제되었습니다.");
		return new ActionForward("/views/picboard/delalert.jsp");
	}
}
