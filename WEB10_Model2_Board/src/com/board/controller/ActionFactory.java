package com.board.controller;

import com.board.controller.action.Action;
import com.board.controller.action.AddReplyAction;
import com.board.controller.action.BoardCheckPassAction;
import com.board.controller.action.BoardDeleteAction;
import com.board.controller.action.BoardPassFormAction;
import com.board.controller.action.BoardUpdateAction;
import com.board.controller.action.BoardUpdateFormAction;
import com.board.controller.action.BoardViewAction;
import com.board.controller.action.BoardWriteAction;
import com.board.controller.action.BoardWriteFormAction;
import com.board.controller.action.DeleteReplyAction;
import com.board.controller.action.EditMemberAction;
import com.board.controller.action.EditMemberFormAction;
import com.board.controller.action.IdCheckAction;
import com.board.controller.action.IndexAction;
import com.board.controller.action.JoinAction;
import com.board.controller.action.JoinFormAction;
import com.board.controller.action.LoginAction;
import com.board.controller.action.LogoutAction;
import com.board.controller.action.MainAction;
import com.board.controller.action.boardViewWithoutCount;

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
		else if(command.equals("boardPassForm")) ac = new BoardPassFormAction();
		else if(command.equals("boardCheckPass")) ac = new BoardCheckPassAction();
		else if(command.equals("boardUpdateForm")) ac = new BoardUpdateFormAction();
		else if(command.equals("boardUpdate")) ac = new BoardUpdateAction();
		else if(command.equals("boardViewWithoutCount")) ac = new boardViewWithoutCount();
		else if(command.equals("boardDelete")) ac = new BoardDeleteAction();
		else if(command.equals("addReply")) ac = new AddReplyAction();
		else if(command.equals("deleteReply")) ac = new DeleteReplyAction();
		
		return ac;
	}
}
