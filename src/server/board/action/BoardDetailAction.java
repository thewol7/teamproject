package server.board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.board.dao.PriboardDao;
import server.board.dto.PriboardDto;
import server.controller.Action;
import server.controller.ActionForward;

public class BoardDetailAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PriboardDto dto=new PriboardDto();
		dto.setCont_id(Integer.parseInt(request.getParameter("cont_id")));
		dto.setUser_id((Integer)request.getSession().getAttribute("page_id"));
		PriboardDto result=PriboardDao.getInst().getPridetail(dto);
		PriboardDao.getInst().updateviewcount(Integer.parseInt(request.getParameter("cont_id")));
		request.setAttribute("result", result);
		return new ActionForward("/views/board/boarddetail.jsp");
	}

}
