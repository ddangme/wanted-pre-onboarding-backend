package wanted.service.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import wanted.model.Member;
import wanted.repository.Member.MemberRepository;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	
	public String login(Member member) {
//		member.setSecurityPassword();
//		System.out.println(member.getPassword());
		if (!member.checkEmail()) {
			return "이메일 형식으로 입력해주세요.";
		} else if (!member.checkPassword()) {
			return "비밀번호는 8자 이상으로 입력해주세요.";
		}
		Member findMember = memberRepository.login(member);
		if (findMember == null) {
			return "-1";
		}
		return memberRepository.login(member).getId().toString();
	}
	
	@Transactional
	public String join(Member member) {
		if (!member.checkEmail()) {
			return "이메일 형식으로 입력해주세요.";
		} else if (!member.checkPassword()) {
			return "비밀번호는 8자 이상으로 입력해주세요.";
		}
		if (memberRepository.joinCheck(member)) {
			memberRepository.join(member);
			return null;
		} else {
			return "존재하는 아이디 입니다.";
		}
	}
}
