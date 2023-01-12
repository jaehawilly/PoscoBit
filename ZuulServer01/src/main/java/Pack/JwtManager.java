package Pack;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import org.springframework.stereotype.Component;

import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtManager {
	private final String securityKey = "2222"; // TODO 민감정보는 따로 분리하는 것이 좋다
	private final Long expiredTime = 1000 * 60L * 60L * 3L; // 유효시간 3시간
//  private final Long expiredTime = 1L; // 유효시간 

	/**
	 * Member 정보를 담은 JWT 토큰을 생성한다.
	 *
	 * @param member Member 정보를 담은 객체
	 * @return String JWT 토큰
	 */
	public String generateJwtToken(Member member) {
		Date now = new Date();
		return Jwts.builder()
				.setSubject(member.getId()) // 보통 username
				.setHeader(createHeader())
				.setClaims(createClaims(member)) // 클레임, 토큰에 포함될 정보
				.setExpiration(new Date(now.getTime() + expiredTime)) // 만료일
				.signWith(SignatureAlgorithm.HS256, securityKey).compact();
	}

	private Map<String, Object> createHeader() {
		Map<String, Object> header = new HashMap<>();
		header.put("typ", "JWT");
		header.put("alg", "HS256"); // 해시 256 사용하여 암호화
		header.put("regDate", System.currentTimeMillis());
		return header;
	}

	/**
	 * 클레임(Claim)을 생성한다.
	 *
	 * @param member 토큰을 생성하기 위한 계정 정보를 담은 객체
	 * @return Map<String, Object> 클레임(Claim)
	 */
	private Map<String, Object> createClaims(Member member) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("Id", member.getId());
		claims.put("Pw", member.getPw());
		return claims;
	}

	/**
	 * Token 에서 Claim 을 가져온다.
	 *
	 * @param token JWT 토큰
	 * @return Claims 클레임
	 */
	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody();
	}

	/**
	 * 토큰으로 부터 username 을 가져온다.
	 *
	 * @param token JWT 토큰
	 * @return String Member 의 username
	 */
	public String getIdFromToken(String token) {
		try {
			return (String) getClaims(token).get("Id");
		} catch (Exception e) {
			return null;
		}
	}

	public String getPwFromToken(String token) {
		try {
			return (String) getClaims(token).get("Pw");
		} catch (Exception e) {
			return null;
		}
	}

	public boolean validateToken(String token) {
		if (StringUtils.hasText(token)) {
			try {
				Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token);
				return true;
			} catch (SignatureException e) {
				System.out.println("잘못된 JWT 서명");
			} catch (MalformedJwtException e) {
				System.out.println("잘못된 JWT 토큰");
			} catch (ExpiredJwtException e) {
				System.out.println("만료된 JWT 토큰");
			} catch (UnsupportedJwtException e) {
				System.out.println("지원되지 않는 JWT 토큰");
			} catch (IllegalArgumentException e) {
				System.out.println("JWT 클레임 문자열이 비어 있습니다");
			}
		}
		return false;
	}
}