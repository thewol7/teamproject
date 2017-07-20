package server.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.ServerDao;

@WebServlet("/board/picdelete")
public class DeletepicServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("id")==null || request.getParameter("page_id")==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		
		int cont_id=Integer.parseInt(request.getParameter("num"));
		
		boolean deletePics=ServerDao.getInst().deletePics(request.getSession(), cont_id);
		
		if(deletePics==true){
			response.sendRedirect(request.getContextPath()+"/board/picdelete.jsp?page_id="+(String)request.getParameter("page_id"));
		}else{
			response.sendRedirect(request.getContextPath()+"/board/imgs.jsp?page_id="+(String)request.getParameter("page_id"));
		}
	}
}
