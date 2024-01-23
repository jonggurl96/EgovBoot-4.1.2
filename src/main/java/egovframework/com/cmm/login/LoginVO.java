package egovframework.com.cmm.login;


import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 *   수정일         수정자     수정내용
 *  ------------  --------  ---------------------------
 *   2009.03.03    박지욱     최초 생성
 *   2021.05.30    정진오     디지털원패스 사용자키/세션값 추가
 * </pre>
 *
 * @author 공통서비스 개발팀 박지욱
 * @version 1.0
 * @Class Name : LoginVO.java
 * @Description : Login VO class
 * @see
 * @since 2009.03.03
 */
@Getter
@Setter
public class LoginVO {
	
	/**
	 * 아이디
	 */
	private String id;
	
	/**
	 * 이름
	 */
	private String name;
	
	/**
	 * 주민등록번호
	 */
	private String ihidNum;
	
	/**
	 * 이메일주소
	 */
	private String email;
	
	/**
	 * 비밀번호
	 */
	private String password;
	
	/**
	 * 비밀번호 힌트
	 */
	private String passwordHint;
	
	/**
	 * 비밀번호 정답
	 */
	private String passwordCnsr;
	
	/**
	 * 사용자구분
	 */
	private String userSe;
	
	/**
	 * 조직(부서)ID
	 */
	private String orgnztId;
	
	/**
	 * 조직(부서)명
	 */
	private String orgnztNm;
	
	/**
	 * 고유아이디
	 */
	private String uniqId;
	
	/**
	 * 로그인 후 이동할 페이지
	 */
	private String url;
	
	/**
	 * 사용자 IP정보
	 */
	private String ip;
	
	/**
	 * GPKI인증 DN
	 */
	private String dn;
	
	/**
	 * 디지털원패스 사용자키
	 */
	private String onepassUserkey;
	
	/**
	 * 디지털원패스 사용자세션값
	 */
	private String onepassIntfToken;
	
}
