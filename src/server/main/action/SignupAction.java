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
		ServerMainDao dao=ServerMainDao.getInst();
		
		/*프로필 이미지*/
		String photo_value = request.getParameter("photo_value");
		System.out.println("value:"+photo_value);
		String profile_image = null;
		if(photo_value.equals("")){
			/*프로필 이미지 변경하지 않았을 경우 프로젝트 내에 있는 default 이미지로*/
			profile_image = "https://ucarecdn.com/43f25772-8c37-44a6-9368-4c1b6867d8fb/default.png";
			System.out.println("profile_dafault: "+profile_image);
		}else{
			profile_image = photo_value;
			System.out.println("profile_image: "+profile_image);
		}
		
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
			dto.setProfile_img(profile_image);
			dto.setProfile_cmt(request.getParameter("profile_cmt"));
			dao.signup(dto);
			return new ActionForward("/home.do", true);
		}
	}

}
