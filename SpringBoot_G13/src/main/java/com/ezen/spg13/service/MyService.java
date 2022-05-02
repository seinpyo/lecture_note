package com.ezen.spg13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.ezen.spg13.dao.ITransactionDao1;
import com.ezen.spg13.dao.ITransactionDao2;

@Service
public class MyService {
	
	@Autowired
	ITransactionDao1 td1;
	@Autowired
	ITransactionDao2 td2;
	
	@Autowired
	TransactionTemplate tt;
	
	public int buy(String id, int amount, int error) {
		try {
			tt.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					td1.buy(id, amount);
					int n = 0;
					if(error == 1) n = 10/0; //강제 에러발생
					td2.buy(id, amount);
					System.out.println("Transaction Commit");
				}
			});
			return 1;
		} catch (Exception e) {
			System.out.println("Transaction Rollback");
			return 0;
		}
	}
	
/*	@Autowired
	PlatformTransactionManager ptm;
	@Autowired
	TransactionDefinition td;
	
	public int buy(String id, int amount, int error) {
		
		int result = 0;
		int n = 0;
		//전달 된 아이디와 구매 갯수를 transaction1, transaction2 두개의 테이블에 insert

		//트랜젝션의 시작
		TransactionStatus status = ptm.getTransaction(td);
		
		try {
			td1.buy(id, amount);
			if(error == 1) n = 10/0; //강제 에러발생
			td2.buy(id, amount);
			ptm.commit(status); 
			// 트랜젝션의 끝 = commit or rollback - 영역 안의 모든 데이터 베이스 작업 실행
			result = 1;
		} catch(Exception e) { 
			ptm.rollback(status); // 영역 안의 모든 데이터 베이스 작업 취소
			result = 0;
		}
		
		return result; }*/
	
}
