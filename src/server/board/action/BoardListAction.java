package server.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.board.dao.PriboardDao;
import server.board.dto.PriboardDto;
import server.controller.Action;
import server.controller.ActionForward;

public class BoardListAction extends Action{
	private static final int PAGE_ROW_COUNT=15;
	private static final int PAGE_DISPLAY_COUNT=5;
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int pageNum=1;
		String strPageNum=request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		int totalRow = (int)PriboardDao.getInst().getMaxpage((Integer)request.getSession().getAttribute("page_id"));
		int totalPageCount=(int)Math.ceil((double)totalRow/(double)PAGE_ROW_COUNT);
		int startPageNum=
				1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount;
		}
		PriboardDto dto=new PriboardDto();
		
		dto.setUser_id((Integer)request.getSession().getAttribute("page_id"));
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		List<PriboardDto> data = PriboardDao.getInst().getPriboard(dto);
		request.setAttribute("data", data);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		return new ActionForward("/views/board/boardlist.jsp");
	}

}
