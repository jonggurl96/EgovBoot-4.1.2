package egovframework.ablyr.web;


import egovframework.ablyr.dto.sample.SampleDTO;
import egovframework.ablyr.service.SampleService;
import egovframework.ablyr.vo.sample.SampleVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/SAMPLE")
@RequiredArgsConstructor
public class SampleController {
	
	private final SampleService sampleService;
	
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
	
}
