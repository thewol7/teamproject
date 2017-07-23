package server.guestboard.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import server.controller.Action;
import server.controller.ActionForward;
import server.dao.ServerDao;
import server.guestboard.dao.GuestBoardDao;
import server.guestboard.dto.GuestBoardDto;

public class GuestBoardListAction extends Action{
	private static final int PAGE_ROW_COUNT=5;
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
		int totalRow = (int)ServerDao.getInst().getMaxpage((Integer)request.getSession().getAttribute("page_id"));
		int totalPageCount=(int)Math.ceil((double)totalRow/(double)PAGE_ROW_COUNT);
		int startPageNum=
				1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount;
		}
		
		
		//페이지 아이디를 받아서
		int page_id = (Integer)request.getSession().getAttribute("page_id");	
		//list 를 가져옴
		GuestBoardDto dto=new GuestBoardDto();
		dto.setUser_id(page_id);
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		List<GuestBoardDto> list = GuestBoardDao.getInstance().getList(dto);				
		/*if(list != null){
			System.out.println(list);
		}*/
		//페이지주인의 이름을 가져옴
		GuestBoardDto usernamedto = GuestBoardDao.getInstance().getUserName(page_id);
		
		//그 페이지에 작성된 방명록리스트를 가져와서 request에 담음
		request.setAttribute("list", list);
		
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		
		// 그페이지주인의 이름을 가져와서 request에 담음
		request.setAttribute("usernamedto", usernamedto);
		
		//로그인을 안한상태로(session id 가 null) 일때 처리		
		GuestBoardDto writernamedto=null;
		if(request.getSession().getAttribute("id")==null){
			writernamedto=null;
		}else{//작성자의 이름을 가져와서 request 에 담음
			writernamedto = GuestBoardDao.getInstance().getWriterName((Integer)request.getSession().getAttribute("id"));
		}
		//로그인안한상태로 접근시 getWriterName(null) 이 되어 널포인트익셉션
		//GuestBoardDto writernamedto=GuestBoardDao.getInstance().getWriterName((Integer)request.getSession().getAttribute("id"));
		request.setAttribute("writernamedto", writernamedto);
		return new ActionForward("/views/guestboard/list.jsp");
	}

}
