package org.poem.config.filter;

import com.google.common.collect.Maps;
import org.poem.utils.CenterContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;


/**
 * @author sangfor
 */
@Component
@Order(-1)
public class CenterFilterContext implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CenterFilterContext.class);

    /**
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //继续下发
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        CenterContextHolder.setMethod(method);
        if ("OPTIONS".equalsIgnoreCase(method)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String serverPth = httpServletRequest.getServletPath();
        //doc.html, swagger-ui.html
        if (serverPth.endsWith(".html") || serverPth.endsWith(".ico") || serverPth.endsWith(".js")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        CenterContextHolder.setRequestPath(serverPth);
        //获取所有的请求参数
        Map<String, Object> paraMaps = Maps.newHashMap();
        Map<String, Object> headerMaps = Maps.newHashMap();
        Enumeration<String> paraNames = httpServletRequest.getParameterNames();
        for (Enumeration<String> e = paraNames; e.hasMoreElements(); ) {
            String thisName = e.nextElement();
            String thisValue = httpServletRequest.getParameter(thisName);
            paraMaps.put(thisName, thisValue);
        }
        //获取所有的头部参数
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        for (Enumeration<String> e = headerNames; e.hasMoreElements(); ) {
            String thisName = e.nextElement();
            String thisValue = httpServletRequest.getHeader(thisName);
            headerMaps.put(thisName, thisValue);
        }
        CenterContextHolder.setParams(paraMaps);
        CenterContextHolder.setHeader(headerMaps);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     *
     */
    @Override
    public void destroy() {
        CenterContextHolder.remove();
    }
}
