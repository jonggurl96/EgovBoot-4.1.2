package egovframework.com.cmm.service;

import egovframework.com.cmm.login.LoginVO;

import java.util.List;

public interface EgovUserDetailsService {

	/**
	 * 인증된 사용자객체를 VO형식으로 가져온다.
	 * @return LoginVO - 사용자 ValueObject
	 */
	public LoginVO getAuthenticatedUser();

	/**
	 * 인증된 사용자의 권한 정보를 가져온다.
	 * 예) <pre>
	 *     [
	 *       ROLE_ADMIN,
	 *       ROLE_USER,
	 *       ROLE_A,
	 *       ROLE_B,
	 *       ROLE_RESTRICTED,
	 *       IS_AUTHENTICATED_FULLY,
	 *       IS_AUTHENTICATED_REMEMBERED,
	 *       IS_AUTHENTICATED_ANONYMOUSLY
	 *     ]
	 *     </pre>
	 * @return List - 사용자 권한정보 목록
	 */
	public List<String> getAuthorities();
	
	/**
	 * 인증된 사용자 여부를 체크한다.
	 * @return Boolean - 인증된 사용자 여부(TRUE / FALSE)	
	 */
	public Boolean isAuthenticated(); 

}
