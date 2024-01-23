package egovframework.com.cmm.message;


import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *   수정일         수정자    수정내용
 *  ------------  -------  ----------
 *   2016.06.10    장동한    최초 생성
 * </pre>
 *
 * @author 2016 표준프레임워크 유지보수 장동한
 * @version 1.0
 * @Class Name : EgovWildcardReloadableResourceBundleMessageSource
 * @Description : 다국어 properties 파일을 팩키지 구조의 폴더로 읽어드리는 MessageSource
 * @see
 * @since 2016.06.10
 */

public class EgovWildcardReloadableResourceBundleMessageSource extends
		org.springframework.context.support.ReloadableResourceBundleMessageSource {
	
	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	
	public void setEgovBasenames(String... basenames) {
		if(basenames != null) {
			List<String> baseNames = new ArrayList<>();
			for(String s : basenames) {
				String basename = StringUtils.trimToEmpty(s);
				if(basename.contains("classpath:/")) {
					baseNames.add(basename);
				} else if(StringUtils.isNotBlank(basename)) {
					try {
						Resource[] resources = resourcePatternResolver.getResources(basename);
						
						for(Resource resource : resources) {
							String uri = resource.getURI().toString();
							String baseName = null;
							
							if(!uri.contains(".properties")) {
								continue;
							}
							
							if(resource instanceof FileSystemResource) {
								baseName = "classpath:" + StringUtils.substringBetween(uri, "/classes/", ".properties");
								baseName = baseName.substring(0, baseName.indexOf("_"));
								baseName = baseName.replaceAll("classpath:", "classpath:/");
								if(baseNames.contains(baseName)) {
									continue;
								}
								
							} else if(resource instanceof ClassPathResource) {
								baseName = StringUtils.substringBefore(uri, ".properties");
								baseName = baseName.substring(0, baseName.indexOf("_"));
								baseName = baseName.replaceAll("classpath:", "classpath:/");
							} else if(resource instanceof UrlResource) {
								baseName = "classpath:" + StringUtils.substringBetween(uri, ".jar!/", ".properties");
								baseName = baseName.substring(0, baseName.indexOf("_"));
								baseName = baseName.replaceAll("classpath:", "classpath:/");
							}
							if(baseName != null) {
								String fullName = processBasename(baseName);
								baseNames.add(fullName);
							}
						}
					} catch(IOException e) {
						logger.debug("No message source files found for basename " + basename + ".");
					}
				}
				
				
			}
			
			logger.debug("EgovWildcardReloadableResourceBundleMessageSource>>basenames>[" + baseNames + "]");
			setBasenames(baseNames.toArray(new String[0]));
		}
	}
	
	String processBasename(String baseName) {
		String prefix = StringUtils.substringBeforeLast(baseName, "/");
		String name = StringUtils.substringAfterLast(baseName, "/");
		do {
			name = StringUtils.substringBeforeLast(name, "_");
		} while(name.contains("_"));
		return prefix + "/" + name;
	}
	
}