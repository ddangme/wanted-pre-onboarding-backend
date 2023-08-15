package wanted.controller.community;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import wanted.dto.CommunityDTO;
import wanted.model.Community;
import wanted.service.community.CommunityService;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
	
	private final CommunityService communityService;
	
	@PostMapping("")
	public Long write(@RequestBody CommunityDTO dto) {
		Community community = new Community(dto.getTitle(), dto.getContent(), dto.getMemberId());
		return communityService.save(community);
	}
	
	@DeleteMapping("/{id}")
	public String delCommunity(@PathVariable Long id, @RequestBody CommunityDTO dto) {
		Community community = new Community(dto.getId(), dto.getMemberId());
		return communityService.delCommunity(community);
	}
	
	@PutMapping("")
	public String updateCommunity(@RequestBody CommunityDTO dto) {
		Community community = new Community(dto.getId(), dto.getTitle(), dto.getContent(), dto.getMemberId());
		return communityService.updateCommunity(community);
	}
	
}
