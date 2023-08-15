package wanted.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {
	private Long id;
	private String email;
	private String password;
	
	public MemberDTO() { }
	
}
