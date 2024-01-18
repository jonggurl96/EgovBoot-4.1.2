package egovframework.ablyr.dto.sample;


import egovframework.ablyr.dto.AbstractDTO;
import egovframework.ablyr.vo.AbstractVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("sampleDTO")
public class SampleDTO extends AbstractDTO {
	
	private int a;
	
	private int b;
	
	@Override
	public AbstractVO toVO() {
		return null;
	}
	
}
