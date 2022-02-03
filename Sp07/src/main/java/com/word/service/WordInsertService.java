package com.word.service;

import com.word.dao.WordDao;
import com.word.dto.WordSet;

public class WordInsertService {
	
	private WordDao worddao;
	
	public WordInsertService(WordDao wdao) {
		this.worddao=wdao;
	}
	public void insert(WordSet wordSet) {
		worddao.insert(wordSet);
	}
}
