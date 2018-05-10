package com.panhb.config;

import com.panhb.interceptor.UrlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author panhb
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
	
	@Autowired
	UrlInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 多个拦截器组成一个拦截器链
		 * addPathPatterns 用于添加拦截规则
		 * excludePathPatterns 用于排除拦截
		 */
		registry.addInterceptor(interceptor).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

}
