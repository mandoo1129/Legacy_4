package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BankBookService {
	//Controller -> Service -> DAO
	//DAO로 데이터를 보내기 전에 전처리 작업
	//DAO에서 리턴 받은 데이터를 Controller로 보내기 전에 후처리 작업
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//메서드는 DAO의 메서드와 거의 동일
	
	//list
	public List<BankBookDTO> list() throws Exception {
		List<BankBookDTO> ar = BankBookDAO.list();
		
		return ar;
		
	}
}
