package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class BankBookDAOTest extends MyJunitTest {
	
	@Autowired
	private BankBookDAO bankBookDAO;

	//@Test
	public void check() {
		assertNotNull(bankBookDAO);
	}

	//List
	//@Test
	public void listTest() throws Exception {
		 List<BankBookDTO> ar = bankBookDAO.list();
		 assertNotEquals(0, ar.size());
	}
	
	//Insert
	@Test
	public void addTest()throws Exception{
		for(int i=0;i<200;i++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookName"+i);
			bankBookDTO.setBookContents("Contents"+i);
			
			double rate = Math.random(); //0.0 ~ 1.0 미만의 double 타입을 리턴 0.12345678
			rate = rate*1000; //123.4567
			int r = (int)rate; //123
			rate = r/10.0; //1.23
			
			bankBookDTO.setBookRate(rate); //총 3자리, 소수점 2자리
			bankBookDTO.setBookSale(1);
			int result = bankBookDAO.add(bankBookDTO);
			
			if(i%10==0) {
				Thread.sleep(i); //1초 동안 멈추세요
			}
			
		}
		System.out.println("Insert Finish");
		//assertEquals(1, result);
	}
	
	//Detail
	//@Test
	public void detailTest()throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(150L);
		bankBookDTO = bankBookDAO.detail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
	
	//Delete
	//@Test
	public void deleteTest()throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		int result = bankBookDAO.delete(bankBookDTO);
		assertEquals(1, result);
	}
	


}