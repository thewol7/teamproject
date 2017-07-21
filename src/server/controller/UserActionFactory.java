package server.controller;

import server.action.DoImgBoardwriteAction;
import server.action.ToBoardDetailPg;
import server.action.ToBoardUpdatePg;
import server.action.ToBoardwritePg;
import server.action.ToImgBoardDetailPg;
import server.action.ToImgBoardUpdatePg;
import server.action.ToImgBoardlistPg;
import server.action.ToImgBoardwritePg;
import server.action.ToVisBoardlistPg;
import server.board.action.BoardListAction;
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

	// �옄�떊�쓽 李몄“媛믪쓣 由ы꽩�빐二쇰뒗 硫붿냼�뱶
	public static UserActionFactory getInstance() {
		if (factory == null) {
			factory = new UserActionFactory();
		}
		return factory;
	}

	// �씤�옄濡� �쟾�떖�릺�뒗 command 瑜� �닔�뻾�븷 Action type 媛앹껜瑜� 由ы꽩�빐二쇰뒗
	// 硫붿냼�뱶
	/*
	 * else if (command.equals("/board/boardlist")) { action = new
	 * ToBoardlistPgAction(); }
	 */
	public Action action(String command) {
		// Action 異붿긽�겢�옒�뒪 type �쓣 �떞�쓣 吏��뿭蹂��닔 留뚮뱾湲�
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
			action = new BoardListAction();
		} else if (command.equals("/board/imgboardlist")) {
			action = new ToImgBoardlistPg();
		} else if (command.equals("/board/visboardlist")) {
			action = new ToVisBoardlistPg();
		} else if (command.equals("/board/boarddetail")) {
			action = new ToBoardDetailPg();
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
		}
		return action;
	}
}
