package wanted.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import wanted.model.Community;
import wanted.model.Member;

@Repository
@RequiredArgsConstructor
public class CommunityRepository {
	@Autowired
	private final EntityManager em;

	//== community 저장 로직 ==//
	public Long save(Community community) {
		em.persist(community);
		return community.getId(); 
	}
	
	//== community count 불러오는 로직 ==//
	public Long getListCount() {
		return em.createQuery("SELECT COUNT(c) FROM Community c", Long.class)
				.getSingleResult();
	}
	
	
	//== community list 불러오는 로직 ==//
	public List<Community> getList(int page) {
        return em.createQuery("SELECT c FROM Community c ORDER BY c.id DESC", Community.class)
        		.setFirstResult(page)
        		.setMaxResults(5)
        		.getResultList();
	}
	
	//== community 불러오는 로직 ==//
	public Community getCommunity(Long id) {
		List<Community> list = em.createQuery("SELECT c FROM Community c WHERE c.id = :communityId", Community.class)
				.setParameter("communityId", id)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	//== community 삭제 로직 ==//
	public void delCommunity(Community community) {
		em.remove(community);
	}
	
	//== community 수정 로직 ==//
	public void updateCommunity(Community community) {
		em.merge(community);
	}
	
	
}
