package wanted.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import wanted.model.Community;
import wanted.repository.CommunityRepository;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class CommunityService {
	private final CommunityRepository communityRepository;
	@Transactional
	public Long save(Community community) {
		communityRepository.save(community);
		return community.getId();
	}
	
	public Long getListCount() {
		Long count = communityRepository.getListCount();
		if (count % 5 == 0) {
			return count/5;
		} else {
			return (count/5) + 1;
		}
	}
	
	public List<Community> getList(int page) {
		List<Community> communities = communityRepository.getList(page);
		if (communities.size() == 0) {
			return null;
		}
		return communities;
	}
	
	public Community getCommunity(Long id) {
		return communityRepository.getCommunity(id);
	}
	
	@Transactional
	public String delCommunity(Community community) {
		Community beforeCommunity = communityRepository.getCommunity(community.getId());
		if (!beforeCommunity.getMember().getId().equals(community.getMember().getId())) {
			System.out.println("?");
			return "권한이 존재하지 않습니다.";
		}
		communityRepository.delCommunity(beforeCommunity);
		return null;
	}
	
	@Transactional
	public String updateCommunity(Community community) {
		Community beforeCommunity = communityRepository.getCommunity(community.getId());
		if (!beforeCommunity.getMember().getId().equals(community.getMember().getId())) {
			return "권한이 존재하지 않습니다.";
		}
		beforeCommunity.setCommunity(community.getTitle(), community.getContent());
		communityRepository.updateCommunity(beforeCommunity);
		return null;
	}
}
