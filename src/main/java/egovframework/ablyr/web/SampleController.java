package egovframework.ablyr.web;


import egovframework.ablyr.dto.sample.SampleDTO;
import egovframework.ablyr.dto.sample.SampleSrchDTO;
import egovframework.ablyr.service.SampleService;
import egovframework.ablyr.vo.sample.SampleVO;
import egovframework.util.web.form.SearchParamGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/SAMPLE")
@RequiredArgsConstructor
public class SampleController {
	
	private final SampleService sampleService;
	
	private final SearchParamGenerator searchParamGenerator;
	
	@GetMapping("/selectOne")
	@ResponseBody
	public int sampleSelectOne() throws Exception {
		int one = sampleService.selectOne();
		log.debug(">>> SampleService.selectOne() returns {}", one);
		return one;
	}
	
	@PostMapping("/selectSampleAdd")
	@ResponseBody
	public SampleVO selectSampleAdd(SampleDTO sampleDTO) throws Exception {
		SampleVO result = sampleService.selectSampleAdd(sampleDTO);
		log.debug(">>> {} + {} = {}", sampleDTO.getA(), sampleDTO.getB(), result.getC());
		return result;
	}
	
	@GetMapping("/test/searchParamGenerator")
	@ResponseBody
	public Map<String, Object> test() throws Exception {
		SampleSrchDTO ssdto = new SampleSrchDTO(123, "PST_TTL", 10);
		return searchParamGenerator.generate(ssdto);
	}
	
}
