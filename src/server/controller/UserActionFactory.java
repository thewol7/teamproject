package server.controller;

import server.action.DoBoardwriteAction;
import server.action.DoImgBoardwriteAction;
import server.action.DoLoginAction;
import server.action.DoLogoutAction;
import server.action.ToBoardDetailPg;
import server.action.ToBoardUpdatePg;
import server.action.ToBoardlistPg;
import server.action.ToBoardwritePg;
import server.action.ToImgBoardDetailPg;
import server.action.ToImgBoardUpdatePg;
import server.action.ToImgBoardlistPg;
import server.action.ToImgBoardwritePg;
import server.action.ToIndexPg;
import server.action.ToLoginPg;
import server.action.ToSignupPg;
import server.action.ToVisBoardlistPg;
import server.guestboard.action.GuestBoardInsertAction;
import server.guestboard.action.GuestBoardListAction;
import server.main.action.HomeAction;
import server.main.action.LoginAction;
import server.main.action.LoginformAction;
import server.main.action.LogoutAction;
import server.main.action.SignupAction;
import server.main.action.SignupformAction;

public class UserActionFactory {
	private static UserActionFactory factory;

	private UserActionFactory() {
	}

	// 자신의 참조값을 리턴해주는 메소드
	public static UserActionFactory getInstance() {
		if (factory == null) {
			factory = new UserActionFactory();
		}
		return factory;
	}

	// 인자로 전달되는 command 를 수행할 Action type 객체를 리턴해주는
	// 메소드
	/*
	 * else if (command.equals("/board/boardlist")) { action = new
	 * ToBoardlistPgAction(); }
	 */
	public Action action(String command) {
		// Action 추상클래스 type 을 담을 지역변수 만들기
		Action action = null;
		if (command.equals("/home")) {
			action = new HomeAction();
		} else if (command.equals("/signupform")) {
			action = new SignupformAction();
		} else if (command.equals("/loginform")) {
			action = new LoginformAction();
		} else if (command.equals("/signup")) {
			action = new SignupAction();
		} else if (command.equals("/login")) {
			action = new LoginAction();
		} else if (command.equals("/logout")){
			action = new LogoutAction();
		} else if (command.equals("/board/boardlist")) {
			action = new ToBoardlistPg();
		} else if (command.equals("/board/imgboardlist")) {
			action = new ToImgBoardlistPg();
		} else if (command.equals("/board/visboardlist")) {
			action = new ToVisBoardlistPg();
		} else if (command.equals("/board/boarddetail")) {
			action = new ToBoardDetailPg();
		} else if (command.equals("/board/boardwrite")) {
			action = new DoBoardwriteAction();
		} else if (command.equals("/board/boardwriteform")) {
			action = new ToBoardwritePg();
		} else if (command.equals("/board/boardupdateform")) {
			action = new ToBoardUpdatePg();
		} else if (command.equals("/board/imgboardwriteform")) {
			action = new ToImgBoardwritePg();
		}  else if (command.equals("/board/imgboardwrite")){
			action = new DoImgBoardwriteAction();
		} else if(command.equals("/board/imgboarddetail")){
			action = new ToImgBoardDetailPg();
		} else if (command.equals("/board/imgboardupdateform")){
			action = new ToImgBoardUpdatePg();
		} else if(command.equals("/guestboard/list")){
			action = new GuestBoardListAction();
		}else if(command.equals("/guestboard/insert")){
			action = new GuestBoardInsertAction();
		}
		return action;
	}
}
