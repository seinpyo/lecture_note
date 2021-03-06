package com.ezen.spm17.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spm17.dao.IQnaDao;

@Service
public class QnaService {

	@Autowired
	IQnaDao qdao;

	public void listQna(HashMap<String, Object> paramMap) {
		qdao.listQna(paramMap);
	}
}
