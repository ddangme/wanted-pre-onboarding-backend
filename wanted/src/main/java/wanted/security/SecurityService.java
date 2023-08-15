package wanted.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class SecurityService {
	private static final String SECRET_KEY = "aawefofjaklsvkeiafoesjf";
	
	public String createToken(String subject, Long expTime) {
		if (expTime <= 0) {
			throw new RuntimeException("만료시간이 0보다 커야합니다.");
		}
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
		
		return Jwts.builder()
				.setSubject(subject)
				.signWith(signingKey, signatureAlgorithm)
				.setExpiration(new Date(System.currentTimeMillis() + expTime))
				.compact();
	}
	
	public String getSubject(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
}
