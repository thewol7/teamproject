package server.main.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;
import server.main.dao.ServerMainDao;
import server.main.dto.ServerMainDto;

public class SignupAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pwd"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("gender"));
		System.out.println(request.getParameter("phone"));
		System.out.println(request.getParameter("email"));
		ServerMainDao dao=ServerMainDao.getInst();
		if(dao.idCheck(request.getParameter("id"))){
			return new ActionForward("/signupform.do");
		}else{
			ServerMainDto dto=new ServerMainDto();
			dto.setId(request.getParameter("id"));
			dto.setPwd(request.getParameter("pwd"));
			dto.setName(request.getParameter("name"));
			dto.setGender(request.getParameter("gender"));
			dto.setPhone(request.getParameter("phone"));
			dto.setEmail(request.getParameter("email"));
			dao.signup(dto);
			return new ActionForward("/home.do", true);
		}
	}

}
