package kr.co.mbc.service;

import org.springframework.stereotype.Service;

import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	public void save(MemberEntity memberEntity) {
		memberRepository.save(memberEntity);
	}

	public MemberEntity findByUsername(String username) {
		
		return memberRepository.findByUsername(username);
	}

	public MemberEntity login(MemberEntity memberEntity) throws Exception {
		
		MemberEntity dbEntity = memberRepository.findByUsernameAndPassword(memberEntity.getUsername(), memberEntity.getPassword());
		
		if(dbEntity == null) {
			throw new Exception("아이디 또는 비번이 잘못됐음.");
		}
		
		return dbEntity;
	}
	
}
