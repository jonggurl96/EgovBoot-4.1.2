package egovframework.ablyr.mapper;


import egovframework.ablyr.dto.sample.SampleDTO;
import egovframework.ablyr.vo.sample.SampleVO;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface SampleMapper {
	
	/**
	 * @return {@code SELECT 1;}
	 * @throws Exception
	 */
	public int selectOne() throws Exception;
	
	public SampleVO selectSampleAdd(SampleDTO sampleDTO) throws Exception;
}
