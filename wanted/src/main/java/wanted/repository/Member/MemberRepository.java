package wanted.repository.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import wanted.model.Member;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
	@Autowired
	private final EntityManager em;
	
	//== 로그인 로직 ==//
	public Member login(Member member) {
		List<Member> findMember = em.createQuery("SELECT m FROM Member m WHERE m.email = :email AND m.password = :password", Member.class)
		.setParameter("email", member.getEmail())
		.setParameter("password", member.getPassword())
		.getResultList();
		if (findMember.isEmpty()) {
			return null;
		}
		return findMember.get(0);
	}
	
	//== 아이디 중복 체크 ==//
	public boolean joinCheck(Member member) {
		List<Member> findMember = em.createQuery("SELECT m FROM Member m WHERE m.email = :email", Member.class)
				.setParameter("email", member.getEmail())
				.getResultList();
		if (findMember.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	//== 회원가입 ==//
	public void join(Member member) {
		em.persist(member);
	}
	
}
