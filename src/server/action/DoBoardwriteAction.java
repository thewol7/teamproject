package server.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.dao.ServerDao;

public class DoBoardwriteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 글쓰기 저장 동작
		String page_id = request.getParameter("page_id");
		request.setAttribute("page_id", page_id);
		
		String content_title=(String)request.getParameter("title");
		String content_content=(String)request.getParameter("ckValue");
		
		System.out.println("page_id: "+page_id);
		System.out.println("title: "+content_title);
		System.out.println("content: "+content_content);
		
		boolean writePriboard=ServerDao.getInst().writePriboard(request.getSession(), content_title, content_content);
						
		if(writePriboard==true){
			System.out.println("입력 정상");
			return new ActionForward("/board/boardlist.do?page_id="+page_id);
			/*response.sendRedirect(request.getContextPath()+"/board/boardlist.jsp?page_id="+(String)request.getParameter("page_id"));*/
		}else{
			System.out.println("입력 실패");
			return new ActionForward("/board/boardlist.do?page_id="+page_id);
			/*response.sendRedirect(request.getContextPath()+"/board/boardlist.jsp?page_id="+(String)request.getParameter("page_id"));*/
		}
		/*return new ActionForward("/board/boardlist.jsp?page_id="+page_id);*/
	}
}
