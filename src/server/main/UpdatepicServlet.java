package server.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.ServerDao;

@WebServlet("/board/picupdate")
public class UpdatepicServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("id")==null || request.getParameter("page_id")==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}

		int cont_id=Integer.parseInt(request.getParameter("num"));
		String content_title=request.getParameter("title");
		String content_content=request.getParameter("content");
		//怨듬갚泥댄겕
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		if(content_title.equals("")){
			pw.println("<html>");
			pw.println("<script>");
			pw.println("alert('빈칸이 있습니다.');");
			pw.println("location.href='"+request.getContextPath()+"/board/picdetail.jsp?num="+cont_id+"&page_id="+(String)request.getParameter("page_id")+"';");
			pw.println("</script>");
			pw.println("</html>");
			return;
		}
		boolean updatePics=ServerDao.getInst().updatePics(content_title, content_content, request.getSession(), cont_id);
		
		
		if(updatePics==true){
			response.sendRedirect(request.getContextPath()+"/board/picdetail.jsp?num="+cont_id+"&page_id="+(String)request.getParameter("page_id"));
		}else{
			response.sendRedirect(request.getContextPath()+"/board/picdetail.jsp?num="+cont_id+"&page_id="+(String)request.getParameter("page_id"));
		}
		
	}
}
