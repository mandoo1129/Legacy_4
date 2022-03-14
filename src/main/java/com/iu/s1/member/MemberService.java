package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDTO mypage(MemberDTO memberDTO)throws Exception{
		return memberDAO.mypage(memberDTO);
	}
	
	
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	public int join(MemberDTO memberDTO, MultipartFile photo)throws Exception{
		return memberDAO.join(memberDTO);
		
		//1. 파일을 HDD에 저장
		
		//2. 정보를 DB에 저장
		fileManager.save(photo, "resources/uploadmember/")
		
		return memberDAO.join(memberDTO);
	}

}