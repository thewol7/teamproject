package server.board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.board.dao.PriboardDao;
import server.board.dto.PriboardDto;
import server.controller.Action;
import server.controller.ActionForward;

public class BoardDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PriboardDto dto=new PriboardDto();
		int cont_id=Integer.parseInt(request.getParameter("cont_id"));
		dto.setCont_id(cont_id);
		dto.setUser_id((Integer)request.getSession().getAttribute("id"));
		PriboardDao.getInst().deletePriboard(dto);
		request.setAttribute("msg", cont_id+"번째 글이 삭제되었습니다.");
		return new ActionForward("/views/board/boardlist.do", true);
	}

}
