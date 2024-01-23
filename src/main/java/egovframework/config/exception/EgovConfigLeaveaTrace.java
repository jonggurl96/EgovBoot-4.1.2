package egovframework.config.exception;


import org.egovframe.rte.fdl.cmmn.trace.LeaveaTrace;
import org.egovframe.rte.fdl.cmmn.trace.handler.DefaultTraceHandler;
import org.egovframe.rte.fdl.cmmn.trace.handler.TraceHandler;
import org.egovframe.rte.fdl.cmmn.trace.manager.DefaultTraceHandleManager;
import org.egovframe.rte.fdl.cmmn.trace.manager.TraceHandlerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;

@Configuration
public class EgovConfigLeaveaTrace {
	
	/**
	 * Antpath Match Bean
	 */
	@Bean(name = {"antPathMatcher", "egov.antPathMatcher"})
	public AntPathMatcher antPathMatcher() {
		return new AntPathMatcher();
	}
	
	/**
	 * Deafult trace Handler Bean
	 */
	@Bean
	public DefaultTraceHandler defaultTraceHandler() {
		return new DefaultTraceHandler();
	}
	
	/**
	 * Trace Handler Service Bean
	 */
	@Bean
	public DefaultTraceHandleManager traceHandlerService() {
		DefaultTraceHandleManager defaultTraceHandleManager = new DefaultTraceHandleManager();
		defaultTraceHandleManager.setReqExpMatcher(antPathMatcher());
		defaultTraceHandleManager.setPatterns(new String[]{"*"});
		defaultTraceHandleManager.setHandlers(new TraceHandler[]{defaultTraceHandler()});
		return defaultTraceHandleManager;
	}
	
	/**
	 * Leavea Trace Bean, 후처리 로직
	 */
	@Bean
	public LeaveaTrace leaveaTrace() {
		LeaveaTrace leaveaTrace = new LeaveaTrace();
		leaveaTrace.setTraceHandlerServices(new TraceHandlerService[]{traceHandlerService()});
		return leaveaTrace;
	}
}
