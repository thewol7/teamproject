package server.img.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.img.dao.ImgDao;
import server.img.dto.ImgDto;

public class ImgBoardUpdateformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cont_id=Integer.parseInt(request.getParameter("cont_id"));
		request.setAttribute("cont_id", cont_id);
		ImgDto dto=ImgDao.getInst().getPicdetail(cont_id);
		request.setAttribute("dto", dto);
		return new ActionForward("/views/picboard/imgboardupdateform.jsp");
	}

}
