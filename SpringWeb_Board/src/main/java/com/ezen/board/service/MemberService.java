package com.ezen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;

@Service //자동으로 컨테이너에 적재
public class MemberService {

	@Autowired
	MemberDao mdao;

	public MemberDto getMember(String id) {
		MemberDto mdto = mdao.getMember(id);
		return mdto;
	}
}
