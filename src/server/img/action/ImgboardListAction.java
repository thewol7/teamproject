package server.img.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.img.dao.ImgDao;
import server.img.dto.ImgDto;

public class ImgboardListAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ImgDto> data=ImgDao.getInst().getList();
		request.setAttribute("data", data);
		
		return new ActionForward("/views/picboard/imgboardlist.jsp");
	}

}
