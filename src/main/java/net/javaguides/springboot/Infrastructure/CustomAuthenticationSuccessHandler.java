package net.javaguides.springboot.Infrastructure;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_DEPARTAMENTO")) {
            response.sendRedirect("/view-departament");
        }

        if (roles.contains("ROLE_ADMINISTRADOR")) {
            response.sendRedirect("/view-admin");
        }

        if (roles.contains("ROLE_ASPIRANTE")) {
            System.out.println("Entered into of this handler!");
            response.sendRedirect("/registration");
        }
    }

}
