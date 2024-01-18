package egovframework.ablyr.vo.sample;


import egovframework.ablyr.vo.AbstractVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.ibatis.type.Alias;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Alias("sampleVO")
public class SampleVO extends AbstractVO {
	
	private int c;
	
}
