package server.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.board.dao.PriboardDao;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("id")==null || request.getParameter("page_id")==null || request.getParameter("title")==null || request.getParameter("content")==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		String content_title=(String)request.getParameter("title");
		String content_content=(String)request.getParameter("content");
	
		boolean writePriboard=PriboardDao.getInst().writePriboard(request.getSession(), content_title, content_content);
		
		if(writePriboard==true){
			//성공처리
			System.out.println("성공");
			response.sendRedirect(request.getContextPath()+"/board/boardlist.jsp?page_id="+(String)request.getParameter("page_id"));
		}else{
			//실패처리
			System.out.println("실패함 ㅋ");
			response.sendRedirect(request.getContextPath()+"/board/boardlist.jsp?page_id="+(String)request.getParameter("page_id"));
		}
		
		
	}
}
