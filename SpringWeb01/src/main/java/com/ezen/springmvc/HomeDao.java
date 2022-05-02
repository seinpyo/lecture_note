package com.ezen.springmvc;

import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {

	public String getMessage() {
		return "Dao에서 보낸 메세지";
	}

}
