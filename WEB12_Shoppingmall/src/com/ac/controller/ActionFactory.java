package com.ac.controller;

import com.ac.controller.action.Action;
import com.ac.controller.action.CartDeleteAction;
import com.ac.controller.action.CartInsertAction;
import com.ac.controller.action.CartListAction;
import com.ac.controller.action.CategoryAction;
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
import com.ac.controller.action.MemberUpdateAction;
import com.ac.controller.action.MyPageAction;
import com.ac.controller.action.OrderAllAction;
import com.ac.controller.action.OrderInsertAction;
import com.ac.controller.action.OrderListAction;
import com.ac.controller.action.OrderOneAction;
import com.ac.controller.action.ProductDetailAction;
import com.ac.controller.action.QnaListAction;
import com.ac.controller.action.QnaViewAction;
import com.ac.controller.action.QnaWriteAction;
import com.ac.controller.action.QnaWriteFormAction;

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
		else if (command.equals("memberUpdate")) ac = new MemberUpdateAction();
		else if (command.equals("productDetail")) ac = new ProductDetailAction();
		else if (command.equals("category")) ac = new CategoryAction();
		else if (command.equals("cartInsert")) ac = new CartInsertAction();
		else if (command.equals("cartList")) ac = new CartListAction();
		else if (command.equals("cartDelete")) ac = new CartDeleteAction();
		else if (command.equals("orderInsert")) ac = new OrderInsertAction();
		else if (command.equals("orderList")) ac = new OrderListAction();
		else if (command.equals("myPage")) ac = new MyPageAction();
		else if (command.equals("orderAll")) ac = new OrderAllAction();
		else if (command.equals("orderOne")) ac = new OrderOneAction();
		else if (command.equals("qnaList")) ac = new QnaListAction();
		else if (command.equals("qnaView")) ac = new QnaViewAction();
		else if (command.equals("qnaWriteForm")) ac = new QnaWriteFormAction();
		else if (command.equals("qnaWrite")) ac = new QnaWriteAction();
		
		return ac;
	}
}
