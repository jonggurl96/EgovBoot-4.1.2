package egovframework.ablyr.service;


import egovframework.ablyr.dto.sample.SampleDTO;
import egovframework.ablyr.mapper.SampleMapper;
import egovframework.ablyr.vo.sample.SampleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
	
	private final SampleMapper sampleMapper;
	
	@Override
	public int selectOne() throws Exception {
		return sampleMapper.selectOne();
	}
	
	@Override
	public SampleVO selectSampleAdd(SampleDTO sampleDTO) throws Exception {
		return sampleMapper.selectSampleAdd(sampleDTO);
	}
	
}
