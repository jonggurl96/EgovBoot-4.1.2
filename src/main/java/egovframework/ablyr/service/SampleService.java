package egovframework.ablyr.service;


import egovframework.ablyr.dto.sample.SampleDTO;
import egovframework.ablyr.vo.sample.SampleVO;

public interface SampleService {
	
	public int selectOne() throws Exception;
	
	public SampleVO selectSampleAdd(SampleDTO sampleDTO) throws Exception;
}
