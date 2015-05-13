package sboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Created by sohail on 13/05/15.
 */
@Configuration
@EnableWebMvcSecurity  //creates a bunch of beans
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("------------------------before configure");
        http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin();
        System.out.println("------------------------after configure");
    }






    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            System.out.println("------------------------before auth");
            auth
                    .ldapAuthentication()
                    .userDnPatterns("uid={0},ou=people")
                    .groupSearchBase("ou=groups")
                    .contextSource().ldif("classpath:test-server.ldif");
            System.out.println("------------------------after auth");
            //searches
            // uid={0},ou=people,dc=springframework,dc=org
            // in the LDAP server.
            //LDIF = LDIF (LDAP Data Interchange Format)
        }
    }
}
