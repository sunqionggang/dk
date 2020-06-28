package dockerproj.dkject.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(getHandleInterceptor()).addPathPatterns("/*");
    }

    @Bean
    private static HandlerInterceptor  getHandleInterceptor(){
        return new MyHandleInterceptor();
    }
}
