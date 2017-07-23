package server.controller;

import server.action.DoImgBoardwriteAction;
import server.action.ToImgBoardDetailPg;
import server.action.ToImgBoardUpdatePg;
import server.action.ToImgBoardlistPg;
import server.action.ToImgBoardwritePg;
import server.action.ToVisBoardlistPg;
import server.board.action.BoardDeleteAction;
import server.board.action.BoardDetailAction;
import server.board.action.BoardListAction;
import server.board.action.BoardUpdateAction;
import server.board.action.BoardUpdateformAction;
import server.board.action.BoardWriteAction;
import server.board.action.BoardWriteformAction;
import server.board.action.CommentInsertAction;
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

	public static UserActionFactory getInstance() {
		if (factory == null) {
			factory = new UserActionFactory();
		}
		return factory;
	}

	public Action action(String command) {
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
		} else if (command.equals("/board/imgboardlist")) {
			action = new ToImgBoardlistPg();
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
		} else if (command.equals("/board/imgboardwriteform")) {
			action = new ToImgBoardwritePg();
		} else if (command.equals("/board/imgboardwrite")){
			action = new DoImgBoardwriteAction();
		} else if(command.equals("/board/imgboarddetail")){
			action = new ToImgBoardDetailPg();
		} else if (command.equals("/board/imgboardupdateform")){
			action = new ToImgBoardUpdatePg();
		} else if (command.equals("/views/board/boardcomment")) {
			action = new CommentInsertAction();
		} else if (command.equals("/views/board/imgboardcomment")) {
			action = new CommentInsertAction();
		}
		return action;
	}
}
