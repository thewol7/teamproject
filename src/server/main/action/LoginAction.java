package server.main.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.main.dao.ServerMainDao;
import server.main.dto.ServerMainDto;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServerMainDto dto=new ServerMainDto();
		dto.setId(request.getParameter("id"));
		dto.setPwd(request.getParameter("pwd"));
		int result=ServerMainDao.getInst().login(dto);
		if(result==0){
			request.setAttribute("msg", "아이디 혹은 비밀번호가 틀립니다.");
			request.setAttribute("url", "loginform.do");
			return new ActionForward("/views/users/alert.jsp");
		}else{
			request.getSession().setAttribute("id", result);
			return new ActionForward("/home.do?page_id="+result, true);
		}
		
		
	}

}
