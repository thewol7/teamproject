package server.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.ServerDao;

@WebServlet("/board/imgload")
public class ImgServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("id")==null || request.getParameter("page_id")==null || request.getParameter("title")==null || request.getParameter("content")==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		String pic_url=(String)request.getParameter("pic_url");
		String title=(String)request.getParameter("title");
		String content=(String)request.getParameter("content");
		
		boolean insertPics=ServerDao.getInst().insertPics(request.getSession(), title, content, pic_url);
		
		if(insertPics==true){
			response.sendRedirect(request.getContextPath()+"/board/imgs.jsp?page_id="+(String)request.getParameter("page_id"));
		}else{
			response.sendRedirect(request.getContextPath()+"/board/imgload_form.jsp?page_id="+(String)request.getParameter("page_id"));
		}
	}
}
