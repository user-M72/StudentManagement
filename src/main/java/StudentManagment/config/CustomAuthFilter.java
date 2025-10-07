package StudentManagment.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class CustomAuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String authHeader = httpRequest.getHeader("Authentication");

        if(authHeader != null) {
            String jwtToken = authHeader.substring(7);
            Authentication authentiation = findUserByTokenCredentials(jwtToken);
            SecurityContextHolder.getContext().setAuthentication(authentiation);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
