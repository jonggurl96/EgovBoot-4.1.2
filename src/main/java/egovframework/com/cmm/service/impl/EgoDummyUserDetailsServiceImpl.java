package egovframework.com.cmm.service.impl;


import egovframework.com.cmm.login.LoginVO;
import egovframework.com.cmm.service.EgovUserDetailsService;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 개정이력(Modification Information)
 *
 *   수정일           수정자      수정내용
 *  --------------  --------   ---------------------------
 *   2011. 8. 12.    서준식      최초생성
 *   2017. 9. 04.    장동한      클래스 이름 변경(EgovTestUserDetailsServiceImpl > EgovUserDetailsService)
 *  </pre>
 *
 * @author 공통서비스 개발팀 서준식
 * @version 1.0
 * @see
 * @since 2011. 8. 12.
 */
@Service
@Profile("dummy")
public class EgoDummyUserDetailsServiceImpl extends EgovAbstractServiceImpl implements
		EgovUserDetailsService {
	
	@Override
	public LoginVO getAuthenticatedUser() {
		LoginVO loginVO = new LoginVO();
		loginVO.setId("TEST1");
		loginVO.setPassword("raHLBnHFcunwNzcDcfad4PhD11hHgXSUr7fc1Jk9uoQ=");
		loginVO.setUserSe("USR");
		loginVO.setEmail("egovframe@nia.or.kr");
		loginVO.setIhidNum("");
		loginVO.setName("더미사용자");
		loginVO.setOrgnztId("ORGNZT_0000000000000");
		loginVO.setUniqId("USRCNFRM_00000000000");
		return loginVO;
	}
	
	@Override
	public List<String> getAuthorities() {
		// 권한 설정을 리턴한다.
		List<String> listAuth = new ArrayList<>();
		listAuth.add("IS_AUTHENTICATED_ANONYMOUSLY");
		listAuth.add("IS_AUTHENTICATED_FULLY");
		listAuth.add("IS_AUTHENTICATED_REMEMBERED");
		listAuth.add("ROLE_ADMIN");
		listAuth.add("ROLE_ANONYMOUS");
		listAuth.add("ROLE_RESTRICTED");
		listAuth.add("ROLE_USER");
		return listAuth;
	}
	
	@Override
	public Boolean isAuthenticated() {
		// 인증된 유저인지 확인한다.
		return true;
	}
	
}
