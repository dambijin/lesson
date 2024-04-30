package com.spring.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// bean으로 등록
// 보통 DAO 클래스에서 사용
@Repository("memberDAOImpl")
@Primary
public class MemberDAOImpl implements MemberDAO {

	MemberDAOImpl(){
		System.out.println("MemberDAOImpl 생성");
	}
	
	@Override
	public List selectMember() {
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);

		return list;
	}

}
