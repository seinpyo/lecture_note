package com.controller;
import com.controller.action.*;

public class ActionFactory {

	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; } 
	
	public Action getAction(String command) {
		
	
		Action ac = null;
		
		 if(command.equals("loginForm")) ac = new LoginFormAction();
		 else if(command.equals("login")) ac = new LoginAction();
		 else if (command.equals("joinForm")) ac = new JoinFormAction();
		 else if (command.equals("logout")) ac = new LogoutAction();
		 else if (command.equals("idcheck")) ac = new IdCheckAction();
		 else if (command.equals("join")) ac = new JoinAction();
		 else if (command.equals("updateForm")) ac = new UpdateFormAction();
		 else if (command.equals("update")) ac = new UpdateAction();
		 else if (command.equals("deleteMember")) ac = new DeleteMemberAction();
		 else if (command.equals("main")) ac = new MainAction();
		 else if (command.equals("editAdmin")) ac = new EditAdminAction();
		 		 
		 
		 return ac; 
	}

}
