package egovframework.com.sec.pki;


import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.cmm.message.EgovMessageSource;
import egovframework.com.cmm.service.EgovUserDetailsService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.egovframe.rte.fdl.cryptography.EgovEnvCryptoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 암호화/복호화 관한 controller 클래스를 정의한다.
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일         수정자    수정내용
 *  ------------  -------  ----------
 *   2018.12.03    신용호    최초 생성
 * </pre>
 *
 * @author 공통서비스 개발팀 신용호
 * @version 3.8
 * @see
 * @since 2018.12.03
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class EgovCryptoController {
	
	/**
	 * 암호화서비스
	 */
	private final EgovEnvCryptoService cryptoService;
	
	/**
	 * EgovMessageSource
	 */
	private final EgovMessageSource egovMessageSource;
	
	private final EgovUserDetailsService userDetailsService;
	
	/**
	 * 암호화/복호화 입력 및 요청 페이지를 호출한다.
	 *
	 * @return
	 */
	@IncludedInfo(name = "암호화/복호화", listUrl = "/sec/pki/EgovCryptoInfo.do", order = 2200, gid = 90)
	@RequestMapping(value = "/sec/pki/EgovCryptoInfo.do")
	public String displayCryptoInfo(String plainText,
	                                ModelMap model) throws Exception {
		log.debug("============================ Encrypt / Decrypt ============================ ");
		log.debug(">>> /sec/pki/EgovEncryptInfo.do?plainText={}", plainText);
		log.debug("=========================================================================== ");
		
		// 0. Spring Security 사용자권한 처리
//		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		boolean isAuthenticated = true;
		if(!isAuthenticated) {
			model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
			return "redirect:/uat/uia/egovLoginUsr.do";
		}
		
		if(plainText != null) {
			
			int plainTextLen = plainText.length();
			String cryptText = encrypt(plainText);
			String decryptText = decrypt(cryptText);
			int decryptTextLen = decryptText.length();
			
			model.addAttribute("plainText", plainText);
			model.addAttribute("plainTextLen", plainTextLen);
			model.addAttribute("cryptText", cryptText);
			model.addAttribute("decryptText", decryptText);
			model.addAttribute("decryptTextLen", decryptTextLen);
		}
		
		return "egovframework/com/sec/pki/EgovCryptoInfo";
	}
	
	/**
	 * 암호화
	 *
	 * @param encrypt
	 */
	private String encrypt(String encrypt) {
		
		try {
			//return cryptoService.encrypt(encrypt); // Handles URLEncoding.
			return cryptoService.encryptNone(encrypt); // Does not handle URLEncoding.
		} catch(IllegalArgumentException e) {
			log.error("[IllegalArgumentException] Try/Catch...usingParameters Runing : " + e.getMessage());
		}
		return encrypt;
	}
	
	/**
	 * 복호화
	 *
	 * @param decrypt
	 */
	private String decrypt(String decrypt) {
		
		try {
			//return cryptoService.decrypt(decrypt); // Handles URLDecoding.
			return cryptoService.decryptNone(decrypt); // Does not handle URLDecoding.
		} catch(IllegalArgumentException e) {
			log.error("[IllegalArgumentException] Try/Catch...usingParameters Runing : " + e.getMessage());
		}
		return decrypt;
	}
	
}