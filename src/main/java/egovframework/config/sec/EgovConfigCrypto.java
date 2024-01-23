package egovframework.config.sec;


import org.egovframe.rte.fdl.cryptography.EgovPasswordEncoder;
import org.egovframe.rte.fdl.cryptography.config.EgovCryptoConfig;
import org.egovframe.rte.fdl.cryptography.impl.EgovARIACryptoServiceImpl;
import org.egovframe.rte.fdl.cryptography.impl.EgovEnvCryptoServiceImpl;
import org.egovframe.rte.fdl.property.impl.EgovPropertyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class EgovConfigCrypto {
	
	@Bean
	public EgovCryptoConfig egovCryptoConfig() {
		EgovCryptoConfig egovCryptoConfig = new EgovCryptoConfig();
		egovCryptoConfig.setInitial(true);
		egovCryptoConfig.setCrypto(true);
		egovCryptoConfig.setAlgorithm("SHA-256");
		egovCryptoConfig.setAlgorithmKey("egovframe");
		egovCryptoConfig.setAlgorithmKeyHash("gdyYs/IZqY86VcWhT8emCYfqY1ahw2vtLG+/FzNqtrQ=");
		egovCryptoConfig.setCryptoBlockSize(1024);
		egovCryptoConfig.setCryptoPropertyLocation("classpath:/egovframework/egovProps/globals.properties");
		return egovCryptoConfig;
	}
	
	@Bean
	public EgovPasswordEncoder egovEnvPasswordEncoderService() {
		EgovCryptoConfig egovCryptoConfig = egovCryptoConfig();
		EgovPasswordEncoder egovPasswordEncoder = new EgovPasswordEncoder();
		egovPasswordEncoder.setAlgorithm(egovCryptoConfig.getAlgorithm());
		egovPasswordEncoder.setHashedPassword(egovCryptoConfig.getAlgorithmKeyHash());
		return egovPasswordEncoder;
	}
	
	@Bean
	public EgovARIACryptoServiceImpl egovEnvARIACryptoService() {
		EgovARIACryptoServiceImpl egovARIACryptoService = new EgovARIACryptoServiceImpl();
		egovARIACryptoService.setPasswordEncoder(egovEnvPasswordEncoderService());
		egovARIACryptoService.setBlockSize(egovCryptoConfig().getCryptoBlockSize());
		return egovARIACryptoService;
	}
	
	@Bean
	public EgovPropertyServiceImpl egovEnvCryptoConfigurerService() {
		EgovPropertyServiceImpl egovPropertyService = new EgovPropertyServiceImpl();
		Map<String, String> entryMap = new HashMap<>(2);
		entryMap.put("encoding", "UTF-8");
		entryMap.put("filename", egovCryptoConfig().getCryptoPropertyLocation());
		Set<Map<String, String>> set = new HashSet<>();
		set.add(entryMap);
		egovPropertyService.setExtFileName(set);
		return egovPropertyService;
	}
	
	@Bean
	public EgovEnvCryptoServiceImpl egovEnvCryptoService() {
		EgovCryptoConfig egovCryptoConfig = egovCryptoConfig();
		EgovEnvCryptoServiceImpl egovEnvCryptoService = new EgovEnvCryptoServiceImpl();
		egovEnvCryptoService.setCrypto(egovCryptoConfig.isCrypto());
		egovEnvCryptoService.setCryptoAlgorithm(egovCryptoConfig.getAlgorithm());
		egovEnvCryptoService.setCyptoAlgorithmKey(egovCryptoConfig.getAlgorithmKey());
		egovEnvCryptoService.setCyptoAlgorithmKeyHash(egovCryptoConfig.getAlgorithmKeyHash());
		egovEnvCryptoService.setCryptoBlockSize(egovCryptoConfig.getCryptoBlockSize());
		egovEnvCryptoService.setCryptoConfigurer(egovEnvCryptoConfigurerService());
		egovEnvCryptoService.setPasswordEncoder(egovEnvPasswordEncoderService());
		egovEnvCryptoService.setCryptoService(egovEnvARIACryptoService());
		return egovEnvCryptoService;
	}
	
}
