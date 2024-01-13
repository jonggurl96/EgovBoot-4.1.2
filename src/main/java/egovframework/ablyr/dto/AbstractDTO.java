package egovframework.ablyr.dto;


import egovframework.ablyr.vo.AbstractVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AbstractDTO.java
 * <p>
 * DTO 클래스들이 상속하는 최상위 클래스
 * <p>
 * AbstractVO 타입으로의 변환을 보장한다.
 *
 * @author jongg
 * @version 1.0.0
 * @since 2024-01-13, 토, 15:03
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractDTO {
	
	public abstract AbstractVO toVO();

}
