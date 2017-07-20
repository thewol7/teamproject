package server.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.ServerDao;

@WebServlet("/signup")
public class signup extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null || request.getParameter("pwd")==null || request.getParameter("name")==null || request.getParameter("gender")==null || request.getParameter("phone")==null || request.getParameter("email")==null){
			System.out.println("�ΰ��� ����");
			response.sendRedirect("signup.jsp");
			return;
		}
		boolean createAccount=ServerDao.getInst().createAccount(request.getParameter("id"), request.getParameter("pwd"), request.getParameter("name"), request.getParameter("gender"), request.getParameter("phone"), request.getParameter("email"));
		
		if(createAccount==true){
			System.out.println("���� ����");
			response.sendRedirect("login.jsp");
			return;
		}else{
			System.out.println("���� ����");
			response.sendRedirect("signup.jsp");
			return;
		}
	}
}
