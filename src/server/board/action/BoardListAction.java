package server.board.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.board.dao.PriboardDao;
import server.board.dto.PriboardDto;
import server.controller.Action;
import server.controller.ActionForward;
import server.dao.ServerDao;

public class BoardListAction extends Action{
	private static final int PAGE_ROW_COUNT=15;
	private static final int PAGE_DISPLAY_COUNT=5;
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String page_id=request.getParameter("page_id");
		//보여줄 페이지의 번호
		int pageNum=1;
		//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
		String strPageNum=request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		int totalRow = (int)ServerDao.getInst().getMaxpage((Integer)request.getSession().getAttribute("page_id"));
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		int startPageNum=
				1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount;
		}
		List<PriboardDto> data = PriboardDao.getInst()
				.getPriboard((Integer)request.getSession().getAttribute("page_id"), startRowNum, endRowNum);
		String name=PriboardDao.getInst().getPageOwner((Integer)request.getSession().getAttribute("page_id"));
		request.setAttribute("data", data);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("name", name);
		return new ActionForward("/board/boardlist.jsp");
	}

}
