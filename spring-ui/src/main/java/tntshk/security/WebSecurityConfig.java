package tntshk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/error").authenticated()
                .antMatchers("/routes", "/payments").hasRole("CLIENT")
                .antMatchers("/registerClient").hasRole("MANAGER")
                .antMatchers("/registerManager").hasRole("ROOT")
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("client").password("{noop}client").roles("CLIENT", "USER")
                .and()
                .withUser("manager").password("{noop}manager").roles("MANAGER", "CLIENT", "USER")
                .and()
                .withUser("root").password("{noop}root").roles("ROOT", "MANAGER", "CLIENT", "USER");
    }
}
