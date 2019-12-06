package br.edu.ifsp.projeto.EOL.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new DummyPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.antMatchers("/relatorio", "/relatorio/**")
            		.hasAuthority("ROLE_ADMIN")
            	.antMatchers("/cadastraros")
            		.hasAuthority("ROLE_USER")
            	.antMatchers("/veros", "/veros/**")
            		.hasAuthority("ROLE_INSTALADOR")
            	.antMatchers("/api", "/api/**", "/apiExecucao", "/apiExecucao/**")
            		.hasAuthority("ROLE_INSTALADOR")
            	.antMatchers("/", "/**", "/cadastrarcliente", "/cadastrarinstalador")
            		.permitAll()
            	.and()
            .formLogin()
	            .loginPage("/login")
	            .permitAll()
	            .and()
            .logout()
	            .permitAll()
	            .and()
            .csrf().ignoringAntMatchers("/h2-console/**", "/api/**")
            	.and()
            .headers().frameOptions().sameOrigin();
    }
}
