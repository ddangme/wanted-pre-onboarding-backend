package wanted.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import wanted.model.Community;
import wanted.service.CommunityService;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final CommunityService communityService;
	
	@GetMapping("")
	public String main(Model model) {
		model.addAttribute("communityList", communityService.getList(0));
		return "redirect:/login";
	}
	
	@GetMapping("/community/list")
	public String getList(Model model) {
		model.addAttribute("communityListCount", communityService.getListCount());
		model.addAttribute("communityList", communityService.getList(0));
		return "/community/list";
	}
	
	@GetMapping("/community/list/{no}")
	public String getPageList(Model model, @PathVariable int no) {
		model.addAttribute("communityListCount", communityService.getListCount());
		model.addAttribute("communityList", communityService.getList((no-1) * 5));
		
		// 2 > 5
		// 3 > 10
		// 2 > 6
		// 3 > 11
		// 4 > 16
		return "/community/list";
	}
	
	@GetMapping("/community/write")
	public String writeForm() {
		return "/community/write";
	}

	@GetMapping("/community/{id}")
	public String getCommunity(@PathVariable Long id, Model model) {
		Community community = communityService.getCommunity(id);
		model.addAttribute("community", community);
		return "/community/community";
	}
	
	@GetMapping("/community/update/{id}")
	public String updateCommunity(@PathVariable Long id, Model model) {
		Community community = communityService.getCommunity(id);
		model.addAttribute("community", community);
		return "/community/update";
	}
	
	@GetMapping("/login")
	private String loginForm() {
		return "/member/login";
	}
	
	@GetMapping("/join")
	private String joinForm() {
		return "/member/join";
	}
	
}
