package sboot;


// Created by sohail on 15/05/15.


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// see http://docs.spring.io/autorepo/docs/spring-security/3.2.0.RELEASE/apidocs/org/springframework/security/config/annotation/web/configuration/EnableWebSecurity.html
@Configuration
@EnableWebSecurity //Why is this not used in: https://gerrydevstory.com/2015/03/19/setting-up-spring-security-on-spring-boot-project/
//what is this? //@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class BcwSecurityConfig extends WebSecurityConfigurerAdapter {

    //Why do we have two config() for WebSecurity and HttpSecurity
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                        // Spring Security should completely ignore URLs starting with /resources/
                .antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().hasRole("USER")
                .and()
                        // Possibly more configuration ...
                .formLogin() // enable form based log in
                        // set permitAll for all URLs associated with Form Login
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        try {
            auth
                    // enable in memory based authentication with a user named "user" and "admin"
                    .inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER").and()
                    .withUser("admin").password("password").roles("USER", "ADMIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Possibly more overridden methods ...
}
