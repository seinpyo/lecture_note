package com.board.controller;

import com.board.controller.action.Action;
import com.board.controller.action.BoardViewAction;
import com.board.controller.action.BoardWriteAction;
import com.board.controller.action.BoardWriteFormAction;
import com.board.controller.action.EditMemberAction;
import com.board.controller.action.EditMemberFormAction;
import com.board.controller.action.IdCheckAction;
import com.board.controller.action.IndexAction;
import com.board.controller.action.JoinAction;
import com.board.controller.action.JoinFormAction;
import com.board.controller.action.LoginAction;
import com.board.controller.action.LogoutAction;
import com.board.controller.action.MainAction;

public class ActionFactory {

	//싱글턴 패턴
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	//getAction 
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) ac = new IndexAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("main")) ac = new MainAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("idcheck")) ac = new IdCheckAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("editMemberForm")) ac = new EditMemberFormAction();
		else if(command.equals("editMember")) ac = new EditMemberAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		else if(command.equals("boardView")) ac = new BoardViewAction();
		else if(command.equals("boardWriteForm")) ac = new BoardWriteFormAction();
		else if(command.equals("boardwrite")) ac = new BoardWriteAction();
		
		return ac;
	}
}
