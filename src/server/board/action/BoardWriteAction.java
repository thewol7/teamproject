package server.board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.board.dao.PriboardDao;
import server.board.dto.PriboardDto;
import server.controller.Action;
import server.controller.ActionForward;

public class BoardWriteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String content_content=request.getParameter("ckContent");
		String content_title=request.getParameter("title");
		PriboardDto dto=new PriboardDto();
		dto.setUser_id((Integer)request.getSession().getAttribute("id"));
		dto.setContent_title(content_title);
		dto.setContent_content(content_content);
		PriboardDao.getInst().writePriboard(dto);
		request.setAttribute("msg", "글을 작성하였습니다.");
		return new ActionForward("/views/board/boardlist.do", true);
	}

}
