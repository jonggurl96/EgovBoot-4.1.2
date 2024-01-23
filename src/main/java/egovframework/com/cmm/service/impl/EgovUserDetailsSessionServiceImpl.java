package egovframework.com.cmm.service.impl;


import java.util.List;

import egovframework.com.cmm.login.LoginVO;
import egovframework.com.cmm.service.EgovUserDetailsService;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.access.service.EgovUserDetailsHelper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 개정이력(Modification Information)
 *
 *   수정일           수정자    수정내용
 *  --------------  -------  ---------
 *   2011. 8. 12.    서준식    최초생성
 *  </pre>
 *
 * @author 공통서비스 개발팀 서준식
 * @version 1.0
 * @see
 * @since 2011. 6. 25.
 */
@Service
@Profile({"default", "local", "dev", "prod", "spring", "oper"})
public class EgovUserDetailsSessionServiceImpl extends EgovAbstractServiceImpl implements EgovUserDetailsService {
	
	/**
	 * 인증된 사용자객체를 VO형식으로 가져온다.
	 *
	 * @return LoginVO - 사용자 ValueObject
	 */
	public LoginVO getAuthenticatedUser() {
		if(EgovUserDetailsHelper.isAuthenticated()) {
			return (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		}
		return null;
	}
	
	public List<String> getAuthorities() {
		// 권한 설정을 리턴한다.
		return EgovUserDetailsHelper.getAuthorities();
	}
	
	public Boolean isAuthenticated() {
		// 인증된 유저인지 확인한다.
		return EgovUserDetailsHelper.isAuthenticated();
	}
	
}
