package com.controller;

import com.controller.action.*;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() { return itc; }
	

	public Action getAction(String command) {
		Action ac = null;
		if(command.equals("index")) ac = new IndexAction();
		else if(command.equals("productVeiw")) ac = new ProductVeiwAction();
		else if(command.equals("productWriteForm")) ac = new ProductWriteFormAction();
		else if(command.equals("productWrite")) ac = new ProductWriteAction();
		else if(command.equals("updateForm")) ac = new UpdateFormAction();
		else if(command.equals("update")) ac = new UpdateAction();
		else if(command.equals("delete")) ac = new DeleteAction();
	
		return ac;
	}
}