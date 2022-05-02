package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.word.dao.WordDao;
import com.word.dto.WordSet;

public class WordInsertService {
	
	@Autowired
	private WordDao worddao;
	
//	public WordInsertService(WordDao wdao) {
//		this.worddao=wdao;
//	}
	public void insert(WordSet wordSet) {
		worddao.insert(wordSet);
	}
}
