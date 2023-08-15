package wanted.service.community;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import wanted.model.Community;
import wanted.repository.community.CommunityRepository;

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
	
	public List<Community> getList() {
		List<Community> communities = communityRepository.getList();
		if (communities.size() == 0) {
			return null;
		}
		return communities;
	}
	
	public Community getCommunity(Long id) {
		return communityRepository.getCommunity(id);
	}
	
	@Transactional
	public void delCommunity(Long id) {
		communityRepository.delCommunity(id);
	}
	
	@Transactional
	public void updateCommunity(Community community) {
		Community beforeCommunity = communityRepository.getCommunity(community.getId());
		beforeCommunity.setCommunity(community.getTitle(), community.getContent());
		communityRepository.updateCommunity(beforeCommunity);
	}
}
