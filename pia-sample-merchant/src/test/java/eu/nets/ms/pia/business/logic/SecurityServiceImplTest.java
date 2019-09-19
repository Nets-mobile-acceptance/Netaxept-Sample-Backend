package eu.nets.ms.pia.business.logic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

public class SecurityServiceImplTest {
	
	//This JWT expires 2024-05-20
	private static final String VALID_JWT   = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJEZW1vIiwiZXhwIjoxNzE2MjM5MDIyLCJuYW1lIjoiVGVzdCIsImlhdCI6MTUxNjIzOTAyMn0.aigJfL6FDX-MdaOvzNWFqxoq5KCWibhupYOXprEzjVA";
	private static final String CORRUPT_JWT  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJEZW1vIiwibmFtZSI6IlRlc3QiLCJpYXQiOjE3MTYyMzkwMXyIGpLg4Bekx9-4auspAhzP2EiQF4HA3QhVQRuRG3s";
	private static final String MODIFIED_JWT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJEZW1vIiwibmFtZSI6IlRlc3QiLCJpYXQiljE3MTYyMzkwMjJ9.NXyIGpLg4Bekx9-4auspAhzP2EiQF4HA3QhVQRuRG3s";
	private static final String INVALID_JWT  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJEZW1vIiwibmFtZSI6IlRlc3QiLCJpYXQiOjEzMTYyMzkwMjJ9.iNydzYOSMSg0tUBNWeoXHBYt8vsv_Ncq6H0PllEsB3E";
	private static final String EXPIRED_JWT  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJEZW1vIiwiZXhwIjoxMzE2MjM5MDIyLCJuYW1lIjoiVGVzdCIsImlhdCI6MTUxNjIzOTAyMn0.HxQHchp6eCy7su2-p6PFj0PymkYIw1jrjnCnHdzduW8";
	
	
	
	SecurityService service = new SecurityServiceImpl();
	
	@Ignore
	@Test
	public void jwtShouldBeValidatedOK() {
		Claims claims = service.verifyToken(VALID_JWT);
		assertThat(claims.getSubject(), is(equalTo("Demo")));
		assertThat(claims.get("name"), is(equalTo("Test")));
		
	}
	
	@Ignore
	@Test(expected = SignatureException.class)
	public void jwtShouldBeInvalid() {
		service.verifyToken(INVALID_JWT);
	}
	
	@Ignore
	@Test(expected = ExpiredJwtException.class)
	public void jwtShouldDetectExpired() {
		service.verifyToken(EXPIRED_JWT);
	}

}
