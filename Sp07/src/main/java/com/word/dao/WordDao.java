package com.word.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.word.dto.WordSet;
import com.word.util.DataBaseManager;

public class WordDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataBaseManager dbm;
	
	public WordDao(DataBaseManager dbm) {
		this.dbm = dbm;
	}

	public void insert(WordSet wordSet) {
		con = dbm.getConnection();
	}
}
