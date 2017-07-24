package server.controller;

import server.img.action.ImgBoardwriteAction;
import server.img.action.ImgBoardDeleteAction;
import server.img.action.ImgBoardDetail;
import server.img.action.ImgBoardUpdateAction;
import server.img.action.ImgBoardUpdateformAction;
import server.img.action.ImgboardListAction;
import server.img.action.ImgBoardwriteformAction;
import server.action.ToVisBoardlistPg;
import server.board.action.BoardDeleteAction;
import server.board.action.BoardDetailAction;
import server.board.action.BoardListAction;
import server.board.action.BoardUpdateAction;
import server.board.action.BoardUpdateformAction;
import server.board.action.BoardWriteAction;
import server.board.action.BoardWriteformAction;
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
		} else if (command.equals("/views/board/boardlist")) {
			action = new BoardListAction();
		} else if (command.equals("/views/picboard/imgboardlist")) {
			action = new ImgboardListAction();
		} else if (command.equals("/board/visboardlist")) {
			action = new ToVisBoardlistPg();
		} else if (command.equals("/views/board/boarddetail")) {
			action = new BoardDetailAction();
		} else if (command.equals("/views/board/boardwriteform")) {
			action = new BoardWriteformAction();
		} else if (command.equals("/views/board/boardwrite")){
			action = new BoardWriteAction();
		} else if (command.equals("/views/board/boardupdateform")) {
			action = new BoardUpdateformAction();
		} else if(command.equals("/views/board/boardupdate")){
			action = new BoardUpdateAction();
		} else if(command.equals("/views/board/boarddelete")){
			action = new BoardDeleteAction();
		} else if (command.equals("/views/picboard/imgboardwriteform")) {
			action = new ImgBoardwriteformAction();
		}  else if (command.equals("/views/picboard/imgboardwrite")){
			action = new ImgBoardwriteAction();
		} else if(command.equals("/views/picboard/imgboarddetail")){
			action = new ImgBoardDetail();
		} else if (command.equals("/views/picboard/imgboardupdateform")){
			action = new ImgBoardUpdateformAction();
		} else if (command.equals("/views/picboard/imgboardupdate")){
			action = new ImgBoardUpdateAction();
		} else if(command.equals("/views/picboard/imgboarddelete")){
			action = new ImgBoardDeleteAction(); 
		}
		return action;
	}
}
