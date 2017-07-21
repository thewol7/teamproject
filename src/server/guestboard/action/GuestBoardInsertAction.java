package server.guestboard.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.guestboard.dao.GuestBoardDao;
import server.guestboard.dto.GuestBoardDto;

public class GuestBoardInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String content = (String)request.getParameter("content");
		
		int writer_id = (Integer)request.getSession().getAttribute("id");
		System.out.println(writer_id);
		int user_id = Integer.parseInt(request.getParameter("page_id"));
		System.out.println(user_id);
		GuestBoardDto dto = new GuestBoardDto();
		//dto.setContent(content);
		if(content ==null){
			dto.setContent("널이 담겼음");
		}
		System.out.println(dto.getContent());
		dto.setUser_id(user_id);
		dto.setWriter_id(writer_id);
		GuestBoardDao.getInstance().insert(dto);
		return new ActionForward("/guestboard/list.do",true);
	}

}
