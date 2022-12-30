package cn.edu.whu.library.common.springsecurity.config;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;

public class AccountAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    @Override
    protected String obtainUsername(HttpServletRequest request)
    {
        String username = request.getParameter(getUsernameParameter());
        String account = request.getParameter("account");
        String combinedUsername = username + "," + username;
        return combinedUsername;
    }
}