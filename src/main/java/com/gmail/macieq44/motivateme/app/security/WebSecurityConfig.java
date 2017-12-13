package com.gmail.macieq44.motivateme.app.security;

import com.gmail.macieq44.motivateme.app.MotivateMeApplication;
import com.gmail.macieq44.motivateme.backend.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;
    private final RedirectAuthenticationSuccessHandler successHandler;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, RedirectAuthenticationSuccessHandler successHandler) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.successHandler = successHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity.authorizeRequests();

        registry = registry.antMatchers("/**").hasAnyAuthority(Role.getRoles());

        HttpSecurity sec = registry.and();

        FormLoginConfigurer<HttpSecurity> login = sec.formLogin().permitAll();
        login = login.loginPage(MotivateMeApplication.LOGIN_URL).loginProcessingUrl(MotivateMeApplication.LOGIN_PROCESSING_URL).failureUrl(MotivateMeApplication.LOGIN_FAILURE_URL).successHandler(successHandler);
        login.and().logout().logoutSuccessUrl(MotivateMeApplication.LOGOUT_URL);



    }
}
