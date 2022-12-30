package cn.edu.whu.library.common.springsecurity.config;

import cn.edu.whu.library.modules.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private BackdoorAuthenticationProvider backdoorAuthenticationProvider;
    @Autowired
    private ReaderService readerService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 将自定义的验证类注册进去
        auth.authenticationProvider(backdoorAuthenticationProvider);
        // 数据库验证类
        auth.userDetailsService(readerService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index", "/error").permitAll()
                .antMatchers("/user/**", "/reader/**").hasAnyRole("STUDENT", "FACULTY", "STAFF")
                .antMatchers("/admin/**", "/reserve/**").hasAnyRole("FACULTY", "STAFF")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/user")
                // 自定义参数用户名密码
                .usernameParameter("myusername").passwordParameter("mypassword")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }


}
