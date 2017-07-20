package server.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.controller.Action;
import server.controller.ActionForward;

public class ToImgBoardUpdatePg extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cont_id=Integer.parseInt(request.getParameter("cont_id"));
		int page_id=Integer.parseInt(request.getParameter("page_id"));
		
		System.out.println("action page_id:"+page_id);
		System.out.println("action con_id:"+cont_id);
		
		request.setAttribute("page_id", page_id);
		request.setAttribute("cont_id", cont_id);
		
		return new ActionForward("/board/imgboardupdateform.jsp?page_id="+page_id);
	}

}
