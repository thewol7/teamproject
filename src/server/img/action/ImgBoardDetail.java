package server.img.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.comment.dao.CommentDao;
import server.comment.dto.CommentDto;
import server.controller.Action;
import server.controller.ActionForward;
import server.img.dao.ImgDao;
import server.img.dto.ImgDto;

public class ImgBoardDetail extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		int cont_id=Integer.parseInt(request.getParameter("cont_id"));
		request.setAttribute("cont_id", cont_id);
		ImgDto dto=ImgDao.getInst().getPicdetail(cont_id);
		ImgDao.getInst().increaseViewCount(cont_id);
		request.setAttribute("view_count", dto.getView_count()); 	//view_count's set
		request.setAttribute("dto", dto);
		
		// comment ----------------------------------------------------------------
		// 글의 cont_id 번호를 이용해서 commentlist 얻기
		List<CommentDto> commentList=CommentDao.getInstance().picGetList(cont_id);
		request.setAttribute("commentList", commentList);
		// comment ----------------------------------------------------------------
				
		return new ActionForward("/views/picboard/imgboarddetail.jsp");
	}

}
