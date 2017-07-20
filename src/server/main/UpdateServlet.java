package server.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.ServerDao;

@WebServlet("/board/update")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("id")==null || request.getParameter("page_id")==null || request.getParameter("title")==null || request.getParameter("content")==null || request.getParameter("cont_id") ==null ){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		int cont_id=(int)Integer.parseInt(request.getParameter("cont_id"));
		String content_title=(String)request.getParameter("title");
		String content_content=(String)request.getParameter("content");
	
		boolean updatePriboard=ServerDao.getInst().updatePriboard(request.getSession(),cont_id ,content_title, content_content);
		
		if(updatePriboard==true){
			response.sendRedirect(request.getContextPath()+"/board/boardlist.jsp?page_id="+(String)request.getParameter("page_id"));
		}else{
			response.sendRedirect(request.getContextPath()+"/board/boardlist.jsp?page_id="+(String)request.getParameter("page_id"));
		}
		
		
	}
}
