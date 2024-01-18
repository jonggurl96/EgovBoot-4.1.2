package egovframework.config.mybatis;


import org.egovframe.rte.psl.dataaccess.mapper.MapperConfigurer;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * EgovConfigMapper.java
 * <pre>
 * MyBatis, @Mapper annotation 적용을 위한 설정 파일
 * </pre>
 *
 * @author jongg
 * @version 1.0.0
 * @since 2024-01-16
 */
@Configuration
public class EgovConfigMapper {
	
	@Bean
	public SqlSessionFactoryBean sqlSession(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSession = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver pmpr = new PathMatchingResourcePatternResolver();
		sqlSession.setDataSource(dataSource);
		sqlSession.setMapperLocations(pmpr.getResources("classpath*:/egovframework/mapper/**/*.xml"));
		sqlSession.setTypeAliasesPackage("egovframework.**.dto;egovframework.**.vo;");
		
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setJdbcTypeForNull(null);
		sqlSession.setConfiguration(configuration);
		
		return sqlSession;
	}
	
	@Bean
	public MapperConfigurer mapperConfigurer() {
		MapperConfigurer mapperConfigurer = new MapperConfigurer();
		mapperConfigurer.setBasePackage("egovframework.**.mapper");
		return mapperConfigurer;
	}
}
