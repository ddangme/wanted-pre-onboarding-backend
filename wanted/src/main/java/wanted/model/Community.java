package wanted.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Community {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="community_id")
	private Long id;
	private String title;
	private String content;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;
	
	private LocalDateTime writeTime;
	
	private LocalDateTime updateTime;
	
	public Community() { }
	
	public Community(Long id, Long memberId) {
		this.id = id;
		this.member = new Member(memberId);
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Community(String title, String content, Long memberId) {
		this.title = title;
		this.content = content;
		this.member = new Member(memberId);
		this.writeTime = LocalDateTime.now(); 
	}
	
	public Community(Long id, String title, String content, Long memberId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.member = new Member(memberId);
	}
	
	public void setCommunity(String title, String content) {
		this.title = title;
		this.content = content;
		this.updateTime = LocalDateTime.now(); 
	}
	
}
