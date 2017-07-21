package server.guestboard.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.guestboard.dao.GuestBoardDao;
import server.guestboard.dto.GuestBoardDto;

public class GuestBoardListAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//페이지 아이디를 받아서
		int page_id = Integer.parseInt(request.getParameter("page_id"));
		//그 페이지에 작성된 방명록리스트를 가져와서 request에 담음

		List<GuestBoardDto> list = GuestBoardDao.getInstance().getList(page_id);		
		request.setAttribute("list", list);
		// 그페이지주인의 이름을 가져와서 request에 담음
		GuestBoardDto usernamedto = GuestBoardDao.getInstance().getUserName(page_id);
		request.setAttribute("usernamedto", usernamedto);
		//작성자의 이름을 가져와서 request 에 담음
		GuestBoardDto writernamedto = GuestBoardDao.getInstance().getWriterName((Integer)request.getSession().getAttribute("id"));
		request.setAttribute("writernamedto", writernamedto);
		return new ActionForward("/views/guestboard/list.jsp");
	}

}
