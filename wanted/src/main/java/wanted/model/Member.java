package wanted.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity @Getter
public class Member {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="member_id")
	private Long id;
	private String email;
	private String password;
	
	@OneToMany(mappedBy="member")
	private List<Community> communitys = new ArrayList<>();
	
	public Member() { }
	
	public Member(Long id) {
		this.id = id;
	}
	
	public Member(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public void setPassword(String securityPassword) {
		this.password = securityPassword;
	}
	
	public void setSecurityPassword() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String securityPassword = passwordEncoder.encode(password);
		password = securityPassword;
	}
	
	public boolean checkEmail() {
		if (email.contains("@")) {
			return true;
		}
		return false;
	}
	
	public boolean checkPassword() {
		if (password.length() < 8) {
			return false;
		} return true;
	}
	
}
