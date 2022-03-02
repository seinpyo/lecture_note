package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.word.dao.WordDao;
import com.word.dto.WordSet;

public class WordSearchService {
	
	@Autowired
	private WordDao worddao; 
	
//	public WordSearchService(WordDao wdao) {
//		this.worddao = wdao;
//	}
	
	public WordSet searchWord (String kw) {
		WordSet ws = worddao.search(kw);
		return ws;
	}
	
}
