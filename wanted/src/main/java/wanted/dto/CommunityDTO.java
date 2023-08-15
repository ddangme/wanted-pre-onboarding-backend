package wanted.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommunityDTO {
	private Long id;
	private String title;
	private String content;
	private Long memberId;
	
	public CommunityDTO() { }
	
}
