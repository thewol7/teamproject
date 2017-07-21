package server.img.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.dao.ServerDao;

public class PicboardListAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String page_id = request.getParameter("page_id");
		
		int pageNum = 0;
		if (request.getParameter("pageNum") == null) {
			pageNum = 1;
		} else {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
	
		String page_name = ServerDao.getInst().getPageOwner(Integer.parseInt(request.getParameter("page_id")));
		double count = ServerDao.getInst().getMaxpage2(Integer.parseInt(page_id));
	
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("page_name", page_name);
		request.setAttribute("count", count);
		
		return new ActionForward("/board/imgboardlist.jsp");
	}

}
