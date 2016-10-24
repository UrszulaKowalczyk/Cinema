package pl.projekty.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home","/myCSS.css","/reserve", "/date", "/film", "/hour", "/places", "/principal", "/final", "/backToStart").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin().successForwardUrl("/loggedIn")
                .loginPage("/login")
                .permitAll()
                .and()
            .logout().logoutSuccessUrl("/").logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("admin1").password("password1").roles("USER");
        auth
        	.inMemoryAuthentication()
            	.withUser("admin2").password("password2").roles("USER");
        
    }
}
