package cn.ljzyemu.iloveweb.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author :ljz
 * @Date :2018/6/2  9:51
 **/
@Configuration
public class CorsConfig  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response =(HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Method","POST,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Allow-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Hreaders","Origin,X-Requested-With, Content-Type, Accept, Cache-Control");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
