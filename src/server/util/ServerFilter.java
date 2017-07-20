package server.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.ServerDao;


public class ServerFilter implements Filter{
	private String myEncoding;
	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		String[] tmp=request.getRequestURI().split("/");
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 게시판 기본으로 진입 가능하게 하여 글은 읽을수 있도록 함
		/*if(tmp.length>2){
		if(request.getSession().getAttribute("id")==null && tmp[2].equals("board")){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		}
		}*/
		
		if(request.getParameter("page_id")==null && request.getSession().getAttribute("id")!=null && !tmp[tmp.length-1].equals("login.jsp") && !tmp[tmp.length-1].equals("signup.jsp") && !tmp[tmp.length-1].equals("signup")){
			response.sendRedirect(request.getRequestURL()+"?page_id="+request.getSession().getAttribute("id"));
			return;
		}
		
		if(request.getParameter("page_id")==null && !tmp[tmp.length-1].equals("login.jsp") && !tmp[tmp.length-1].equals("signup.jsp") && !tmp[tmp.length-1].equals("signup")){
			response.sendRedirect(request.getRequestURL()+"?page_id="+ServerDao.getInst().getRandomPage());
			return;
		}
		
		if(req.getCharacterEncoding()==null){
			req.setCharacterEncoding(myEncoding);
			res.setCharacterEncoding(myEncoding);
		}
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init()");
		myEncoding=config.getInitParameter("myEncoding");
	}
}







