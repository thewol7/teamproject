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

import server.main.dao.ServerMainDao;
import server.main.dto.ServerMainDto;


public class ServerFilter implements Filter{
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
		
		if(request.getParameter("page_id")!=null){
			request.getSession().setAttribute("page_id", Integer.parseInt(request.getParameter("page_id")));
		}
		
		if(request.getSession().getAttribute("page_id")!=null){
			request.setAttribute("page_id", request.getSession().getAttribute("page_id"));
		}
		
		if(request.getSession().getAttribute("page_id")==null && request.getSession().getAttribute("id")!=null && !tmp[tmp.length-1].equals("loginform.do") && !tmp[tmp.length-1].equals("login.do") && !tmp[tmp.length-1].equals("signupform.do") && !tmp[tmp.length-1].equals("signup.do")){
			request.getSession().setAttribute("page_id", request.getSession().getAttribute("id"));
			response.sendRedirect(request.getContextPath()+"/home.do");
			return;
		}
		
		if(request.getSession().getAttribute("page_id")==null && !tmp[tmp.length-1].equals("loginform.do") && !tmp[tmp.length-1].equals("login.do") && !tmp[tmp.length-1].equals("signup.do") && !tmp[tmp.length-1].equals("signup.do")){
			request.getSession().setAttribute("page_id", ServerMainDao.getInst().getRandomPage().getUser_id());
			response.sendRedirect(request.getContextPath()+"/home.do");
			return;
		}
		ServerMainDto dto=ServerMainDao.getInst().getInfo((Integer)request.getSession().getAttribute("page_id"));
		request.setAttribute("info", dto);
		
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
}







