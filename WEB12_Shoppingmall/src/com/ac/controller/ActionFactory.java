package com.ac.controller;

import com.ac.controller.action.Action;
import com.ac.controller.action.ContractAction;
import com.ac.controller.action.EditFormAction;
import com.ac.controller.action.FindZipNumAction;
import com.ac.controller.action.IdCheckFormAction;
import com.ac.controller.action.IndexAction;
import com.ac.controller.action.JoinAction;
import com.ac.controller.action.JoinFormAction;
import com.ac.controller.action.LoginAction;
import com.ac.controller.action.LoginFormAction;
import com.ac.controller.action.LogoutAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	
	public Action getAction(String command) {
		
		Action ac = null;
		
		if (command.equals("index")) ac = new IndexAction();
		else if (command.equals("loginForm")) ac = new LoginFormAction();
		else if (command.equals("login")) ac = new LoginAction();
		else if (command.equals("logout")) ac = new LogoutAction();
		else if (command.equals("contract")) ac = new ContractAction();
		else if (command.equals("joinForm")) ac = new JoinFormAction();
		else if (command.equals("idCheckForm")) ac = new IdCheckFormAction();
		else if (command.equals("findZipNum")) ac = new FindZipNumAction();
		else if (command.equals("join")) ac = new JoinAction();
		else if (command.equals("editForm")) ac = new EditFormAction();
		
		
		return ac;
	}
}
