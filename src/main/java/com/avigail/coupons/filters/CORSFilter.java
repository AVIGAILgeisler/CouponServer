package com.avigail.coupons.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class CORSFilter implements Filter {

    public CORSFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // Authorize (allow) all domains to consume the content  		http://localhost:4200
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin","*");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST, DELETE");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers","password,authorization, Origin, Accept, x-auth-token, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

        //HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
        if (request.getMethod().equals("OPTIONS")) {
            return;
        }

        // pass the request along the filter chain
        chain.doFilter(request, servletResponse);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}