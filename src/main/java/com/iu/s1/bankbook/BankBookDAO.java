package com.iu.s1.bankbook;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.bankbook.BankBookDAO.";
	
	//update
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public int update(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.update(bankBookDTO);
		return "redirect
		
		
	}
	
	//detail
	public BankBookDTO detail(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail", bankBookDTO);
	}

	//list
	public List<BankBookDTO> list() throws Exception{
		return sqlSession.selectList(NAMESPACE+"list");
	}
	
	//insert
	public int add(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"add", bankBookDTO);
	}
	
	//delete
	public int delete(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", bankBookDTO);
	}
	
}