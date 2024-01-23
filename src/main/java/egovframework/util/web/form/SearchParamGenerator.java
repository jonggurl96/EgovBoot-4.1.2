package egovframework.util.web.form;


import egovframework.ablyr.dto.SearchDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * SearchParamGenerator.java
 * <pre>
 * SearchDTO를 Map으로 변환해주는 Generator
 * </pre>
 *
 * @author jongg
 * @version 1.0.0
 * @since 2024-01-23
 */
@Slf4j
@Component
public class SearchParamGenerator {
	
	/**
	 * SearchDTO의 Full Qualified Name
	 */
	private static final String TARGET_FQN = SearchDTO.class.getName();
	
	/**
	 * <pre>
	 *     1. dto 객체의 멤버 변수의 이름과 값을 HashMap에 저장
	 *     2. dto객체의 FQN이 SearchDTO의 FQN과 같은지 비교해 같으면 리턴
	 *     3. 다르면 {@snippet : return generate(dto.super);}
	 * </pre>
	 *
	 * @param dto SearchDTO를 상속받는 객체
	 *
	 * @return dto 객체부터 SearchDTO까지 모든 멤버 변수 이름과 값 HashMap
	 *
	 * @throws RuntimeException
	 */
	public Map<String, Object> generate(SearchDTO dto) throws RuntimeException {
		Map<String, Object> map = generateRecursive(dto, dto.getClass());
		
		// PaginationInfo의 currentPageNo, pageSize, recordCountPerPage 추가
		map.put("currentPageNo", dto.getCurrentPageNo());
		map.put("pageSize", dto.getPageSize());
		map.put("recordCountPerPage", dto.getRecordCountPerPage());
		
		return map;
	}
	
	/**
	 * SearchDTO를 상속받는 클래스부터 SearchDTO까지 모두 Map에 포함
	 *
	 * @param dto
	 * @param clazz
	 *
	 * @return
	 *
	 * @throws RuntimeException
	 */
	private Map<String, Object> generateRecursive(SearchDTO dto, Class<?> clazz) throws RuntimeException {
		Map<String, Object> map = new HashMap<>();
		Arrays.stream(clazz.getDeclaredFields())
				.forEach(field -> {
					// private 멤버 접근 허용
					field.setAccessible(true);
					
					String key = field.getName();
					try {
						Object value = field.get(dto);
						map.put(key, value);
					} catch(IllegalArgumentException | IllegalAccessException iae) {
						throw new RuntimeException("Failed Getting SearchDTO Field", iae);
					}
				});
		if(clazz.getName().equals(TARGET_FQN))
			return map;
		map.putAll(generateRecursive(dto, clazz.getSuperclass()));
		return map;
	}
	
}
