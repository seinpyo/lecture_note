package com.board.controller;

import com.board.controller.action.Action;
import com.board.controller.action.IndexAction;
import com.board.controller.action.LoginAction;
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
		
		return ac;
	}
}
