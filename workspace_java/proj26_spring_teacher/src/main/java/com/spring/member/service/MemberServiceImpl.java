package com.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	MemberServiceImpl(){
		System.out.println("MemberServiceImpl 생성");
	}

	// IoC
	// Inversion of Control
	// 제어의 역전
	// 찾아서 new까지 대신해

	// 등록된 bean 중에서 
	// 형변환해서 지금 변수의 타입에 넣을 수 있는 bean을
	// new 해줌
	
	
	// DI
	// Dependency Injection
	// 의존성 주입
	// 넣어주기
	
	// 만약에 @Autowired 대상이 두개 이상인 경우
	// 1. @Primary가 있는 객체 우선
	// 2. @Qualifier가 있는 경우 지정한 객체를 찾기
	// 3. @Qualifier가 없는 경우 변수명과 bean id가 같은 객체를 찾는다
	
	@Autowired
	@Qualifier("memberDAOImpl")
	private MemberDAO memberDAO;
	
	@Override
	public List listMembers() {
		
		return memberDAO.selectMember();
	}

}
