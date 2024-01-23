package egovframework.config.cmm.message;


import egovframework.com.cmm.message.EgovMessageSource;
import egovframework.com.cmm.message.EgovWildcardReloadableResourceBundleMessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EgovConfigMsgSrc {
	
	/**
	 * 국제화 메세지
	 */
	@Bean
	public EgovWildcardReloadableResourceBundleMessageSource messageSource() {
		EgovWildcardReloadableResourceBundleMessageSource messageSource = new EgovWildcardReloadableResourceBundleMessageSource();
		messageSource.setBasenames(
				"classpath*:egovframework/message/com/*",
				"classpath*:egovframework/message/com/**/*",
				"classpath:/org/egovframe/rte/fdl/idgnr/messages/idgnr",
				"classpath:/org/egovframe/rte/fdl/property/messages/properties",
				"classpath:/egovframework/egovProps/globals.properties");
		messageSource.setCacheSeconds(60);
		return messageSource;
	}
	
	@Bean
	public EgovMessageSource egovMessageSource() {
		EgovMessageSource egovMessageSource = new EgovMessageSource();
		egovMessageSource.setReloadableResourceBundleMessageSource(messageSource());
		return egovMessageSource;
	}
}
