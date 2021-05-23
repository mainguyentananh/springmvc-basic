package demo2.nienluan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import demo2.nienluan.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
    private UserDetailsServiceImpl usv;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
	
	@Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usv);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
	

	
	  @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authProvider());
	 
	    }
	  
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	 
	        http.csrf().disable();
	 

	        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
	
	      
	      
	        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
	 
	       
	        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
	 
	
	        http.authorizeRequests().and().formLogin()
	        		.loginPage("/login")
	                .loginProcessingUrl("/j_spring_security_check")	               
	                .usernameParameter("username")
	                .passwordParameter("password")
	                .defaultSuccessUrl("/home")
	                .failureUrl("/login?error=true")
	                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
	        
	        
	        }
	

}
