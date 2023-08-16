package wanted.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import wanted.model.Member;
import wanted.repository.MemberRepository;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public String login(Member member) {
		if (!member.checkEmail()) {
			return "이메일 형식으로 입력해주세요.";
		}
		if (!member.checkPassword()) {
			return "비밀번호는 8자 이상으로 입력해주세요.";
		}
		Member findMember = memberRepository.login(member);
		if (findMember == null) {
			return "존재하지 않는 계정입니다.";
		} 
		if (!passwordEncoder.matches(member.getPassword(), findMember.getPassword())) {
			return "비밀번호가 일치하지 않습니다.";
		}
		return "성공" + memberRepository.login(member).getId().toString();
	}
	
	@Transactional
	public String join(Member member) {
		if (!member.checkEmail()) {
			return "이메일 형식으로 입력해주세요.";
		}
		if (!member.checkPassword()) {
			return "비밀번호는 8자 이상으로 입력해주세요.";
		}
		String securityPassword = passwordEncoder.encode(member.getPassword());
		member.setPassword(securityPassword);
		if (memberRepository.joinCheck(member)) {
			memberRepository.join(member);
			return null;
		} else {
			return "존재하는 아이디 입니다.";
		}
	}
}
