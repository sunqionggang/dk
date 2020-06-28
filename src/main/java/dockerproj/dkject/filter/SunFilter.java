package dockerproj.dkject.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "sqg",urlPatterns = {"/pathVar/*"})
public class SunFilter implements Filter {
    Logger log= LoggerFactory.getLogger(SunFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter 处理中");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }
}
