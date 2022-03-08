package com.ezen.shop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.shop.dao.QnaDao;
import com.ezen.shop.dto.QnaVO;

@Service
public class QnaService {
	@Autowired QnaDao qdao;

	public ArrayList<QnaVO> lisetQna(String userid) {
		return qdao.listQna(userid);
	}

	public void insertQna(QnaVO qvo, String userid) {
		qdao.insertQna(qvo, userid);
	}

	public QnaVO getQna(int qseq) {
		return QnaVO;
	}
}
