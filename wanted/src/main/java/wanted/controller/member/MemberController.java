package wanted.controller.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import wanted.dto.MemberDTO;
import wanted.model.Member;
import wanted.service.member.MemberService;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	
	@PostMapping("/login")
	private String login(@RequestBody MemberDTO dto) {
		Member member = new Member(dto.getEmail(), dto.getPassword());
		return memberService.login(member);
	}
	
	@PostMapping("/join")
	private String join(@RequestBody MemberDTO dto) {
		Member member = new Member(dto.getEmail(), dto.getPassword());
		return memberService.join(member);
	}
}
