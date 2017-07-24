package server.img.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.img.dao.ImgDao;
import server.img.dto.ImgDto;

public class ImgBoardUpdateAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cont_id=Integer.parseInt(request.getParameter("cont_id"));
		String content_title=request.getParameter("title");
		String content_content=request.getParameter("ckContent");
		ImgDto dto=new ImgDto();
		dto.setContent_title(content_title);
		dto.setContent_content(content_content);
		dto.setCont_id(cont_id);
		ImgDao.getInst().updatePics(dto);
		request.setAttribute("msg", "수정 성공했습니다.");
		request.setAttribute("cont_id", cont_id);
		return new ActionForward("/views/picboard/alert.jsp");
	}
}
